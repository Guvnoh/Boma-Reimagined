package com.guvnoh.boma.models

import androidx.lifecycle.ViewModel
import com.guvnoh.boma.functions.getDatabaseEmptiesStock
import com.guvnoh.boma.functions.getDatabaseFullsStock
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class StockViewModel: ViewModel(){
    private val _fullsStock = MutableStateFlow<List<FullsStock>>(emptyList())
    val fullsStock: StateFlow<List<FullsStock>> = getDBFullsStock()
    private val _emptiesStock = MutableStateFlow<List<EmptiesStock>>(emptyList())
    val emptiesStock: StateFlow<List<EmptiesStock>> = getDBEmpties()

    private fun getDBFullsStock(): StateFlow<List<FullsStock>>{
        getDatabaseFullsStock {
                dbList ->
            _fullsStock.value = dbList
        }
        return _fullsStock
    }
    private fun getDBEmpties(): StateFlow<List<EmptiesStock>>{
        getDatabaseEmptiesStock {
                dbList ->
            _emptiesStock.value = dbList
        }
        return _emptiesStock
    }
}