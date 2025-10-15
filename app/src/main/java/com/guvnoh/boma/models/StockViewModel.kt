package com.guvnoh.boma.models

import androidx.lifecycle.ViewModel
import com.guvnoh.boma.getDatabaseStock
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class StockViewModel: ViewModel(){
    private val _stock = MutableStateFlow<List<Stock>>(emptyList())
    val stock: StateFlow<List<Stock>> = getDbStock()

    private fun getDbStock(): StateFlow<List<Stock>>{
        getDatabaseStock {
                dbList ->
            _stock.value = dbList
        }
        return _stock
    }
}