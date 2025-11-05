package com.guvnoh.boma.uidesigns.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.wear.compose.material.Icon
import com.guvnoh.boma.R
import com.guvnoh.boma.database.bomaStock
import com.guvnoh.boma.models.BomaViewModel
import com.guvnoh.boma.models.Product
import com.guvnoh.boma.models.FullsStock
import com.guvnoh.boma.models.StockSplashScreen
import com.guvnoh.boma.models.EmptiesStock
import com.guvnoh.boma.models.EmptyCompany
import com.guvnoh.boma.models.NoOfBottles
import com.guvnoh.boma.uidesigns.cards.StockCard


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun StockFullsScreen(
    vm: BomaViewModel,
    modifier: Modifier = Modifier,
    navController: NavHostController,

) {
    val products by vm.products.collectAsState()
    //val stock by vm.fullsStock.collectAsState()

    var showSplash by remember { mutableStateOf(true) }
    var topBarTitle by remember { mutableStateOf("Full Stock") }

    vm.confirmSoldToday(products)

    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        containerColor = MaterialTheme.colorScheme.background,

        // --- FAB ---
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = {
                    // TODO: Navigate to update screen
                },
                icon = {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Update stock",
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                },
                text = {
                    Text(
                        text = "Update",
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                },
                containerColor = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(12.dp),
                elevation = FloatingActionButtonDefaults.elevation(6.dp)
            )
        },

        // --- Top Bar ---
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.surface)
                    .padding(vertical = 12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = topBarTitle,
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    color = MaterialTheme.colorScheme.onSurface
                )
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .fillMaxWidth(0.85f),
                    color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.3f),
                    thickness = 1.dp
                )
            }
        },

        // --- Bottom Bar ---
        bottomBar = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.surface,
                tonalElevation = 4.dp
            ) {
                val bottomBarItems = listOf(BottomBarItem.Fulls, BottomBarItem.Empties)
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                bottomBarItems.forEach { item ->
                    val selected = currentRoute == item.route

                    NavigationBarItem(
                        selected = selected,
                        onClick = {
                            navController.navigate(item.route) {
                                launchSingleTop = true
                            }
                            topBarTitle = if (item == BottomBarItem.Empties) "Empties" else "Full Stock"
                        },
                        icon = { item.icon },
                        label = { Text(item.title) },
                        alwaysShowLabel = true
                    )
                }
            }
        }
    ) { innerPadding ->
        // --- Screen Content ---
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.background)
        ) {
            if (showSplash) {
                StockSplashScreen(
                    modifier = Modifier.fillMaxSize(),
                    onTimeOut = { showSplash = false },
                    stock = products.toMutableList()
                )
            } else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 12.dp)
                ) {
                    items(products) {
                        brandStock ->
                        StockCard(brandStock)
                    }
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
        val stock = FullsStock(
            closingStock = random1.toDouble(),
            openingStock = random2.toDouble(),
            depletion = 0.0,
            lastTimeSold = "Fri, Oct 31 2025"
        )
        it.stock = stock
        bomaStock.child("Fulls")
            .child(it.name?:"unknown")
            .setValue(it)

    }

}





@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
private fun ShowStock(){
    StockFullsScreen(vm = viewModel(), navController = rememberNavController(), )

}