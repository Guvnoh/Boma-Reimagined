

package com.guvnoh.boma.repositories

import android.os.Build
import androidx.annotation.RequiresApi
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.MutableData
import com.google.firebase.database.Transaction
import com.guvnoh.boma.dateProvider.DateProvider
import com.guvnoh.boma.database.FirebaseRefs

class AppMetaRepository {

    @RequiresApi(Build.VERSION_CODES.O)
    fun checkNewDay(onNewDay: () -> Unit) {

        FirebaseRefs.appMeta
            .child("lastProcessedDay")
            .runTransaction(object : Transaction.Handler {
                override fun doTransaction(data: MutableData): Transaction.Result {
                    val today = DateProvider.todayString()
                    if (data.value == today) return Transaction.abort()
                    data.value = today
                    return Transaction.success(data)
                }

                override fun onComplete(
                    error: DatabaseError?,
                    committed: Boolean,
                    currentData: DataSnapshot?
                ) {
                    if (committed && error == null) onNewDay()
                }

            })

    }
}

