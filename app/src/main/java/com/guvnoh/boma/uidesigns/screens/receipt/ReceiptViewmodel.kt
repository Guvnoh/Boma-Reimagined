package com.guvnoh.boma.uidesigns.screens.receipt

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.guvnoh.boma.formatters.nairaFormat
import com.guvnoh.boma.models.SoldProduct
import com.guvnoh.boma.uidesigns.screens.stock.StockViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ReceiptViewmodel : ViewModel(){

    private val _receipt = MutableStateFlow<Receipt?>(null)
    val receipt: StateFlow<Receipt?> = _receipt

    private val _notes = mutableStateOf("")
    val notes: State<String> = _notes


    fun setNotes(value: String) {
        _notes.value = value
    }


    fun setCurrentReceipt(receipt: Receipt){
        _receipt.value = receipt
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun saveRecord(record: Receipt){
        RecordsRepository().sendRecord(record)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun saveSale(list: List<SoldProduct>, stockViewModel: StockViewModel, store: String){
        list.forEach { soldProduct ->
            soldProduct.doubleQuantity?.let {
                qty -> soldProduct.product?.name?.let {
                    name -> stockViewModel.sellProduct(name, qty, store)
                }
            }

        }
    }

    fun getGrandTotal(): Int{
        val total = receipt.value?.soldProducts?.sumOf {
            it.intTotal?:0
        }
        return total?:0
    }

    fun copy(receipt: Receipt, context: Context){
        val textToCopy = copyToClipboard(receipt)
        val clipBoard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("label", textToCopy)
        clipBoard.setPrimaryClip(clip)
        Toast.makeText(context, "Text copied!", Toast.LENGTH_SHORT).show()
    }

    private fun copyToClipboard(receipt: Receipt): String {
        //The variable finalText holds the complete text to be sent to the clipboard
        val finalText = StringBuilder()
        val soldProductsRaw = receipt.soldProducts?: emptyList()
        val soldProducts = soldProductsRaw.filter { it.intTotal!! >0 }.toList()
        val grandTotal = soldProducts.sumOf { it.intTotal?:0 }
        soldProducts.forEach {
            val copiedQuantity: String = it.receiptQuantity?:"0"
            val textToCopy = "$copiedQuantity ${it.product?.name} ${nairaFormat(it.intTotal?:0)}\n"

            finalText.append(textToCopy)
        }
        if (soldProducts.size > 1) {
            finalText.append("Total: ${nairaFormat(grandTotal)}")
        }
        return finalText.toString()
    }
}