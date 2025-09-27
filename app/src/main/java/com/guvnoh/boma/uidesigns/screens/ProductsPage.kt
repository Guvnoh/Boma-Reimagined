package com.guvnoh.boma.uidesigns.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.guvnoh.boma.formatters.nairaFormat
import com.guvnoh.boma.models.BomaViewModel
import com.guvnoh.boma.models.productList
import com.guvnoh.boma.uidesigns.ProductCard

@Composable
fun ProductsPage(navController: NavController, paddingValues: PaddingValues) {
    var customer by remember { mutableStateOf("") }
    val vm: BomaViewModel = viewModel()

    val totals by vm.soldProducts.collectAsState()
    val grandTotal = nairaFormat( totals.sumOf { it.intTotal } )

    Scaffold(
        modifier = Modifier
            .padding(paddingValues)
            .imePadding(),
        contentWindowInsets = WindowInsets(0),
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(horizontal = 10.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(onClick = { vm.clearTotals() },Modifier.weight(0.9f)) {
                    Icon(Icons.Filled.Clear, contentDescription = "Clear")
                    Text("Clear", style = MaterialTheme.typography.titleMedium)
                }

                Box (
                    Modifier.weight(1f),
                    contentAlignment = Alignment.Center
                ){
                    Text(
                        grandTotal,
                        style = MaterialTheme.typography.titleLarge)
                }//padding(top = 15.dp, start = 4.dp, end = 4.dp))

                Button(onClick = { /* TODO: Save or navigate */ }, Modifier.weight(0.9f)) {
                    Icon(Icons.Filled.Done, contentDescription = "Done")
                    Text("Done", style = MaterialTheme.typography.titleMedium)
                }
            }
        }
    ) { innerPadding ->
        Column {
            Row(
                Modifier
                    .fillMaxWidth()
            ) {
                Icon(
                    imageVector = Icons.Filled.AccountCircle,
                    contentDescription = "",
                    Modifier.size(70.dp)
                )
                OutlinedTextField(
                    value = customer,
                    onValueChange = { customer = it },
                    label = { Text("Customer Name") }
                )
            }

            LazyColumn (Modifier.padding(innerPadding)){
                items(productList) { product ->
                    ProductCard(product, vm)
                }
            }
        }
    }
}

@Preview
@Composable
fun ShowProducts(){
    ProductsPage(rememberNavController(), PaddingValues())
}
