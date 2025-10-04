//package com.guvnoh.boma.uidesigns.screens
//
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.PaddingValues
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Done
//import androidx.compose.material3.Button
//import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.Icon
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.collectAsState
//import androidx.compose.runtime.getValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import androidx.navigation.NavController
//import androidx.navigation.NavGraph.Companion.findStartDestination
//import com.guvnoh.boma.databasePrices
//import com.guvnoh.boma.models.BomaViewModel
//import com.guvnoh.boma.models.Product
//import com.guvnoh.boma.navigation.Screen
//import com.guvnoh.boma.uidesigns.PriceChangeCard
//
//@Composable
//fun PriceChangePage(
//    navController: NavController,
//    paddingValues: PaddingValues,
//    vm: BomaViewModel){
//    val productList by vm.products.collectAsState()
//    val priceChangeList by vm.priceChangeProducts.collectAsState()
//    Column(horizontalAlignment = Alignment.CenterHorizontally) {
//        LazyColumn (modifier = Modifier.padding(paddingValues).weight(1.8f)){
//            items(productList.let { list -> list.sortedBy { it.sortCategory } }){
//                    product ->
//                PriceChangeCard(product, vm)
//            }
//        }
//        //done button
//        Button(
//            onClick = {
//                priceChangeList.forEach {
//                    product ->
//                    updatePrice(product, product.stringPrice)
//                }
//
//                navController.navigate(Screen.Products.route){
//                    //go back to start destination before new navigation
//                    popUpTo(navController.graph.findStartDestination().id) {
//                        saveState = true //remember details of current screen while leaving
//                    }
//                    launchSingleTop = true //avoid screen duplication when same screen is opened multiple times
//                    restoreState = true //details remembered are restored on reentry
//                }
//            },
//            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
//        ) {
//            Icon(Icons.Filled.Done, contentDescription = "Done")
//            Spacer(Modifier.width(6.dp))
//            Text("Done")
//        }
//    }
//
//}
//
//fun updatePrice(product: Product, newPrice: String){
//    databasePrices.child(product.name).child("stringPrice").setValue(newPrice)
//    databasePrices.child(product.name).child("doublePrice").setValue(newPrice.toDoubleOrNull()?:0.0)
//}

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.guvnoh.boma.databasePrices
import com.guvnoh.boma.models.BomaViewModel
import com.guvnoh.boma.models.Product
import com.guvnoh.boma.navigation.Screen
import com.guvnoh.boma.uidesigns.PriceChangeCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PriceChangePage(
    navController: NavController,
    paddingValues: PaddingValues,
    vm: BomaViewModel
) {
    val productList by vm.products.collectAsState()
    val priceChangeList by vm.priceChangeProducts.collectAsState()

    Scaffold(
        modifier = Modifier.padding(paddingValues),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Change Prices",
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.Bold
                        )
                    )
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
                        .padding(horizontal = 16.dp, vertical = 12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End
                ) {
                    Button(
                        onClick = {
                            priceChangeList.forEach { product ->
                                updatePrice(product, product.stringPrice)
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
            items(productList.sortedBy { it.sortCategory }) { product ->
                PriceChangeCard(product, vm)
            }
        }
    }
}

fun updatePrice(product: Product, newPrice: String) {
    databasePrices.child(product.name).child("stringPrice").setValue(newPrice)
    databasePrices.child(product.name).child("doublePrice")
        .setValue(newPrice.toDoubleOrNull() ?: 0.0)
}
