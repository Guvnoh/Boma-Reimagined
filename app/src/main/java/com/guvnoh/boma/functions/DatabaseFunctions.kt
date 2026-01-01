package com.guvnoh.boma.functions

import android.content.Context
import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.guvnoh.boma.R
import com.guvnoh.boma.database.FirebaseRefs
import com.guvnoh.boma.models.Product
import com.guvnoh.boma.models.EmptiesStock

fun getDBProductList(onListReady: (MutableList<Product>) -> Unit) {

    FirebaseRefs.fullStock.addValueEventListener(object : ValueEventListener {
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
