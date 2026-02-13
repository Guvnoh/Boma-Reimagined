package com.guvnoh.boma.uidesigns.screens.priceChange

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun PriceChangePage(
    navController: NavController,
    paddingValues: PaddingValues,
    priceChangeViewmodel: PriceChangeViewmodel
) {
    val productList by priceChangeViewmodel.products.collectAsState()
    val priceChangeList by priceChangeViewmodel.priceChangeProducts.collectAsState()
    val context = LocalContext.current

    Scaffold(
        modifier = Modifier.padding(paddingValues),
        bottomBar = {
            Surface(
                tonalElevation = 4.dp,
                shadowElevation = 8.dp
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        onClick = {
                            priceChangeViewmodel.clearPriceChangeList()
                        },
                        enabled = priceChangeList.isNotEmpty(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.error
                        )
                    ) {
                        Icon(Icons.Filled.Clear, contentDescription = "Clear")
                        Spacer(Modifier.width(8.dp))
                        Text("Clear")
                    }
                    Button(
                        onClick = {
                            priceChangeViewmodel.updatePrices(
                                context = context,
                                map = priceChangeList,
                                navController = navController,
                            )
                            priceChangeViewmodel.clearPriceChangeList()
                        },
                        enabled = priceChangeList.isNotEmpty(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary
                        )
                    ) {
                        Icon(Icons.Filled.Done, contentDescription = "Save Changes")
                        Spacer(Modifier.width(8.dp))
                        Text("Save Changes")
                    }
                }
            }
        }
    ) { innerPadding ->
        if (productList.isEmpty()) {
            // Show loading state
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            LazyColumn(
                contentPadding = PaddingValues(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                items(productList.sortedBy { it.name }) { product ->
                    PriceChangeCard(product, priceChangeViewmodel)
                }
            }
        }
    }
}