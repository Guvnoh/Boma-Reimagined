package com.guvnoh.boma.repositories

import com.guvnoh.boma.database.FirebaseRefs
import com.guvnoh.boma.models.FullsStock
import com.google.firebase.database.*
import com.guvnoh.boma.models.EmptiesStock
import com.guvnoh.boma.models.Products
import com.guvnoh.boma.uidesigns.screens.stock.Store

class StockRepository() {

    private val productsRef = FirebaseRefs.Products
    private val emptiesRef = FirebaseRefs.empties

    private var productsListener: ValueEventListener? = null
    private var emptiesListener: ValueEventListener? = null


    // OBSERVE FULLS STOCK
    fun observeFullsStock(
        store: Store,
        onChange: (MutableMap<String, Pair<Products, FullsStock>>) -> Unit,
    ){
        var listener = productsListener
        listener?.let { FirebaseRefs.Products.removeEventListener(it) }

        listener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val products = snapshot.children.mapNotNull { child ->
                    child.getValue(Products::class.java)
                }
                val stockMap: MutableMap<String, Pair<Products,FullsStock>> = mutableMapOf()
                when (store){
                    Store.WAREHOUSE -> {
                        products.forEach { product ->

                            val stock = product.store?.warehouse ?: FullsStock()
                            stockMap[product.id?:""] = Pair(product, stock)
                        }
                    }
                    Store.HEAD_OFFICE -> {
                        products.forEach { product ->

                            val stock = product.store?.headOffice ?: FullsStock()
                            stockMap[product.id?:""] = Pair(product, stock)
                        }
                    }
                }

                onChange(stockMap)
            }

            override fun onCancelled(error: DatabaseError) = Unit
        }

        productsRef.addValueEventListener(listener)
    }

    fun updateStock(productId: String, store: Store, newStock: Double? = null){
        val dbStore = when(store){
            Store.WAREHOUSE -> "warehouse"
            else -> "headOffice"
        }
        val product = FirebaseRefs.testProducts.child(productId)
        val stock = product
            .child("store")
            .child(dbStore)
            .child("closingStock")

        stock.setValue(newStock)
    }



    // OBSERVE EMPTIES
    fun observeEmptiesStock(
        onChange: (Map<String, EmptiesStock>) -> Unit
    ) {
        emptiesListener?.let { emptiesRef.removeEventListener(it) }

        emptiesListener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val result = mutableMapOf<String, EmptiesStock>()

                snapshot.children.forEach { productSnap ->
                    val productId = productSnap.key ?: return@forEach
                    val empty = productSnap.getValue(EmptiesStock::class.java)
                        ?: EmptiesStock()

                    result[productId] = empty
                }

                onChange(result)
            }

            override fun onCancelled(error: DatabaseError) = Unit
        }

        emptiesRef.addValueEventListener(emptiesListener!!)
    }


    // SELL PRODUCT
    fun sellProduct(
        productId: String,
        soldQty: Double,
        store: String
    ) {
        if (soldQty <= 0) return

        val stockRef = when(store){
            "warehouse" -> FirebaseRefs.Products.child(productId).child("store").child("warehouse")
            "headOffice" -> FirebaseRefs.Products.child(productId).child("store").child("headOffice")
            else -> FirebaseRefs.Products.child(productId).child("store").child("warehouse")
        }

        stockRef.runTransaction(object : Transaction.Handler {
            override fun doTransaction(data: MutableData): Transaction.Result {
                val stock = data.getValue(FullsStock::class.java)
                    ?: FullsStock()

                val opening = stock.openingStock ?: 0.0
                val currentClosing =
                    stock.closingStock ?: opening

                if (currentClosing < soldQty) {
                    return Transaction.abort()
                }

                stock.soldToday =
                    (stock.soldToday ?: 0.0) + soldQty

                stock.closingStock =
                    (currentClosing - soldQty).coerceAtLeast(0.0)

                data.value = stock
                return Transaction.success(data)
            }

            override fun onComplete(
                error: DatabaseError?,
                committed: Boolean,
                snapshot: DataSnapshot?
            ) = Unit
        })
    }

    // UPDATE EMPTIES
    fun updateEmpties(
        productId: String,
        delta: Double
    ) {
        val emptyRef = emptiesRef.child(productId)

        emptyRef.runTransaction(object : Transaction.Handler {
            override fun doTransaction(data: MutableData): Transaction.Result {
                val empty = data.getValue(EmptiesStock::class.java)
                    ?: EmptiesStock()

                empty.quantity =
                    ((empty.quantity ?: 0.0) + delta).coerceAtLeast(0.0)

                data.value = empty
                return Transaction.success(data)
            }

            override fun onComplete(
                error: DatabaseError?,
                committed: Boolean,
                snapshot: DataSnapshot?
            ) = Unit
        })
    }

    // CLEANUP
    fun clear(repo: DatabaseReference) {
        productsListener?.let { FirebaseRefs.Products.removeEventListener(it) }
        emptiesListener?.let { emptiesRef.removeEventListener(it) }

        productsListener = null
        emptiesListener = null
    }
}

