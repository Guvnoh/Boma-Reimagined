package com.guvnoh.boma.models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.guvnoh.boma.functions.getDatabaseRecords
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class RecordViewModel: ViewModel(){
    private val _records = MutableStateFlow<List<Receipt>> (emptyList())
    val records: StateFlow<List<Receipt>> = getDbRecords()
    private var _record = MutableStateFlow<Receipt?>(null)
    val record: StateFlow<Receipt?> = _record


    private fun getDbRecords(): StateFlow<List<Receipt>>{
        getDatabaseRecords {
            dbRecords ->
            _records.value = dbRecords
        }
        return _records
    }
    fun setCurrentRecord(receipt: Receipt){
        _record.value = receipt
    }
}