package com.guvnoh.boma.functions

import com.guvnoh.boma.bomaRecords
import com.guvnoh.boma.models.Receipt

fun sendRecord(record: Receipt){
    bomaRecords.child("${record.date} ${record.customerName}").setValue(record)
}