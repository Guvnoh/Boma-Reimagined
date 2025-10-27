package com.guvnoh.boma.models

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.guvnoh.boma.functions.getDBBottlesList
import com.guvnoh.boma.functions.getDBPetsAndCansList
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
    private val _receipt = MutableStateFlow<Receipt?>(null)
    @RequiresApi(Build.VERSION_CODES.O)
    val receipt: StateFlow<Receipt?> = _receipt

    fun setCurrentReceipt(receipt: Receipt){
        _receipt.value = receipt
    }

    fun addToPriceChangeList(product: Product, newPrice: String ){
        val current = _priceChangeProducts.value.toMutableList()
        product.stringPrice = newPrice
        current.add(product)
        _priceChangeProducts.value = current
    }

//    private fun getProductList(): StateFlow<List<Product>>{
//        val bottles = getDBBottlesList()
//        val pets = getDBPetsAndCansList()
//        val list = mutableListOf<Product>()
//        list.addAll(bottles.value)
//        list.addAll(pets.value)
//        _products.value = list
//        return _products
//    }
//
//    private fun getDBBottlesList(): StateFlow<List<Product>>{
//
//        val list= MutableStateFlow<List<BottleProduct>>(emptyList())
//        getDBBottlesList{
//                dbList ->
//            list.value = dbList
//        }
//        return list
//    }
//
//    private fun getDBPetsAndCansList(): StateFlow<List<Product>>{
//        val list = MutableStateFlow<List<PetsAndCans>>(emptyList())
//        getDBPetsAndCansList {
//                dbList ->
//            list.value = dbList
//        }
//        return list
//    }
    private fun getProductList(): StateFlow<List<Product>> {
        val bottlesFlow = MutableStateFlow<List<Product>>(emptyList())
        val petsFlow = MutableStateFlow<List<Product>>(emptyList())

        // Fetch bottle products
        getDBBottlesList { dbList ->
            bottlesFlow.value = dbList
            updateCombinedProducts(bottlesFlow.value, petsFlow.value)
        }

        // Fetch pets and cans
        getDBPetsAndCansList { dbList ->
            petsFlow.value = dbList
            updateCombinedProducts(bottlesFlow.value, petsFlow.value)
        }

        return _products
    }

    private fun updateCombinedProducts(
        bottles: List<Product>,
        pets: List<Product>
    ) {
        val combined = mutableListOf<Product>()
        combined.addAll(bottles)
        combined.addAll(pets)
        _products.value = combined
    }


    fun updateCustomerName(name: String){
        _customerName.value = name
    }

    fun recordSoldProduct(soldProduct: SoldProduct?) {
        val current = _soldProducts.value.toMutableList()
        val validSoldProduct = soldProduct ?: return
        validSoldProduct.intTotal = validSoldProduct.doubleTotal.toInt()

        // If product already exists, replace it instead of duplicating
        val existingIndex = current.indexOfFirst { it.product.name == validSoldProduct.product.name }
        if (existingIndex >= 0 ) {
            current[existingIndex] = validSoldProduct
        } else {
            current.add(validSoldProduct)
        }

        _soldProducts.value = current.toList()
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

