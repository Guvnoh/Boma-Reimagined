package com.guvnoh.boma.viewmodels

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DatabaseReference
import com.guvnoh.boma.models.EmptiesStock
import com.guvnoh.boma.models.FullsStock
import com.guvnoh.boma.models.Products
import com.guvnoh.boma.repositories.StockRepository
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
        observeFullsStock("warehouse")
        observeFullsStock("headOffice")
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

    private fun observeFullsStock(store: String) {
        stockRepository.observeFullsStock(store){ stock ->
            when(store){
                "warehouse" -> {_wareHouseFulls.value = stock.values.toMap()}
                "headOffice" -> {_headOfficeFulls.value = stock.values.toMap()}
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

}
