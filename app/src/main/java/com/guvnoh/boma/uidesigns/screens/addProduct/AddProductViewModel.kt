package com.guvnoh.boma.uidesigns.screens.addProduct

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.guvnoh.boma.R
import com.guvnoh.boma.database.FirebaseRefs
import com.guvnoh.boma.models.ProductType
import com.guvnoh.boma.models.Products
import com.guvnoh.boma.models.Screen
import com.guvnoh.boma.repositories.ProductsRepository

class AddProductViewModel: ViewModel() {
    private val _newProduct: MutableState<Products> = mutableStateOf(Products())
    val newProduct = _newProduct
//    private val _productName: MutableState<String> = mutableStateOf("")
//    val productName = _productName
//
//    private val _productPrice: MutableState<String> = mutableStateOf("")
//    val productPrice = _productPrice
//
//    private val _category: MutableState<ProductType> = mutableStateOf(ProductType.BOTTLE)
//    val category = _category

    private val repository = ProductsRepository()

//    private val _productType: MutableState<String> = mutableStateOf("")
//    val productType = _productType

//    fun setProductParams(
//        type: ProductParameters, value: String){
//        val parameter = when(type){
//            ProductParameters.NAME -> _productName.value = value
//            ProductParameters.PRICE -> _productPrice.value = value
//            ProductParameters.CATEGORY -> _category.value = value
//        }
//    }
    fun addProduct(product: Products) {
        repository.addProduct(product)
    }

    fun validateEntries(
        entryName: String,
        entryValue: String?
    ): String?{
        entryValue?.let { if (it.isBlank()) return "$entryName is required!"}
        return null
    }

    fun createNewProduct(
        navController: NavController,
        ): String?{
        val nameError = validateEntries("Name",newProduct.value.name)
        val priceError = validateEntries("Price",newProduct.value.stringPrice)
        when {
            nameError != null -> return "Name is required"
            priceError != null -> return "Price is required"
            else -> {
                addProduct(newProduct.value)
                navController.navigate(Screen.Products.route) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        inclusive = true
                    }
                    launchSingleTop = true
                }
                return  null
            }
        }
    }

}