package com.guvnoh.boma.uidesigns.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.guvnoh.boma.formatters.nairaFormat
import com.guvnoh.boma.models.BomaViewModel
import com.guvnoh.boma.navigation.Screen
import com.guvnoh.boma.uidesigns.ProductCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductsPage(
    navController: NavController,
    paddingValues: PaddingValues,
    vm:BomaViewModel) {

    val soldProducts by vm.soldProducts.collectAsState()
    val customerName by vm.customerName
    val grandTotal = nairaFormat(soldProducts.sumOf { it.intTotal })
    val productList by vm.products.collectAsState()


    Scaffold(
        modifier = Modifier
            .padding(paddingValues)
            .imePadding(), // keeps bottom bar above keyboard{needs help from manifest}
        topBar = {
            TopAppBar(
                title = { Text("New Order") },
                actions = {
                    IconButton(onClick = { /* maybe profile? */ }) {
                        Icon(Icons.Filled.Search, contentDescription = "Search")
                    }
                }
            )
        },
        bottomBar = {
            Surface(
                tonalElevation = 4.dp,
                shadowElevation = 8.dp
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.surface)
                        .padding(horizontal = 12.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    //clear button
                    Button(
                        onClick = {
                            vm.clearTotals()
                            vm.clearName()
                                  },
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
                    ) {
                        Icon(Icons.Filled.Clear, contentDescription = "Clear")
                        Spacer(Modifier.width(6.dp))
                        Text("Clear")
                    }

                    //grand total
                    val checkTotal = soldProducts.sumOf { it.intTotal }
                    if (checkTotal > 0 ){
                        Text(
                            grandTotal,
                            style = MaterialTheme.typography.titleLarge.copy(
                                fontWeight = FontWeight.Bold
                            ),
                            color = MaterialTheme.colorScheme.primary
                        )
                    }

                    //done button
                    Button(
                        onClick = {
                            navController.navigate(Screen.Receipt.route)
                            vm.soldProducts.value.forEach {
                                if ( it.intTotal <= 0) vm.removeProduct(it)
                            }
                                  },
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                    ) {
                        Icon(Icons.Filled.Done, contentDescription = "Done")
                        Spacer(Modifier.width(6.dp))
                        Text("Done")
                    }
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Customer name Input
            OutlinedTextField(
                value = customerName,
                onValueChange = {
                    vm.updateCustomerName(it)
                                },
                label = { Text("Customer Name") },
                leadingIcon = {
                    Icon(Icons.Filled.AccountCircle, contentDescription = null)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            )

            // Product list
            LazyColumn(
                contentPadding = PaddingValues(12.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(productList.let { list -> list.sortedBy { it.sortCategory } }) { product ->
                    ProductCard(product, vm)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowProducts() {
    ProductsPage(rememberNavController(), PaddingValues(), viewModel())
}
