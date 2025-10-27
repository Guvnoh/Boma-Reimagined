package com.guvnoh.boma.functions

import android.content.Context
import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.guvnoh.boma.R
import com.guvnoh.boma.database.DBBottleProducts
import com.guvnoh.boma.database.DBPetsAndCans
import com.guvnoh.boma.database.stockEmpties
import com.guvnoh.boma.database.stockFulls
import com.guvnoh.boma.models.BottleProduct
import com.guvnoh.boma.models.EmptiesStock
import com.guvnoh.boma.models.PetsAndCans
import com.guvnoh.boma.models.Product
import com.guvnoh.boma.models.FullsStock

fun getDBBottlesList(callback: (MutableList<BottleProduct>) -> Unit) {

    DBBottleProducts.addValueEventListener(object : ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
            val brandList = mutableListOf<BottleProduct>()
            for (eachBrand in snapshot.children) {
                val product = eachBrand.getValue(BottleProduct::class.java)
                if (product!=null){
                    brandList.add(product)
                }
            }
            callback(brandList)
        }

        override fun onCancelled(error: DatabaseError) {
            // handle error if needed
            Log.d("DB_getBottlesList_ERR", "onCancelled: $error")
        }
    })
}

fun getDBPetsAndCansList(callback: (MutableList<PetsAndCans>) -> Unit) {

    DBPetsAndCans.addValueEventListener(object : ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
            val brandList = mutableListOf<PetsAndCans>()
            for (eachBrand in snapshot.children) {
                val product = eachBrand.getValue(PetsAndCans::class.java)
                if (product!=null){
                    brandList.add(product)
                }
            }
            callback(brandList)
        }

        override fun onCancelled(error: DatabaseError) {
            Log.d("Data_Base_ERR", "onCancelled: $error")
        }
    })
}

fun getDatabaseFullsStock(callback: (MutableList<FullsStock>) -> Unit) {

    stockFulls.addValueEventListener(object : ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
            val stockList = mutableListOf<FullsStock>()
            for (product in snapshot.children) {
                val stock = product.getValue(FullsStock::class.java)
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

fun getDatabaseEmptiesStock(callback: (MutableList<EmptiesStock>) -> Unit) {

    stockEmpties.addValueEventListener(object : ValueEventListener {
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

fun pushData(group: String, list: List<Product>, root: DatabaseReference){
    list.forEach {
        root.child(group).child(it.name)
            .setValue(it)
    }
}

//fun sortedUpdatedProductList(databaseList: MutableList<Product>):MutableList<Product>{
//    val sortedProducts = mutableListOf<Product>()
//    val other: MutableList<Product> = mutableListOf()
//
//    for (product in databaseList) {
//        //this code block primarily adds new products to the UI
//        // and sorts them according to their category
//        //val insertIndex = display.indexOfLast { it.category == newProduct.category }
//        // Finds the index of the last item with same category
//
//        when(product.sortCategory){
//            SortCategory.NBL -> {
//                nbl.add(product)
//                nbl.sortBy { it.name }
//            }
//            SortCategory.HERO -> {
//                hero.add(product)
//                hero.sortBy { it.name }
//            }
//            SortCategory.GUINNESS -> {
//                guinness.add(product)
//                guinness.sortBy { it.name }
//            }
//            SortCategory.COCACOLA -> {
//                cocacolaBottles.add(product)
//                cocacolaBottles.sortBy { it.name }
//            }
//            SortCategory.CANS -> {
//                cans.add(product)
//                cans.sortBy { it.name }
//            }
//            SortCategory.PETS -> {
//                pets.add(product)
//                pets.sortBy { it.name }
//            }
//
//            SortCategory.OTHER -> other.add(product)
//        }
//
//    }
//    sortedProducts.addAll(other)
//    sortedProducts.sortedBy { it.sortCategory }
//    return sortedProducts
//}


fun getImage(context: Context, name: String):Int{
    val resId = (context.resources.getIdentifier(name,"drawable",context.packageName))
    return if(resId !=0)resId else R.drawable.bottle
}

//fun deleteProduct(product: Product){
//    DBBomaPrices.child(product.name).removeValue()
//}