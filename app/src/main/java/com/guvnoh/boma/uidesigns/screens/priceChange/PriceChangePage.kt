
package com.guvnoh.boma.uidesigns.screens.priceChange

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.guvnoh.boma.models.Screen
import com.guvnoh.boma.viewmodels.ProductsViewModel


@Composable
fun PriceChangePage(
    navController: NavController,
    paddingValues: PaddingValues,
    priceChangeViewmodel: PriceChangeViewmodel
) {
    val productList by priceChangeViewmodel.products.collectAsState()
    val priceChangeList by priceChangeViewmodel.priceChangeProducts.collectAsState()

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
                    horizontalArrangement = Arrangement.End
                ) {
                    Button(
                        onClick = {
                            priceChangeList.forEach { product ->
                                if (product.id!=null && product.doublePrice!=null){
                                    priceChangeViewmodel.updatePrice(product)
                                }

                            }

                            navController.navigate(Screen.Products.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
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

