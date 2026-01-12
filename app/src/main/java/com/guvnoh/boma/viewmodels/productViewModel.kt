package com.guvnoh.boma.viewmodels

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DatabaseReference
import com.guvnoh.boma.database.FirebaseRefs
import com.guvnoh.boma.formatters.getDate
import com.guvnoh.boma.formatters.halfAndQuarter
import com.guvnoh.boma.models.Products
import com.guvnoh.boma.uidesigns.screens.receipt.Receipt
import com.guvnoh.boma.models.SoldProduct
import com.guvnoh.boma.repositories.ProductsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update


class ProductsViewModel(
    private val repository: ProductsRepository = ProductsRepository()
) : ViewModel() {

    private val _products = MutableStateFlow<List<Products>>(emptyList())
    val products: StateFlow<List<Products>> = _products

    //customer
    private val _customerName = mutableStateOf("")
    var customerName: State<String> = _customerName

    //sold products
    private val _soldProducts = MutableStateFlow<List<SoldProduct>>(emptyList())
    val soldProducts: StateFlow<List<SoldProduct>> = _soldProducts


    init {
        observeProducts(FirebaseRefs.Products)
    }

    //get products from database

    private fun observeProducts(repo: DatabaseReference) {
        repository.observeProducts(repo) { list ->
            _products.value = list
        }
    }

    // customer name

    fun setCustomerName(name: String) {
        _customerName.value = name
    }

    //sold products management

    fun updateSoldProduct(
        product: Products,
        stringQuantity: String,
        doubleQuantity: Double
    ) {
        _soldProducts.update { list ->
            val updated = list.toMutableList()
            val index = updated.indexOfFirst { it.product?.name == product.name }

            val total = ((product.stringPrice?.toDoubleOrNull() ?: 0.0) * doubleQuantity).toInt()

            val soldProduct = SoldProduct(
                product = product,
                stringQuantity = stringQuantity,
                doubleQuantity = doubleQuantity,
                intTotal = total,
                receiptQuantity = halfAndQuarter(doubleQuantity)
            )

            if (index >= 0) {
                updated[index] = soldProduct
            } else {
                updated.add(soldProduct)
            }

            updated
        }
    }

    //generate receipt
    @RequiresApi(Build.VERSION_CODES.O)
    fun generateReceipt(): Receipt {
        val validSoldProducts = soldProducts.value.filter { (it.intTotal ?: 0) > 0 }.toList()

        val grandTotal = validSoldProducts.sumOf { it.intTotal ?: 0 }
        val date = getDate()
        val receipt = Receipt(
            id = FirebaseRefs.records.push().key.toString().replace("-", ""),
            soldProducts = validSoldProducts,
            customerName = customerName.value,
            date = date,
            grandTotal = grandTotal.toString(),
        )

        return receipt
    }


    fun addProduct(product: Products) {
        repository.addProduct(product)
    }

    fun deleteProduct(productId: String) {
        repository.deleteProduct(productId)
    }

    fun clearTotals() {
        _soldProducts.value = emptyList()
    }

    fun clearName() {
        _customerName.value = ""
    }
}
