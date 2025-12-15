package com.guvnoh.boma.uidesigns.screens

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.firebase.database.DatabaseReference
import com.guvnoh.boma.database.bomaStock
import com.guvnoh.boma.formatters.checkIfSoldToday
import com.guvnoh.boma.formatters.getDate
import com.guvnoh.boma.formatters.getTime
import com.guvnoh.boma.formatters.nairaFormat
import com.guvnoh.boma.functions.captureScreen
import com.guvnoh.boma.functions.saveBitmapToGallery
import com.guvnoh.boma.functions.sendRecord
import com.guvnoh.boma.functions.vibratePhone
import com.guvnoh.boma.models.BomaViewModel
import com.guvnoh.boma.models.SoldProduct
import kotlinx.coroutines.tasks.await

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReceiptPage(vm: BomaViewModel) {
    val context = LocalContext.current
    val viewModel = vm.soldProducts.collectAsState()
    val soldProducts = viewModel.value
    val receipt = vm.receipt.collectAsState()


    val grandTotal = receipt.value?.let {
        it.soldProducts?.sumOf { product -> product.intTotal?:0 }?.let { productIntTotal -> nairaFormat(productIntTotal) }
    }
    val view = LocalView.current


    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Receipt", style = MaterialTheme.typography.titleLarge) }
            )
        },
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(onClick = {
                    copy(vm, context)
                }) {
                    Icon(Icons.Filled.Menu, contentDescription = "Copy")
                    Spacer(Modifier.width(6.dp))
                    Text("Copy")
                }
                Button(onClick = {
                    vibratePhone(context, 100L)
                    saveBitmapToGallery(context, captureScreen(view))
                }) {
                    Icon(Icons.Filled.Share, contentDescription = "Screenshot")
                    Spacer(Modifier.width(6.dp))
                    Text("Screenshot")
                }
                Button(
                    onClick = {
                        updateStock(soldProducts)
                        receipt.value?.let { sendRecord(it) }
                        Toast.makeText(context, "Sale record saved!", Toast.LENGTH_SHORT).show()
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50))
                ) {
                    Icon(Icons.Filled.CheckCircle, contentDescription = "Save")
                    Spacer(Modifier.width(6.dp))
                    Text("Save")
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Header Info
            Text("Receipt #${receipt.value?.id}", style = MaterialTheme.typography.titleMedium)
            Text("Customer: ${receipt.value?.customerName}", style = MaterialTheme.typography.bodyLarge)
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()) {
                Text("Date: ${receipt.value?.date}", style = MaterialTheme.typography.bodyMedium)
                Text("Time: ${getTime()}", style = MaterialTheme.typography.bodyMedium)
            }
            Spacer(Modifier.height(16.dp))

            // Products List
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                receipt.value?.let {
                    items(it.soldProducts?: emptyList()) { soldProduct ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                soldProduct.receiptQuantity?:"0",
                                style = MaterialTheme.typography.bodyLarge
                            )
                            Text(
                                soldProduct.product?.name?:"unknown",
                                style = MaterialTheme.typography.bodyLarge
                            )
                            Text(nairaFormat(soldProduct.intTotal?:0), fontWeight = FontWeight.Bold)
                        }
                        HorizontalDivider()
                    }
                }
            }

            // Total Section
            Spacer(Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFF5F5F5))
                    .padding(12.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Grand Total", style = MaterialTheme.typography.titleMedium)
                grandTotal?.let {
                    Text(
                        it.toString(),
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
private fun updateStock(products: List<SoldProduct>) {
    products.forEach { soldProduct ->
        val stockRef = bomaStock
            .child("Fulls")
            .child(soldProduct.product?.name?:"unknown")
            .child("stock")

        val newDepletion = (soldProduct.doubleQuantity?:0.0) + (soldProduct.product?.stock?.depletion ?: 0.0)
        val openingStock = soldProduct.product?.stock?.openingStock ?: 0.0
        val closingStock = soldProduct.product?.stock?.closingStock ?: 0.0
        val currentStock = if (openingStock > 0) closingStock - (soldProduct.doubleQuantity?:0.0) else 0.0

        val dateParts = soldProduct.product?.stock?.lastTimeSold?.split(",", " ")
        val isSoldToday = if (dateParts?.size == 4) checkIfSoldToday(dateParts) else false

        // Get the current soldToday value from Firebase
        stockRef.child("soldToday").get().addOnSuccessListener { snapshot ->
            val previousSoldToday = snapshot.getValue(Double::class.java) ?: 0.0

            val newSoldToday = if (isSoldToday) {
                previousSoldToday + (soldProduct.doubleQuantity?:0.0)
            } else {
                soldProduct.doubleQuantity
            }

            // ✅ Now update everything together
            stockRef.child("depletion").setValue(newDepletion)
            stockRef.child("closingStock").setValue(currentStock)
            stockRef.child("lastTimeSold").setValue(getDate())
            stockRef.child("soldLast").setValue(soldProduct.doubleQuantity)
            stockRef.child("soldToday").setValue(newSoldToday)
        }
    }
}

private fun copy(vm: BomaViewModel, context: Context){
    val textToCopy = copyToClipboard(vm)
    val clipBoard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val clip = ClipData.newPlainText("label", textToCopy)
    clipBoard.setPrimaryClip(clip)
    Toast.makeText(context, "Text copied!", Toast.LENGTH_SHORT).show()
}

private fun copyToClipboard(vm: BomaViewModel): String {
    //The variable finalText holds the complete text to be sent to the clipboard
    val finalText = StringBuilder()
    val grandTotal = nairaFormat(vm.soldProducts.value.sumOf { it.intTotal?:0 })
    vm.soldProducts.value.forEach {
        val copiedQuantity: String = it.receiptQuantity?:"0"
        val textToCopy = "$copiedQuantity ${it.product?.name} ${nairaFormat(it.intTotal?:0)}\n"

        finalText.append(textToCopy)
    }
    if (vm.soldProducts.value.size > 1) {
        finalText.append("Total: $grandTotal")
    }
    return finalText.toString()
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun ReceiptPagePreview() {
    ReceiptPage(
        viewModel()
    )
}