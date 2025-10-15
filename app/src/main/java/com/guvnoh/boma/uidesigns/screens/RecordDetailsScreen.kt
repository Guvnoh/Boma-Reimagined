//package com.guvnoh.boma.uidesigns.screens
//
//import android.content.ClipData
//import android.content.ClipboardManager
//import android.content.Context
//import android.os.Build
//import android.widget.Toast
//import androidx.annotation.RequiresApi
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Menu
//import androidx.compose.material.icons.filled.Share
//import androidx.compose.material3.Button
//import androidx.compose.material3.Divider
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Icon
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.material3.TopAppBar
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.collectAsState
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.lifecycle.viewmodel.compose.viewModel
//import com.guvnoh.boma.formatters.dateNow
//import com.guvnoh.boma.formatters.nairaFormat
//import com.guvnoh.boma.formatters.timeNow
//import com.guvnoh.boma.models.Receipt
//import com.guvnoh.boma.models.RecordViewModel
//import com.guvnoh.boma.models.SoldProduct
//import com.guvnoh.boma.models.hero
//
//@RequiresApi(Build.VERSION_CODES.O)
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun RecordDetails(receipt: Receipt){
//    val context = LocalContext.current
//   // val records by vm.records.collectAsState()
//
//
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = { Text("Record", style = MaterialTheme.typography.titleLarge) }
//            )
//        },
//        bottomBar = {
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(12.dp),
//                horizontalArrangement = Arrangement.SpaceEvenly
//            ) {
//                Button(onClick = {
//                    copy(receipt.products, context )
//                }) {
//                    Icon(Icons.Filled.Menu, contentDescription = "Copy")
//                    Spacer(Modifier.width(6.dp))
//                    Text("Copy")
//                }
//                Button(onClick = {  }) {
//                    Icon(Icons.Filled.Share, contentDescription = "Screenshot")
//                    Spacer(Modifier.width(6.dp))
//                    Text("Screenshot")
//                }
//            }
//        }
//    ) { innerPadding ->
//        Column(
//            modifier = Modifier
//                .padding(innerPadding)
//                .padding(16.dp)
//        ) {
//            // Header Info
//            Text("Receipt #${receipt.id}", style = MaterialTheme.typography.titleMedium)
//            Text("Customer: ${receipt.customerName}", style = MaterialTheme.typography.bodyLarge)
//            Text("Date: ${receipt.date}", style = MaterialTheme.typography.bodyMedium)
//            Spacer(Modifier.height(16.dp))
//
//            // Products List
//            LazyColumn(
//                modifier = Modifier
//                    .fillMaxWidth()
//            ) {
//                items(receipt.products) { product ->
//                    Row(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(vertical = 8.dp),
//                        horizontalArrangement = Arrangement.SpaceBetween
//                    ) {
//                        Text(product.receiptQuantity, style = MaterialTheme.typography.bodyLarge)
//                        Text(product.product.name, style = MaterialTheme.typography.bodyLarge)
//                        Text(nairaFormat(product.intTotal), fontWeight = FontWeight.Bold)
//                    }
//                    Divider()
//                }
//            }
//
//            // Total Section
//            Spacer(Modifier.height(8.dp))
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .background(Color(0xFFF5F5F5))
//                    .padding(12.dp),
//                horizontalArrangement = Arrangement.SpaceBetween
//            ) {
//                Text("Grand Total", style = MaterialTheme.typography.titleMedium)
//                Text(
//                    "${receipt.products.sumOf { it.intTotal }}",
//                    style = MaterialTheme.typography.titleLarge,
//                    fontWeight = FontWeight.Bold,
//                    color = MaterialTheme.colorScheme.primary
//                )
//            }
//        }
//    }
//}
//
//@RequiresApi(Build.VERSION_CODES.O)
//@Preview(showBackground = true)
//@Composable
//fun RecordCardDetailsDemo(){
//
//    RecordDetails(
//        receipt = Receipt()
//    )
//
//}
//
//private fun copy(list: List<SoldProduct>, context: Context){
//    val textToCopy = copyToClipboard(list)
//    val clipBoard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
//    val clip = ClipData.newPlainText("label", textToCopy)
//    clipBoard.setPrimaryClip(clip)
//    Toast.makeText(context, "Receipt copied!", Toast.LENGTH_SHORT).show()
//}
//
//private fun copyToClipboard(list: List<SoldProduct>): String{
//    //The variable finalText holds the complete text to be sent to the clipboard
//    val finalText = StringBuilder()
//    val grandTotal = nairaFormat(list.sumOf { it.intTotal })
//    list.forEach{
//        val copiedQuantity: String = it.receiptQuantity
//        val textToCopy = "$copiedQuantity ${it.product.name} ${nairaFormat( it.intTotal )}\n"
//
//        finalText.append(textToCopy)
//    }
//    if (list.size>1){
//        finalText.append("Total: $grandTotal")
//    }
//    return finalText.toString()
//}

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
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.guvnoh.boma.formatters.nairaFormat
import com.guvnoh.boma.models.Receipt
import com.guvnoh.boma.models.SoldProduct

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecordDetails(receipt: Receipt) {
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Record", style = MaterialTheme.typography.titleLarge) }
            )
        },
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(onClick = { copy(receipt.soldProducts, context) }) {
                    Icon(Icons.Filled.Menu, contentDescription = "Copy")
                    Spacer(Modifier.width(6.dp))
                    Text("Copy")
                }
                Button(onClick = { /* TODO: Screenshot feature */ }) {
                    Icon(Icons.Filled.Share, contentDescription = "Screenshot")
                    Spacer(Modifier.width(6.dp))
                    Text("Screenshot")
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
            Text("Receipt #${receipt.id}", style = MaterialTheme.typography.titleMedium)
            Text("Customer: ${receipt.customerName}", style = MaterialTheme.typography.bodyLarge)
            Text("Date: ${receipt.date}", style = MaterialTheme.typography.bodyMedium)

            Spacer(Modifier.height(16.dp))

            // Products List (scrollable)
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(receipt.soldProducts) { product ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                product.receiptQuantity,
                                style = MaterialTheme.typography.bodyLarge
                            )
                            Text(product.product.name, style = MaterialTheme.typography.bodyLarge)
                            Text(nairaFormat(product.intTotal), fontWeight = FontWeight.Bold)
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
                Text(
                    nairaFormat(receipt.soldProducts.sumOf { it.intTotal }),
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

//@RequiresApi(Build.VERSION_CODES.O)
//@Preview(showBackground = true)
//@Composable
//fun RecordCardDetailsDemo() {
//    // Simple fake data for preview
//    val sampleProducts = listOf(
//        SoldProduct().apply {
//            receiptQuantity = "2x"
//            intTotal = 1200
//            product.name = "Toothpaste"
//        },
//        SoldProduct(
//            receiptQuantity = "1x",
//             = 800,
//            product.name = "Soap"
//        )
//    )
//
//    RecordDetails(
//        receipt = Receipt(
//            id = "001",
//            customerName = "John Doe",
//            date = "2025-10-14",
//            products = sampleProducts
//        )
//    )
//}

// --- Clipboard copy helpers ---

private fun copy(list: List<SoldProduct>, context: Context) {
    val textToCopy = copyToClipboard(list)
    val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val clip = ClipData.newPlainText("Receipt", textToCopy)
    clipboard.setPrimaryClip(clip)
    Toast.makeText(context, "Receipt copied!", Toast.LENGTH_SHORT).show()
}

private fun copyToClipboard(list: List<SoldProduct>): String {
    val builder = StringBuilder()
    val grandTotal = nairaFormat(list.sumOf { it.intTotal })

    list.forEach {
        builder.append("${it.receiptQuantity} ${it.product.name} ${nairaFormat(it.intTotal)}\n")
    }

    if (list.isNotEmpty()) builder.append("Total: $grandTotal")
    return builder.toString()
}
