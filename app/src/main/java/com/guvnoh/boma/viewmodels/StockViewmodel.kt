package com.guvnoh.boma.viewmodels

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import com.guvnoh.boma.models.EmptiesStock
import com.guvnoh.boma.models.FullsStock
import com.guvnoh.boma.repositories.AppMetaRepository
import com.guvnoh.boma.repositories.StockRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@RequiresApi(Build.VERSION_CODES.O)
class StockViewModel(
    private val stockRepository: StockRepository = StockRepository(),
    private val appMetaRepository: AppMetaRepository = AppMetaRepository()
) : ViewModel() {

    private val _wareHouseStock = MutableStateFlow<Map<String, FullsStock>>(emptyMap())
    val wareHouseStock: StateFlow<Map<String, FullsStock>> = _wareHouseStock

        //empties stock
    private val _emptiesStock = MutableStateFlow<Map<String, EmptiesStock>>(emptyMap())
    val emptiesStock: StateFlow<Map<String, EmptiesStock>> = _emptiesStock

    init {
        observeFullsStock()
        observeEmptiesStock()
        checkDailyReset()
    }

    private fun observeFullsStock() {
        stockRepository.observeFullsStock { map ->
            _wareHouseStock.value = map
        }
    }

    private fun observeEmptiesStock() {
        stockRepository.observeEmptiesStock { map ->
            _emptiesStock.value = map
        }
    }

    fun sellProduct(productId: String, quantity: Double) {
        stockRepository.sellProduct(
            productId = productId,
            soldQty = quantity
        )
    }

    private fun checkDailyReset() {
        appMetaRepository.checkNewDay {
            stockRepository.resetSoldToday()
        }
    }
}
