package com.guvnoh.boma.uidesigns.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.wear.compose.material.Icon
import com.google.firebase.database.DatabaseReference
import com.guvnoh.boma.R
import com.guvnoh.boma.database.FirebaseRefs
import com.guvnoh.boma.formatters.getDate
import com.guvnoh.boma.models.Product
import com.guvnoh.boma.models.FullsStock
import com.guvnoh.boma.models.Screen
import com.guvnoh.boma.models.StockSplashScreen
import com.guvnoh.boma.uidesigns.cards.StockCard
import com.guvnoh.boma.viewmodels.StockViewModel


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun StockFullsScreen(
    paddingValues: PaddingValues,
    stockViewModel: StockViewModel,
    modifier: Modifier = Modifier,
    navController: NavHostController,

    ) {
    //val products by productsViewModel.products.collectAsState()
    val stock by stockViewModel.wareHouseStock.collectAsState()

    var showSplash by remember { mutableStateOf(true) }

    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .padding(paddingValues),
            //.background(MaterialTheme.colorScheme.background),
        containerColor = MaterialTheme.colorScheme.background,
        contentWindowInsets = WindowInsets(0, 0, 0, 0),

        // --- FAB ---
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = {},
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
                    .background(MaterialTheme.colorScheme.surface)
                    .wrapContentHeight()
                    .statusBarsPadding()
                    .padding(vertical = 12.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = getDate(),
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    color = Color.Black//MaterialTheme.colorScheme.onSurface
                )
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .fillMaxWidth(0.85f),
                    color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.3f),
                    thickness = 1.dp
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly

                ) {
                    Text(
                        text = Screen.WarehouseStock.title,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = Screen.HeadOfficeStock.title,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }

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
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.background)
        ) {
            if (showSplash) {
                StockSplashScreen(
                    modifier = Modifier.fillMaxSize(),
                    onTimeOut = { showSplash = false },
                    stock = stock.values.toMutableList()
                )
            } else {
                LazyColumn(
                    modifier = Modifier
                        .padding(horizontal = 12.dp)
                ) {
                    items(stock.keys.toMutableList()) {
                        brand ->
                        val name = brand.name?:"error"
                        val brandStock = stock[brand] ?: FullsStock()
                        StockCard(name, brandStock)
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

fun sendStockData(list: List<Product>, repo: DatabaseReference){

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
            repo
                .child(it.id?:"unknown")
                .setValue(it)

    }

}





@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
private fun ShowStock(){
    val vm: StockViewModel = viewModel()
   StockFullsScreen(
       paddingValues = PaddingValues(),
       stockViewModel = vm,
       navController = rememberNavController(), )

}