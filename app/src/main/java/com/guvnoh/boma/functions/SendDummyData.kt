package com.guvnoh.boma.functions
import com.guvnoh.boma.database.FirebaseRefs

object SendDummyData {

//    private fun convertProductToProducts(product: Product, store: Store){
//        product.id?.let {
//            productId ->
//            FirebaseRefs.Products.child(productId).setValue(Products().copy(
//                name = product.name?:"error",
//                stringPrice = product.stringPrice?:"",
//                doublePrice = product.doublePrice?:0.0,
//                id = productId,
//                imageName = product.imageName?:"",
//                image = product.image?: R.drawable.bottle,
//                type = product.type?:ProductType.BOTTLE,
//                empties = product.empties,
//                store = store
//            ))
//        }
//    }
//
//    fun createNewFullsStock(wareHouse: List<Product>, headOffice: List<Product>){
//
//        wareHouse.forEach { product ->
//            val store = Store()
//            store.warehouse = product.stock
//            headOffice.forEach {
//                if (it == product){
//                    store.headOffice = it.stock
//                }
//            }
//            convertProductToProducts(product, store)
//        }
//
//
//
//    }

    fun cleardb(){
        FirebaseRefs.Products.removeValue()
    }
}