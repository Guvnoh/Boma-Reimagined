package com.guvnoh.boma.uidesigns.screens.receipt

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.guvnoh.boma.database.FirebaseRefs

class RecordsRepository() {

    private val recordsRef = FirebaseRefs.records


    fun getDatabaseRecords(callback: (MutableList<Receipt>) -> Unit) {

        FirebaseRefs.records.orderByChild("timeStamp")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val records = snapshot.children.mapNotNull {
                        it.getValue(Receipt::class.java)
                    }.sortedByDescending { it.timeStamp }

                    callback(records.toMutableList())
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.d("get records error: ", "$error")
                }
            })
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun sendRecord(record: Receipt) {
        val newRef = recordsRef.push()
        val recordMap = mapOf(
            "timeStamp" to record.timeStamp,
            "ref" to newRef.key,
            "id" to record.id,
            "soldProducts" to record.soldProducts,
            "customerName" to record.customerName,
            "date" to record.date,
            "time" to record.time,
            "grandTotal" to record.grandTotal,
            "notes" to record.notes
        )
        newRef.setValue(recordMap)
    }

    fun deleteRecord(record: Receipt) {
        recordsRef.child(record.ref ?: "").removeValue()
    }
}