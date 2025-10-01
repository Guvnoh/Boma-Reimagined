package com.guvnoh.boma.uidesigns.screens

import android.os.Build
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.guvnoh.boma.formatters.dateNow
import com.guvnoh.boma.formatters.nairaFormat
import com.guvnoh.boma.formatters.timeNow
import com.guvnoh.boma.models.BomaViewModel
import com.guvnoh.boma.models.Product
import com.guvnoh.boma.models.Receipt

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReceiptPage(vm: BomaViewModel) {
    val viewModel = vm.soldProducts.collectAsState()
    val soldProducts = viewModel.value
    val receipt = Receipt(products = soldProducts, customerName = vm.customerName.value)

    val grandTotal = nairaFormat(receipt.products.sumOf { it.intTotal })

    Scaffold(
        topBar = {
            SmallTopAppBar(
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
                Button(onClick = {  }) {
                    Icon(Icons.Filled.Menu, contentDescription = "Copy")
                    Spacer(Modifier.width(6.dp))
                    Text("Copy")
                }
                Button(onClick = {  }) {
                    Icon(Icons.Filled.Share, contentDescription = "Screenshot")
                    Spacer(Modifier.width(6.dp))
                    Text("Screenshot")
                }
                Button(
                    onClick = {  },
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
            Text("Receipt #${receipt.id}", style = MaterialTheme.typography.titleMedium)
            Text("Customer: ${receipt.customerName}", style = MaterialTheme.typography.bodyLarge)
            Text("Date: $dateNow, $timeNow", style = MaterialTheme.typography.bodyMedium)
            Spacer(Modifier.height(16.dp))

            // Products List
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                items(receipt.products) { product ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(product.receiptQuantity, style = MaterialTheme.typography.bodyLarge)
                        Text(product.product.name, style = MaterialTheme.typography.bodyLarge)
                        Text(nairaFormat(product.intTotal), fontWeight = FontWeight.Bold)
                    }
                    Divider()
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
                    grandTotal,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReceiptPagePreview() {
    val demoProducts = listOf(
        Product(name = "Rice", doublePrice = 2500.0),
        Product(name = "Beans", doublePrice = 1800.0),
        Product(name = "Yam", doublePrice = 1200.0)
    )
    ReceiptPage(
        viewModel()
    )
}
