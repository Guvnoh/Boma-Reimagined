
package com.guvnoh.boma.uidesigns.screens

import com.guvnoh.boma.uidesigns.SwipeableProductCard
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.guvnoh.boma.formatters.nairaFormat
import com.guvnoh.boma.models.BomaViewModel
import com.guvnoh.boma.models.Product
import com.guvnoh.boma.navigation.Screen
import com.guvnoh.boma.uidesigns.ProductCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductsPage(
    navController: NavController,
    paddingValues: PaddingValues,
    vm: BomaViewModel
) {
    val soldProducts by vm.soldProducts.collectAsState()
    val customerName by vm.customerName
    val productList by vm.products.collectAsState()
    val grandTotal = soldProducts.sumOf { it.intTotal }

    Scaffold(
        modifier = Modifier
            .padding(paddingValues)
            .imePadding(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "New Order",
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.Bold
                        )
                    )
                },
                actions = {
                    IconButton(onClick = { /* TODO: search */ }) {
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
                        .padding(horizontal = 16.dp, vertical = 12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Clear Button
                    OutlinedButton(
                        onClick = {
                            vm.clearTotals()
                            vm.clearName()
                        },
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = MaterialTheme.colorScheme.error
                        )
                    ) {
                        Icon(Icons.Filled.Clear, contentDescription = "Clear")
                        Spacer(Modifier.width(6.dp))
                        Text("Clear")
                    }

                    // Grand Total
                    if (grandTotal > 0) {
                        Text(
                            nairaFormat(grandTotal),
                            style = MaterialTheme.typography.titleLarge.copy(
                                fontWeight = FontWeight.ExtraBold
                            ),
                            color = MaterialTheme.colorScheme.primary
                        )
                    } else {
                        Text(
                            "₦0.00",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    // Done Button
                    Button(
                        onClick = {
                            navController.navigate(Screen.Receipt.route)
                            vm.soldProducts.value.forEach {
                                if (it.intTotal <= 0) vm.removeProduct(it)
                            }
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary
                        )
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
            // Customer Name
            OutlinedTextField(
                value = customerName,
                onValueChange = { vm.updateCustomerName(it) },
                label = { Text("Customer Name") },
                leadingIcon = { Icon(Icons.Filled.AccountCircle, contentDescription = null) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

            // Product List
            LazyColumn(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(productList.sortedBy { it.sortCategory }) { product ->
                    ProductCard(
                        product = product,
                        viewModel = vm,)
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
