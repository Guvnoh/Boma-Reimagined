package com.guvnoh.boma.models

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

//class BomaViewModel:ViewModel() {
////    private  val _totals: MutableStateFlow<Map<String,Int>>(em)
////    fun addTotal(key: String, value: Int){
////        _totals[key] = value
////    }
////    fun removeTotal(key: String){
////        val totals = _totals
////        totals.remove(key)
////        _totals = totals
////    }
////    fun clearTotals(){
////        _totals = mutableMapOf()
////    }
////    fun getTotalsMap(): MutableMap<String, Int>{
////        val totals = _totals
////        return totals
////    }
////    fun getGrandTotal():Int{
////        return  _totals.map { it.value }.sum()
////    }
//    private val _totals = MutableStateFlow<MutableMap<String, Int>>(mutableMapOf())
//    val totals: StateFlow<MutableMap<String, Int>> = _totals
//
//    fun addTotal(key: String, value: Int) {
////        _totals.update { current ->
////            current.toMutableMap().apply { this[key] = value }
////        }
//        val totals = _totals.value
//        totals [key] = value
//        _totals.value = totals
//    }
//
//    fun removeTotal(key: String) {
//        val totals = _totals.value
//        totals.remove(key)
//        _totals.value = totals
//    }
//
//    fun clearTotals() {
//        _totals.value = mutableMapOf()
//    }
//
//    fun getGrandTotal(): Int {
//        return _totals.value.values.sum()
//    }
//
//}
class BomaViewModel : ViewModel() {
    private val _soldProducts = MutableStateFlow<List<SoldProduct>>(emptyList())
    val soldProducts: StateFlow<List<SoldProduct>> = _soldProducts

    fun addProduct(soldProduct: SoldProduct) {
        val current = _soldProducts.value.toMutableList()

        // If product already exists, replace it instead of duplicating
        val existingIndex = current.indexOfFirst { it.product.name == soldProduct.product.name }
        if (existingIndex >= 0) {
            current[existingIndex] = soldProduct
        } else {
            current.add(soldProduct)
        }

        _soldProducts.value = current.toList() // ✅ new list triggers recomposition
    }

    fun removeProduct(soldProduct: SoldProduct) {
        val current = _soldProducts.value.toMutableList()
        current.removeAll { it.product.name == soldProduct.product.name }
        _soldProducts.value = current.toList()
    }

    fun clearTotals() {
        _soldProducts.value = emptyList()
    }

    fun getGrandTotal(): Int {
        return _soldProducts.value.sumOf { it.intTotal}
    }
}

