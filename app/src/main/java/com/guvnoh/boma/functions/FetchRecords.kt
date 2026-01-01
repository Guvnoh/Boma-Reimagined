package com.guvnoh.boma.functions

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.guvnoh.boma.database.FirebaseRefs
import com.guvnoh.boma.models.Receipt

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
