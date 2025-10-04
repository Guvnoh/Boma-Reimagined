package com.guvnoh.boma.models

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.guvnoh.boma.getDatabaseProductList
import com.guvnoh.boma.getUpdatedDisplayList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class BomaViewModel : ViewModel() {
    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = getProductList()
    private val _soldProducts = MutableStateFlow<List<SoldProduct>>(emptyList())
    val soldProducts: StateFlow<List<SoldProduct>> = _soldProducts
    private val _customerName = mutableStateOf("")
    var customerName: State<String> = _customerName
    private val _priceChangeProducts = MutableStateFlow<List<Product>>(emptyList())
    val priceChangeProducts: StateFlow<List<Product>> = _priceChangeProducts

    fun addToPriceChangeList(product: Product, newPrice: String ){
        val current = _priceChangeProducts.value.toMutableList()
        product.stringPrice = newPrice
        current.add(product)
        _priceChangeProducts.value = current
    }


    private fun getProductList(): StateFlow<List<Product>>{
        getDatabaseProductList {
            dbList ->
            getUpdatedDisplayList(dbList)
            _products.value = dbList
        }
        return _products
    }
    fun updateCustomerName(name: String){
        _customerName.value = name
    }

    fun addProduct(soldProduct: SoldProduct?) {
        val current = _soldProducts.value.toMutableList()
        val validSoldProduct = soldProduct ?: return

        // If product already exists, replace it instead of duplicating
        val existingIndex = current.indexOfFirst { it.product.name == validSoldProduct.product.name }
        if (existingIndex >= 0 ) {
            current[existingIndex] = validSoldProduct
        } else {
            current.add(validSoldProduct)
        }

        _soldProducts.value = current.toList() // ✅ new list triggers recomposition
    }

    fun removeProduct(soldProduct: SoldProduct?) {
        val current = _soldProducts.value.toMutableList()
        val validSoldProduct = soldProduct ?: return
        current.removeAll { it.product.name == validSoldProduct.product.name }
        _soldProducts.value = current.toList()
    }

    fun clearTotals() {
        _soldProducts.value = emptyList()
    }

    fun clearName(){
        _customerName.value = ""
    }

    fun getGrandTotal(): Int {
        return _soldProducts.value.sumOf { it.intTotal}
    }
}

