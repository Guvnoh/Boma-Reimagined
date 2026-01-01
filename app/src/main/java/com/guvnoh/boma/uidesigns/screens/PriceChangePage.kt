
package com.guvnoh.boma.uidesigns.screens

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
import com.guvnoh.boma.uidesigns.cards.PriceChangeCard
import com.guvnoh.boma.viewmodels.ProductsViewModel


@Composable
fun PriceChangePage(
    navController: NavController,
    paddingValues: PaddingValues,
    vm: ProductsViewModel
) {
//    brandData.forEach {
//        if (it.type == ProductType.BOTTLE )DBBottleProducts.child(it.name).setValue(it)
//        else DBPetsAndCans.child(it.name).setValue(it)
//    }
    val productList by vm.products.collectAsState()
    val priceChangeList by vm.priceChangeProducts.collectAsState()

    Scaffold(
        modifier = Modifier.padding(paddingValues),
//        topBar = {
//            TopAppBar(
//                title = {
//                    Text(
//                        "Change Prices",
//                        style = MaterialTheme.typography.titleLarge.copy(
//                            fontWeight = FontWeight.Bold
//                        )
//                    )
//                }
//            )
//        },
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
                                    vm.updatePrice(product.id!!, product.doublePrice!!)
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
                PriceChangeCard(product, vm)
            }
        }
    }
}

