package com.guvnoh.boma.functions

import com.google.firebase.database.ServerValue
import com.guvnoh.boma.database.bomaRecords
import com.guvnoh.boma.models.Receipt

fun sendRecord(record: Receipt){
    val newRef = bomaRecords.push()
    val recordMap = mapOf(
        "timeStamp" to record.timeStamp,
        "id" to record.id,
        "soldProducts" to record.soldProducts,
        "customerName" to record.customerName,
        "date" to record.date,
        "grandTotal" to record.grandTotal
    )
    newRef.setValue(recordMap)
}