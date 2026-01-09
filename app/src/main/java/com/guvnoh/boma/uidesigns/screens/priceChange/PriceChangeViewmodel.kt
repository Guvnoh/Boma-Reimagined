package com.guvnoh.boma.uidesigns.screens.priceChange

import androidx.lifecycle.ViewModel
import com.google.firebase.database.DatabaseReference
import com.guvnoh.boma.database.FirebaseRefs
import com.guvnoh.boma.models.Products
import com.guvnoh.boma.repositories.ProductsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class PriceChangeViewmodel: ViewModel() {

    //product list
    private val _products = MutableStateFlow<List<Products>>(emptyList())
    val products: StateFlow<List<Products>> = _products

    //price change products
    private val _priceChangeProducts = MutableStateFlow<List<Products>>(emptyList())
    val priceChangeProducts: StateFlow<List<Products>> = _priceChangeProducts

    init {
        observeProducts(FirebaseRefs.Products)
    }

    private fun observeProducts(repo: DatabaseReference) {
        val repository = ProductsRepository()
        repository.observeProducts(repo) { list ->
            _products.value = list
        }
    }


    private fun addToPriceChangeList(product: Products, newPrice: String ){
        val current = _priceChangeProducts.value.toMutableList()
        product.stringPrice = newPrice
        current.add(product)
        _priceChangeProducts.value = current
    }

//    // price change
//    fun updatePrice(product: Products) {
//        val repository = ProductsRepository()
//        repository.updatePrice(product)
//    }

    // Update price
    fun updatePrice(product: Products) {
        val productsRepo = FirebaseRefs.Products
        // update string and double price of product parameter
        productsRepo.child(product.id ?: "error")
            .child("stringPrice")
            .setValue(product.stringPrice)

        productsRepo.child(product.id?:"error")
            .child("doublePrice")
            .setValue(product.doublePrice)

    }

    fun changePrices(newPrice: String, product: Products){
        val parsedNewPrice = newPrice.filter { ch -> ch.isDigit() || ch == '.' }
        val parsed = parsedNewPrice.toDoubleOrNull()
        if (parsed != null && parsed > 0.0) {
            product.stringPrice = newPrice
            product.doublePrice = parsed
            addToPriceChangeList(product, newPrice)
        }
    }

    fun errorCheck(newPrice: String): String?{
        val double = newPrice.toDoubleOrNull()
        val result = when{
            newPrice.isEmpty() -> "Empty Field"
            double == null -> "Invalid Price"
            double >= 0 -> null
            else -> "Invalid Price"
        }

        return  result
    }
}