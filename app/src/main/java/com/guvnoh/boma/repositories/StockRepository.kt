//package com.guvnoh.boma.repositories
//
//import com.google.firebase.database.DataSnapshot
//import com.google.firebase.database.DatabaseError
//import com.google.firebase.database.MutableData
//import com.google.firebase.database.Transaction
//import com.google.firebase.database.ValueEventListener
//import com.guvnoh.boma.database.FirebaseRefs
//import com.guvnoh.boma.domain.DateProvider
//import com.guvnoh.boma.models.FullsStock
//import com.guvnoh.boma.models.Product
//
//
//class StockRepository {
//
//    private val stockRef = FirebaseRefs.fullStock
//
//    private var listener: ValueEventListener? = null
//
//
//
//    /**
//     * Observe products in realtime
//     */
//    fun observeProducts(
//        onChange: (Map<String, FullsStock>) -> Unit
//    ) {
//        listener?.let { stockRef.removeEventListener(it) }
//        val stockMap: MutableMap<String, FullsStock> = mutableMapOf()
//
//            listener = object : ValueEventListener {
//            override fun onDataChange(snapshot: DataSnapshot) {
//                snapshot.children.mapNotNull { child ->
//                    val product = child.getValue(Product::class.java)
//                    if (product?.stock != null){
//                        val stock= product.stock
//                        product.name?.let {
//                            if (stock != null) {
//                                stockMap[it] = stock
//                            }
//                        }
//                    }
//                }
//                onChange(stockMap)
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                // log if needed
//            }
//        }
//        stockRef.addValueEventListener(listener!!)
//    }
//
//    fun updateStockTransaction(
//        productId: String,
//        soldQty: Double
//    ) {
//        val stockRef = FirebaseRefs.fullStock
//            .child(productId)
//            .child("stock")
//
//        stockRef.runTransaction(object : Transaction.Handler {
//
//            override fun doTransaction(data: MutableData): Transaction.Result {
//                val stock = data.getValue(FullsStock::class.java)
//                    ?: return Transaction.success(data)
//
//                val currentClosing = stock.closingStock ?: stock.openingStock ?: 0.0
//
//                val closing = (currentClosing - soldQty).coerceAtLeast(0.0)
//
//
//
//                stock.closingStock = closing
//                stock.soldToday = (stock.soldToday ?: 0.0) + soldQty
//                stock.soldLast = soldQty
//                stock.lastTimeSold = DateProvider.todayString()
//
//                data.value = stock
//                return Transaction.success(data)
//            }
//
//            override fun onComplete(
//                error: DatabaseError?,
//                committed: Boolean,
//                snapshot: DataSnapshot?
//            ) = Unit
//        })
//    }
//
//    fun resetSoldToday() {
//        FirebaseRefs.fullStock.get().addOnSuccessListener { snapshot ->
//            snapshot.children.forEach { productSnap ->
//                val stockRef = productSnap.child("stock").ref
//
//                stockRef.runTransaction(object : Transaction.Handler {
//                    override fun doTransaction(data: MutableData): Transaction.Result {
//                        val stock = data.getValue(FullsStock::class.java)
//                            ?: return Transaction.success(data)
//
//                        stock.openingStock = stock.closingStock ?: 0.0
//                        stock.soldToday = 0.0
//
//                        data.value = stock
//                        return Transaction.success(data)
//                    }
//
//                    override fun onComplete(
//                        error: DatabaseError?,
//                        committed: Boolean,
//                        snapshot: DataSnapshot?
//                    ) = Unit
//                })
//            }
//        }
//    }
//}


package com.guvnoh.boma.repositories

import com.guvnoh.boma.database.FirebaseRefs
import com.guvnoh.boma.models.FullsStock
import com.google.firebase.database.*
import com.guvnoh.boma.models.EmptiesStock
import com.guvnoh.boma.models.Products
import com.guvnoh.boma.models.Store

class StockRepository() {

    private val products = FirebaseRefs.Products
    private val emptiesRef = FirebaseRefs.empties

    private var productsListener: ValueEventListener? = null
    private var emptiesListener: ValueEventListener? = null

    // ------------------------------------------------
    // FULLS STOCK (OBSERVE)
    // ------------------------------------------------


    fun observeFullsStock(
        store: String,
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
                    "warehouse" -> {
                        products.forEach { product ->

                            val stock = product.store?.warehouse ?: FullsStock()
                            stockMap[product.id?:""] = Pair(product, stock)
                        }
                    }
                    "headOffice" -> {
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

        products.addValueEventListener(listener)
    }

    // ------------------------------------------------
    // EMPTIES (OBSERVE)
    // ------------------------------------------------

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

    // ------------------------------------------------
    // SELL PRODUCT (ATOMIC & CORRECT)
    // ------------------------------------------------

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

    // ------------------------------------------------
    // UPDATE EMPTIES
    // ------------------------------------------------

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

    // ------------------------------------------------
    // DAILY RESET (CALLED BY AppMetaViewModel)
    // ------------------------------------------------


    // ------------------------------------------------
    // CLEANUP
    // ------------------------------------------------

    fun clear(repo: DatabaseReference) {
        productsListener?.let { FirebaseRefs.Products.removeEventListener(it) }
        emptiesListener?.let { emptiesRef.removeEventListener(it) }

        productsListener = null
        emptiesListener = null
    }
}

