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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.guvnoh.boma.database.stockFulls
import com.guvnoh.boma.formatters.nairaFormat
import com.guvnoh.boma.functions.sendRecord
import com.guvnoh.boma.models.BomaViewModel
import com.guvnoh.boma.models.SoldProduct
import com.guvnoh.boma.models.FullsStock
import com.guvnoh.boma.models.StockViewModel

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReceiptPage(vm: BomaViewModel) {
    val viewModel = vm.soldProducts.collectAsState()
    val stockViewModel: StockViewModel = viewModel()
    val stock = stockViewModel.fullsStock.collectAsState()
    val soldProducts = viewModel.value
    val receipt = vm.receipt.collectAsState()

    val grandTotal = receipt.value?.let {
        nairaFormat(it.soldProducts.sumOf { product -> product.intTotal })
    }
    val context = LocalContext.current


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
                Button(onClick = {  }) {
                    Icon(Icons.Filled.Share, contentDescription = "Screenshot")
                    Spacer(Modifier.width(6.dp))
                    Text("Screenshot")
                }
                Button(
                    onClick = {
                        updateStock(stock.value.toMutableList(),soldProducts)
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
            Text("Date: ${receipt.value?.date}", style = MaterialTheme.typography.bodyMedium)
            Spacer(Modifier.height(16.dp))

            // Products List
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                receipt.value?.let {
                    items(it.soldProducts) { soldProduct ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                soldProduct.receiptQuantity,
                                style = MaterialTheme.typography.bodyLarge
                            )
                            Text(
                                soldProduct.product.name,
                                style = MaterialTheme.typography.bodyLarge
                            )
                            Text(nairaFormat(soldProduct.intTotal), fontWeight = FontWeight.Bold)
                        }
                        Divider()
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

private fun copy(vm: BomaViewModel, context: Context){
    val textToCopy = copyToClipboard(vm)
    val clipBoard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val clip = ClipData.newPlainText("label", textToCopy)
    clipBoard.setPrimaryClip(clip)
    Toast.makeText(context, "Text copied!", Toast.LENGTH_SHORT).show()
}



private fun updateStock(stockList: MutableList<FullsStock>, products: List<SoldProduct>){

    products.forEach {
        soldProduct ->
        val productName = soldProduct.product.name
        //new depletion gets its value from the receipt qty entered for the brand
        var newDepletion = soldProduct.doubleQuantity
        //database stock is updated by finding matching product names in sold product list
        //and database stock list
        val stock = stockList.first {
            productName == it.product?.name
        }
        //old depletion is the existing depletion in the database before update
        val oldDepletion = stock.depletion?:0.0
        newDepletion += oldDepletion
        //closing stock (used in data class) means current stock
        val currentStock = if
                (stock.openingStock!! > 0.0){
                    stock.openingStock - newDepletion
        }else{0.0}
        val productStockBranch = stockFulls.child(productName)

        productStockBranch
            .child("depletion")
            .setValue(newDepletion)
        productStockBranch
            .child("closingStock")
            .setValue(currentStock)
    }
}

private fun copyToClipboard(vm: BomaViewModel): String{
    //The variable finalText holds the complete text to be sent to the clipboard
    val finalText = StringBuilder()
    val grandTotal = nairaFormat(vm.soldProducts.value.sumOf { it.intTotal })
    vm.soldProducts.value.forEach{
        val copiedQuantity: String = it.receiptQuantity
        val textToCopy = "$copiedQuantity ${it.product.name} ${nairaFormat( it.intTotal )}\n"

        finalText.append(textToCopy)
    }
    if (vm.soldProducts.value.size>1){
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
