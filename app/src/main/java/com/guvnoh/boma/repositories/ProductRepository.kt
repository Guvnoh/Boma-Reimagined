package com.guvnoh.boma.repositories

import android.content.Context
import android.util.Log
import com.guvnoh.boma.database.FirebaseRefs
import com.guvnoh.boma.models.Product
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.guvnoh.boma.R
import com.guvnoh.boma.models.EmptiesStock

class ProductsRepository {

    private val warehouseProductsRepo = FirebaseRefs.warehouseFulls

    private val headOfficeProductsRepo = FirebaseRefs.HeadOfficeFulls

    private val productsRepo = FirebaseRefs.displayProductsRepo

    private var listener: ValueEventListener? = null


     // Observe products in realtime
    fun observeProducts(
         repo: DatabaseReference,
        onChange: (List<Product>) -> Unit
    ) {
        listener?.let { repo.removeEventListener(it) }

        listener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val products = snapshot.children.mapNotNull { child ->
                    child.getValue(Product::class.java)
                }
                onChange(products.filter { it.id!=null })
            }

            override fun onCancelled(error: DatabaseError) {
                // log if needed
            }
        }

        repo.addValueEventListener(listener!!)
    }

    fun getDBProductList(onListReady: (MutableList<Product>) -> Unit) {

        FirebaseRefs.HeadOfficeFulls.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val brandList = mutableListOf<Product>()
                for (eachBrand in snapshot.children) {

                    val product = eachBrand.getValue(Product::class.java)
                    val soldTodayDB = eachBrand
                        .child("stock")
                        .child("soldToday")
                        .getValue(Double::class.java)
                    if (product!=null){
                        if (soldTodayDB!=null) product.stock?.soldToday = soldTodayDB
                        if (product.doublePrice==null)product.doublePrice = product.stringPrice?.toDouble()
                        brandList.add(product)
                    }
                }
                onListReady(brandList)
            }

            override fun onCancelled(error: DatabaseError) {
                // handle error if needed
                Log.d("DB_getBottlesList_ERR", "onCancelled: $error")
            }
        })
    }



    fun getDBaseEmptiesStock(callback: (MutableList<EmptiesStock>) -> Unit) {

        FirebaseRefs.empties.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val stockList = mutableListOf<EmptiesStock>()
                for (product in snapshot.children) {
                    val stock = product.getValue(EmptiesStock::class.java)
                    if (stock!=null){
                        stockList.add(stock)
                    }
                }
                callback(stockList)
            }

            override fun onCancelled(error: DatabaseError) {
                // handle error if needed
                Log.d("DB_getDBStock_ERR", "onCancelled: $error")
            }
        })
    }



    fun getImage(context: Context, name: String):Int{
        val resId = (context.resources.getIdentifier(name,"drawable",context.packageName))
        return if(resId !=0)resId else R.drawable.bottle
    }



    // Add new product
    fun addProduct(product: Product) {
        val key = productsRepo.push().key.toString()
         product.id = key
        productsRepo.child(key).setValue(product)
        warehouseProductsRepo.child(key).setValue(product)
        headOfficeProductsRepo.child(key).setValue(product)
    }


     // Update price
    fun updatePrice(product: Product) {
        val reposToUpdate = listOf(productsRepo, warehouseProductsRepo, headOfficeProductsRepo)

         reposToUpdate.forEach {
             it.child(product.id?:"error")
             .child("stringPrice")
             .setValue(product.stringPrice)

             it.child(product.id?:"error")
             .child("doublePrice")
             .setValue(product.doublePrice)
         }
    }


     // Delete product completely
    fun deleteProduct(productId: String) {
         val reposToUpdate = listOf(productsRepo, warehouseProductsRepo, headOfficeProductsRepo)
         reposToUpdate.forEach {
             it.child(productId)
             .removeValue()
         }

    }


     // Call this when ViewModel is cleared
    fun clear() {
        listener?.let { productsRepo.removeEventListener(it) }
        listener = null
    }
}
