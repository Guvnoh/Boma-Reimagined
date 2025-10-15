package com.guvnoh.boma.uidesigns.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.wear.compose.material.Icon
import com.guvnoh.boma.R
import com.guvnoh.boma.getDatabaseProductList
import com.guvnoh.boma.models.BomaViewModel
import com.guvnoh.boma.models.Product
import com.guvnoh.boma.models.Stock
import com.guvnoh.boma.models.StockSplashScreen
import com.guvnoh.boma.models.StockViewModel
import com.guvnoh.boma.stockFulls
import com.guvnoh.boma.uidesigns.StockCard

@Composable
fun StockScreen(
    paddingValues: PaddingValues,
    vm: StockViewModel,
    navController: NavController,

){
    val stock by vm.stock.collectAsState()
    var showSplash by remember { mutableStateOf(true) }

    Scaffold(
        floatingActionButton = {FloatingActionButton(
            onClick = {
                //navController.navigate()
            }
        ) {
            Row (
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.padding(horizontal = 10.dp)
            ){
                Icon(
                    imageVector = Icons.Filled.Edit,
                    contentDescription = "",
                    tint = MaterialTheme.colorScheme.onSecondaryContainer
                )
                Spacer(modifier = Modifier.padding(horizontal = 3.dp))
                Text(text = "Update")
            }
        }},
        modifier = Modifier.padding(paddingValues),
        topBar = {
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()){
                Text(
                    text = "Stock Records",
                    style = MaterialTheme.typography.headlineLarge,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        },
        bottomBar = {
            NavigationBar {
                val bottomBarItems = listOf(BottomBarItem.Fulls, BottomBarItem.Empties)
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                bottomBarItems.forEach {
                    val selected = currentRoute == it.route
                    NavigationBarItem(
                        selected = selected,
                        onClick = { navController.navigate(it.route){launchSingleTop = true} },
                        icon = {it.icon},
                        label = { Text(it.title) }
                    )
                }
            }
        }
    ){
        if (showSplash){
            StockSplashScreen(
                modifier = Modifier.padding(it),
                onTimeOut = {showSplash = false},
                list = stock.toMutableList()
            )
        }else{
            LazyColumn(
                modifier = Modifier.padding(it)
            ) {
                items(stock.toMutableList()){
                        brandStock ->
                    StockCard(brandStock)
                }
            }
        }
    }

}
open class BottomBarItem(
    val route: String,
    val title: String,
    val icon: Int,

    ){
    data object Fulls: BottomBarItem(route = "fulls", title = "Fulls", R.drawable.orijin)
    data object Empties: BottomBarItem(route = "empties", title = "Empties", R.drawable.bottle)
}
fun sendStockData(list: List<Product>){

    list.forEach {
        val random1 = (20..800).random()
        val random2 = (20..800).random()
        val stock = Stock(
            product = it,
            closingStock = random1.toDouble(),
            openingStock = random2.toDouble(),
            depletion = 0.0 )
        stockFulls
            .child(stock.product?.name?:"")
            .setValue(stock)

    }

}

@Preview
@Composable
private fun ShowStock(){
    StockScreen(PaddingValues(), viewModel(), rememberNavController())

}