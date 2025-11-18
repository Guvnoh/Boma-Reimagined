package com.guvnoh.boma.models

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.guvnoh.boma.database.bomaStock
import com.guvnoh.boma.formatters.checkIfSoldToday
import com.guvnoh.boma.formatters.getDate
import com.guvnoh.boma.functions.getDBProductList
import com.guvnoh.boma.functions.getDBaseEmptiesStock
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class BomaViewModel : ViewModel() {
    //products
    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = getProductList()

    //sold products
    private val _soldProducts = MutableStateFlow<List<SoldProduct>>(emptyList())
    val soldProducts: StateFlow<List<SoldProduct>> = _soldProducts

    //customer
    private val _customerName = mutableStateOf("")
    var customerName: State<String> = _customerName

    //price change products
    private val _priceChangeProducts = MutableStateFlow<List<Product>>(emptyList())
    val priceChangeProducts: StateFlow<List<Product>> = _priceChangeProducts

    //receipt
    private val _receipt = MutableStateFlow<Receipt?>(null)
    @RequiresApi(Build.VERSION_CODES.O)
    val receipt: StateFlow<Receipt?> = _receipt

    //fulls stock
    private val _fullsStock = MutableStateFlow<List<FullsStock>>(emptyList())
    val fullsStock: StateFlow<List<FullsStock>> = getDBFullsStock()

    //empties stock
    private val _emptiesStock = MutableStateFlow<List<EmptiesStock>>(emptyList())
    val emptiesStock: StateFlow<List<EmptiesStock>> = getDBEmpties()

    @RequiresApi(Build.VERSION_CODES.O)
    fun confirmSoldToday(productList: List<Product>){
        val stockDataBase = bomaStock.child("Fulls")

        productList.forEach {
            val dateToList = it.stock?.lastTimeSold?.split(",", " ",)
            val hasFormattedDate: Boolean = dateToList?.size == 4
            val isSoldToday = if(hasFormattedDate) checkIfSoldToday(dateToList?: emptyList()) else false
            //Log.d("SendData", "Processing ${it.name} - soldToday=${it.stock.soldToday} - isSoldToday=$isSoldToday")
            if (!isSoldToday && (it.stock?.soldToday?:0.0) > 0){
                it.name?.let { brandName ->
                    stockDataBase
                        .child(brandName)
                        .child("stock")
                        .child("soldToday")
                        .setValue(0.0)
                }
            }

        }
    }


    //get stock data from database
    private fun getDBFullsStock(): StateFlow<List<FullsStock>> {
        val list = mutableListOf<FullsStock>()
         _products.value.forEach {
             it.stock?.let { it1 -> list.add(it1) }
        }
        _fullsStock.value = list
        return _fullsStock
    }

    private fun getDBEmpties(): StateFlow<List<EmptiesStock>> {
        getDBaseEmptiesStock {
            emptiesStock ->
            _emptiesStock.value = emptiesStock
        }
        return _emptiesStock
    }


    fun setCurrentReceipt(receipt: Receipt){
        _receipt.value = receipt
    }

    fun addToPriceChangeList(product: Product, newPrice: String ){
        val current = _priceChangeProducts.value.toMutableList()
        product.stringPrice = newPrice
        current.add(product)
        _priceChangeProducts.value = current
    }

    private fun getProductList(): StateFlow<List<Product>> {
        // Fetch products
        getDBProductList { dbList ->
            _products.value = dbList
        }

        return _products
    }

    fun updateCustomerName(name: String){
        _customerName.value = name
    }

    fun recordSoldProduct(soldProduct: SoldProduct?) {
        val current = _soldProducts.value.toMutableList()
        val validSoldProduct = soldProduct ?: return

        // If product already exists, replace it instead of duplicating
        val existingIndex = current.indexOfFirst {
            it.product?.name?.trim()?.lowercase() == validSoldProduct.product?.name?.trim()?.lowercase()
        }

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
        current.removeAll { it.product?.name == validSoldProduct.product?.name }
        _soldProducts.value = current.toList()
    }

    fun clearTotals() {
        _soldProducts.value = emptyList()
    }

    fun clearName(){
        _customerName.value = ""
    }

}

