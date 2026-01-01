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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.guvnoh.boma.formatters.getTime
import com.guvnoh.boma.formatters.nairaFormat
import com.guvnoh.boma.functions.captureScreen
import com.guvnoh.boma.functions.saveBitmapToGallery
import com.guvnoh.boma.functions.sendRecord
import com.guvnoh.boma.functions.vibratePhone
import com.guvnoh.boma.models.Receipt
import com.guvnoh.boma.viewmodels.ProductsViewModel
import com.guvnoh.boma.viewmodels.ReceiptViewmodel
import com.guvnoh.boma.viewmodels.StockViewModel

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReceiptPage( stockViewModel: StockViewModel, receiptViewmodel: ReceiptViewmodel) {
    val context = LocalContext.current
    val receipt by receiptViewmodel.receipt.collectAsState()



    val grandTotal = receipt?.let {
        it.soldProducts?.sumOf {
            product -> product.intTotal?:0
        }?.let {
            productIntTotal -> nairaFormat(productIntTotal)
        }
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
                //copy button
                Button(onClick = {
                    val nonNullReceipt = receipt?:Receipt()
                    receiptViewmodel.copy(nonNullReceipt, context)
                }) {
                    Icon(Icons.Filled.Menu, contentDescription = "Copy")
                    Spacer(Modifier.width(6.dp))
                    Text("Copy")
                }
                //screenshot button
                Button(onClick = {
                    vibratePhone(context, 100L)
                    saveBitmapToGallery(context, captureScreen(view))
                }) {
                    Icon(Icons.Filled.Share, contentDescription = "Screenshot")
                    Spacer(Modifier.width(6.dp))
                    Text("Screenshot")
                }
                //save button
                Button(
                    onClick = {
                        //productsViewModel.(soldProducts)
                        receiptViewmodel.saveSale(receipt?.soldProducts!!, stockViewModel)
                        receipt?.let { sendRecord(it) }
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

            Text("${receipt?.customerName}", style = MaterialTheme.typography.titleMedium)
            Text("Receipt No. ${receipt?.id}", style = MaterialTheme.typography.bodyMedium)
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()) {
                Text("Date: ${receipt?.date}", style = MaterialTheme.typography.bodyMedium)
                Text("Time: ${getTime()}", style = MaterialTheme.typography.bodyMedium)
            }

            Spacer(Modifier.height(16.dp))

            // Products List
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                receipt?.let {
                    items(it.soldProducts?: emptyList()) { soldProduct ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            //qty of item sold (display)
                            Text(
                                soldProduct.receiptQuantity?:"0",
                                style = MaterialTheme.typography.bodyLarge
                            )
                            //name of item sold (display)
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
                        it,
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
@Preview(showBackground = true)
@Composable
fun ReceiptPagePreview() {
    val stockvm : StockViewModel = viewModel()
    val rvm : ReceiptViewmodel = viewModel()
    ReceiptPage(
        stockvm,
        rvm
    )
}