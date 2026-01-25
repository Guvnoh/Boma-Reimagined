package com.guvnoh.boma.uidesigns.screens.stock

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import com.guvnoh.boma.models.EmptiesStock
import com.guvnoh.boma.models.FullsStock
import com.guvnoh.boma.models.Products
import com.guvnoh.boma.repositories.StockRepository
import com.guvnoh.boma.viewmodels.AppMetaViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@RequiresApi(Build.VERSION_CODES.O)
class StockViewModel(
) : ViewModel() {

    private val _wareHouseFulls = MutableStateFlow<Map<Products, FullsStock>>(emptyMap())
    val wareHouseStock: StateFlow<Map<Products, FullsStock>> = _wareHouseFulls

    private val _headOfficeFulls = MutableStateFlow<Map<Products, FullsStock>>(emptyMap())
    val headOfficeStock: StateFlow<Map<Products, FullsStock>> = _headOfficeFulls

        //empties stock
    private val _emptiesStock = MutableStateFlow<Map<String, EmptiesStock>>(emptyMap())
    val emptiesStock: StateFlow<Map<String, EmptiesStock>> = _emptiesStock



    private val stockRepository: StockRepository = StockRepository()

    init {
        observeFullsStock(Store.WAREHOUSE)
        observeFullsStock(Store.HEAD_OFFICE)
        observeEmptiesStock()
        AppMetaViewModel().checkDailyReset {
            AppMetaViewModel().resetSoldToday()
        }
    }

//    private fun convertListToMap(list: List<Products>): Map<Products, FullsStock>{
//        val map: MutableMap<Products, FullsStock> = mutableMapOf()
//
//        list.forEach {
//            val stock = it.stock?:FullsStock()
//            map[it] = stock
//        }
//        return map
//    }

    private fun observeFullsStock(store: Store) {
        stockRepository.observeFullsStock(store){ stock ->
            when(store){
                Store.WAREHOUSE -> {_wareHouseFulls.value = stock.values.toMap()}
                Store.HEAD_OFFICE -> {_headOfficeFulls.value = stock.values.toMap()}
            }
        }

    }

    private fun observeEmptiesStock() {
        stockRepository.observeEmptiesStock { map ->
            _emptiesStock.value = map
        }
    }

    fun sellProduct(productId: String, quantity: Double, store: String) {
        stockRepository.sellProduct(
            productId = productId,
            soldQty = quantity,
            store = store
        )
    }

    fun updateStock(productId: String, store: Store, newStock: Double? = null){
        StockRepository().updateStock(productId,store,newStock)
        observeFullsStock(store)
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
    fun stockOVC(input: String, store: Store, productId: String): String{
        val filtered = input.filter { it.isDigit() || it == '.' }
        if (filtered.count { it == '.' } <= 1) {
            if (filtered.isNotEmpty()) {
                updateStock(
                    productId = productId,
                    store = store,
                    newStock = filtered.toDoubleOrNull()
                )
            }
        }
        return filtered
    }
}
