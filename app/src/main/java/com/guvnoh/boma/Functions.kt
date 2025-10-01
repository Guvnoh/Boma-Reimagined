package com.guvnoh.boma

import android.content.Context
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.guvnoh.boma.models.Product
import com.guvnoh.boma.models.SortCategory
import com.guvnoh.boma.models.cans
import com.guvnoh.boma.models.cocacolaBottles
import com.guvnoh.boma.models.getSortedBrandData
import com.guvnoh.boma.models.guinness
import com.guvnoh.boma.models.hero
import com.guvnoh.boma.models.nbl
import com.guvnoh.boma.models.pets

val bomaBrands = databasePrices
fun getDatabaseProductList(callback: (MutableList<Product>) -> Unit) {

    bomaBrands.addValueEventListener(object : ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
            val brandList = mutableListOf<Product>()
            for (eachBrand in snapshot.children) {
                val brand = eachBrand.key.toString()
                val product = eachBrand.getValue(Product::class.java)
                if (product!=null){
                    brandList.add(product)
                }
            }
            callback(brandList)
        }

        override fun onCancelled(error: DatabaseError) {
            // handle error if needed
        }
    })
}

fun pushData(list: List<Product>){
    list.forEach {
        bomaBrands.child(it.name)
            .setValue(it)
    }
}

fun getUpdatedDisplayList(databaseList: MutableList<Product>):MutableList<Product>{
    var sortedProducts = mutableListOf<Product>()
    val other: MutableList<Product> = mutableListOf()

    for (product in databaseList) {
        //this code block primarily adds new products to the UI
        // and sorts them according to their category
        //val insertIndex = display.indexOfLast { it.category == newProduct.category }
        // Finds the index of the last item with same category

        when(product.sortCategory){
            SortCategory.NBL -> {
                nbl.add(product)
                nbl.sortBy { it.name }
            }
            SortCategory.HERO -> {
                hero.add(product)
                hero.sortBy { it.name }
            }
            SortCategory.GUINNESS -> {
                guinness.add(product)
                guinness.sortBy { it.name }
            }
            SortCategory.COCACOLA -> {
                cocacolaBottles.add(product)
                cocacolaBottles.sortBy { it.name }
            }
            SortCategory.CANS -> {
                cans.add(product)
                cans.sortBy { it.name }
            }
            SortCategory.PETS -> {
                pets.add(product)
                pets.sortBy { it.name }
            }

            SortCategory.OTHER -> other.add(product)
        }

    }
    sortedProducts.addAll(other)
    sortedProducts.sortedBy { it.sortCategory }
    return sortedProducts
}


fun getImage(context: Context, name: String):Int{
    val resId = (context.resources.getIdentifier(name,"drawable",context.packageName))
    return if(resId !=0)resId else R.drawable.bottle
}