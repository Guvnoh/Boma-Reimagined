package com.guvnoh.boma.repositories

import android.content.Context
import android.util.Log
import com.guvnoh.boma.database.FirebaseRefs
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.guvnoh.boma.R
import com.guvnoh.boma.models.EmptiesStock
import com.guvnoh.boma.models.ProductType
import com.guvnoh.boma.models.Products

class ProductsRepository {

    private val productsRepo = FirebaseRefs.Products

    private var listener: ValueEventListener? = null


     // Observe products in realtime
    fun observeProducts(
         repo: DatabaseReference,
        onChange: (List<Products>) -> Unit
    ) {
        listener?.let { repo.removeEventListener(it) }

        listener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val products = snapshot.children.mapNotNull { child ->
                    child.getValue(Products::class.java)
                }
                onChange(products.filter { it.id!=null })
            }

            override fun onCancelled(error: DatabaseError) {
                // log if needed
            }
        }

        repo.addValueEventListener(listener!!)
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



    fun getImage(context: Context, name: String, type: ProductType):Int{
        val resId = (context.resources.getIdentifier(name,"drawable",context.packageName))
        return if(resId !=0)
            resId
        else if (type == ProductType.CAN) R.drawable.can_image
        else R.drawable.bottle
    }



    // Add new product
    fun addProduct(product: Products) {
        val key = productsRepo.push().key.toString()
         product.id = key
        product.id?.let { productsRepo.child(it).setValue(product)}
    }



     // Delete product completely
    fun deleteProduct(productId: String) {
         productsRepo.child(productId).removeValue()
    }


     // Call this when ViewModel is cleared
    fun clear() {
        listener?.let { productsRepo.removeEventListener(it) }
        listener = null
    }
}
