package com.guvnoh.boma.functions

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.guvnoh.boma.database.bomaRecords
import com.guvnoh.boma.models.Receipt

fun getDatabaseRecords(callback: (MutableList<Receipt>) -> Unit) {

    bomaRecords.addValueEventListener(object : ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
            val records = mutableListOf<Receipt>()
            snapshot.children.forEach {
                val record = it.getValue(Receipt::class.java)
                if (record!=null){
                    records.add(record)
                }
            }
            callback(records)
        }

        override fun onCancelled(error: DatabaseError) {
            // handle error if needed
        }
    })
}