//package com.guvnoh.boma.models
//
//import android.os.Build
//import android.util.Log
//import androidx.annotation.RequiresApi
//import androidx.compose.runtime.State
//import androidx.compose.runtime.mutableStateOf
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.guvnoh.boma.database.bomaStock
//import com.guvnoh.boma.formatters.checkIfSoldToday
//import com.guvnoh.boma.formatters.getDate
//import com.guvnoh.boma.functions.getDBProductList
//import com.guvnoh.boma.functions.getDBaseEmptiesStock
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.launch
//import kotlinx.coroutines.tasks.await
//
//class BomaViewModel : ViewModel() {
//    //products
//    private val _products = MutableStateFlow<List<Product>>(emptyList())
//    val products: StateFlow<List<Product>> = getProductList()
//
//    //sold products
//    private val _soldProducts = MutableStateFlow<List<SoldProduct>>(emptyList())
//    val soldProducts: StateFlow<List<SoldProduct>> = _soldProducts
//

//

//

//
//    //fulls stock
//    private val _fullsStock = MutableStateFlow<List<FullsStock>>(emptyList())
//    val fullsStock: StateFlow<List<FullsStock>> = getDBFullsStock()
//

//
//    @RequiresApi(Build.VERSION_CODES.O)
//    fun confirmSoldToday(productList: List<Product>){
//        val stockDataBase = bomaStock.child("Fulls")
//
//        productList.forEach {
//            val isSoldToday = checkIfSoldToday(it.stock?.lastTimeSold?:"")
//            //Log.d("SendData", "Processing ${it.name} - soldToday=${it.stock.soldToday} - isSoldToday=$isSoldToday")
//            if (!isSoldToday && (it.stock?.soldToday?:0.0) > 0){
//                it.name?.let { brandName ->
//                    stockDataBase
//                        .child(brandName)
//                        .child("stock")
//                        .child("soldToday")
//                        .setValue(0.0)
//                }
//            }
//
//        }
//    }
//
//
//    //get stock data from database
//    private fun getDBFullsStock(): StateFlow<List<FullsStock>> {
//        val list = mutableListOf<FullsStock>()
//         _products.value.forEach {
//             it.stock?.let { it1 -> list.add(it1) }
//        }
//        _fullsStock.value = list
//        return _fullsStock
//    }
//
//    private fun getDBEmpties(): StateFlow<List<EmptiesStock>> {
//        getDBaseEmptiesStock {
//            emptiesStock ->
//            _emptiesStock.value = emptiesStock
//        }
//        return _emptiesStock
//    }
//
//

//

//
//    private fun getProductList(): StateFlow<List<Product>> {
//        // Fetch products
//        getDBProductList { dbList ->
//            _products.value = dbList
//        }
//
//        return _products
//    }
//
//    fun updateCustomerName(name: String){
//        _customerName.value = name
//    }
//

//
//    fun removeProduct(soldProduct: SoldProduct?) {
//        val current = _soldProducts.value.toMutableList()
//        val validSoldProduct = soldProduct ?: return
//        current.removeAll { it.product?.name == validSoldProduct.product?.name }
//        _soldProducts.value = current.toList()
//    }
//

//
//}
//

package com.guvnoh.boma.viewmodels

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import com.guvnoh.boma.repositories.AppMetaRepository

class BomaViewModel : ViewModel() {

    private val metaRepo = AppMetaRepository()

    @RequiresApi(Build.VERSION_CODES.O)
    fun checkDailyReset(onReset: () -> Unit) {
        metaRepo.checkNewDay {
            onReset()
        }
    }
}

