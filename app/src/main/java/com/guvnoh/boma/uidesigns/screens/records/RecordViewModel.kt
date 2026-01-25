package com.guvnoh.boma.uidesigns.screens.records

import androidx.lifecycle.ViewModel
import com.guvnoh.boma.uidesigns.screens.receipt.Receipt
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class RecordViewModel: ViewModel(){
    private val recordsRepo = RecordsRepository()
    private val _records = MutableStateFlow<List<Receipt>> (emptyList())
    val records: StateFlow<List<Receipt>> = _records
    private var _record = MutableStateFlow<Receipt?>(null)
    val record: StateFlow<Receipt?> = _record

    init {
        getDbRecords()
    }


    fun deleteRecords(list: List<Receipt>){
        list.forEach {
            deleteRecord(it)
        }
    }

    private fun deleteRecord(record: Receipt){
        RecordsRepository().deleteRecord(record)
    }

    private fun getDbRecords(){
        recordsRepo.getDatabaseRecords {
            dbRecords ->
            _records.value = dbRecords.asReversed()
        }
    }
    fun setCurrentRecord(receipt: Receipt){
        _record.value = receipt
    }
}