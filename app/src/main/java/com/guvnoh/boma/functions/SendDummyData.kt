package com.guvnoh.boma.functions

import com.guvnoh.boma.database.FirebaseRefs
import com.guvnoh.boma.models.Product
import com.guvnoh.boma.models.brandData

object SendDummyData {
    fun sendFullsDataToDB(){
        val list = brandData

        list.forEach {
            val random1 = (20..800).random()
            val random2 = (20..800).random()
            FirebaseRefs.fullStock
                .child(it.name?:"unknown")
                .setValue(it)
        }

    }
    fun createNewFullsStock(products: List<Product>){
        products.forEach { product ->
            product.id?.let { productId ->

                //populate 'root.bomastock.warehouse.fulls' with fulls stock data
                FirebaseRefs.warehouseFulls
                    .child(productId).setValue(product)

                //populate 'root.bomastock.headoffice.fulls' with fulls stock data
                FirebaseRefs.HeadOfficeFulls
                    .child(productId).setValue(product)
            }
        }

    }
}