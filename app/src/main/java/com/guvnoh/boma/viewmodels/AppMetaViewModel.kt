package com.guvnoh.boma.viewmodels

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.MutableData
import com.google.firebase.database.Transaction
import com.guvnoh.boma.database.FirebaseRefs
import com.guvnoh.boma.models.FullsStock
import com.guvnoh.boma.repositories.AppMetaRepository

class AppMetaViewModel : ViewModel() {

    private val metaRepo = AppMetaRepository()

    @RequiresApi(Build.VERSION_CODES.O)
    fun checkDailyReset(onReset: () -> Unit) {
        metaRepo.checkNewDay {
            onReset()
        }
    }
    private fun resetStockData(ref: DatabaseReference){
        ref.runTransaction(object : Transaction.Handler {
            override fun doTransaction(data: MutableData): Transaction.Result {
                val stock = data.getValue(FullsStock::class.java)
                    ?: return Transaction.success(data)

                val closing = stock.closingStock ?: 0.0

                stock.openingStock = closing
                stock.soldToday = 0.0

                data.value = stock
                return Transaction.success(data)
            }

            override fun onComplete(
                error: DatabaseError?,
                committed: Boolean,
                currentData: DataSnapshot?
            ) {}
        })
    }

    fun resetSoldToday() {
        val repo = FirebaseRefs.Products
        repo.get().addOnSuccessListener { snapshot ->
            snapshot.children.forEach { productSnap ->
                val productId = productSnap.key ?: return@forEach

                val warehouseStock = repo
                    .child(productId)
                    .child("store")
                    .child("warehouse")

                val headOfficeStock = repo
                    .child(productId)
                    .child("store")
                    .child("headOffice")

                resetStockData(warehouseStock)
                resetStockData(headOfficeStock)

            }
        }
    }

    fun checkNewPrices(){

    }
}



