package com.guvnoh.boma.functions

import com.google.firebase.database.DatabaseReference
import com.guvnoh.boma.database.FirebaseRefs
import com.guvnoh.boma.models.Product
import com.guvnoh.boma.models.brandData

object SendDummyData {

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