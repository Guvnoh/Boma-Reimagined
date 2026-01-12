package com.guvnoh.boma.uidesigns.screens.records

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
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.guvnoh.boma.formatters.nairaFormat
import com.guvnoh.boma.functions.captureScreen
import com.guvnoh.boma.functions.saveBitmapToGallery
import com.guvnoh.boma.functions.vibratePhone
import com.guvnoh.boma.models.Products
import com.guvnoh.boma.uidesigns.screens.receipt.Receipt
import com.guvnoh.boma.models.SoldProduct

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecordDetails(record: Receipt) {
    val context = LocalContext.current
    val view = LocalView.current

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
                Button(onClick = {record.soldProducts?.let{ copy(it, context) }}) {
                    Icon(Icons.Filled.Menu, contentDescription = "Copy")
                    Spacer(Modifier.width(6.dp))
                    Text("Copy")
                }
                Button(onClick = {
                    vibratePhone(context, 100L)
                    saveBitmapToGallery(context, captureScreen(view))
                } ){
                    Icon(Icons.Filled.Share, contentDescription = "Screenshot")
                    Spacer(Modifier.width(6.dp))
                    Text("Screenshot")
                }
            }
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Header Info
            Text("Receipt No. ${record.id}", style = MaterialTheme.typography.titleMedium)
            Text("${record.customerName}", style = MaterialTheme.typography.bodyLarge)
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()) {
                Text("Date: ${record.date}", style = MaterialTheme.typography.bodyMedium)
                if (record.time?.isNotBlank() == true){
                    Text("Time: ${record.time}", style = MaterialTheme.typography.bodyMedium)
                }
            }

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
                    record.soldProducts?.let {
                        items(it) { product ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 8.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    product.receiptQuantity?:"0",
                                    style = MaterialTheme.typography.bodyLarge
                                )
                                Text(
                                    product.product?.name?:"unknown",
                                    style = MaterialTheme.typography.bodyLarge
                                )
                                Text(nairaFormat(product.intTotal?:0), fontWeight = FontWeight.Bold)
                            }
                            HorizontalDivider()
                        }
                    }
                }
            }
            if (record.notes?.isNotBlank() == true){
                Text(record.notes!!)
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
                val grandTotal = record.soldProducts?.let {
                    soldProducts ->
                    nairaFormat(soldProducts.sumOf { it.intTotal?:0 })
                }
                Text(
                    text = grandTotal?:"0.00",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun RecordCardDetailsDemo() {

    val sampleProducts = listOf(
        SoldProduct().apply {
            receiptQuantity = "2"
            intTotal = 1200
            product = Products()
            product?.name = "Toothpaste"
        },
        SoldProduct().apply {
            receiptQuantity = "1"
            intTotal = 800
            product = Products()
            product?.name = "Soap"
        }
    )

    RecordDetails(
        record = Receipt(
            id = "001",
            customerName = "John Doe",
            date = "Thu, Oct 30 2025",
            soldProducts = sampleProducts
        )
    )
}

// --- Clipboard copy helpers ---

private fun copy(list: List<SoldProduct>, context: Context) {
    val textToCopy = copyToClipboard(list)
    val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val clip = ClipData.newPlainText("Receipt", textToCopy)
    clipboard.setPrimaryClip(clip)
    Toast.makeText(context, "Receipt copied!", Toast.LENGTH_SHORT).show()
}

fun copyToClipboard(list: List<SoldProduct>): String {
    val builder = StringBuilder()
    val grandTotal = nairaFormat(list.sumOf { it.intTotal?:0 })

    list.forEach {
        builder.append("${it.receiptQuantity} ${it.product?.name} ${nairaFormat(it.intTotal?:0)}\n")
    }

    if (list.isNotEmpty()) builder.append("Total: $grandTotal")
    return builder.toString()
}
