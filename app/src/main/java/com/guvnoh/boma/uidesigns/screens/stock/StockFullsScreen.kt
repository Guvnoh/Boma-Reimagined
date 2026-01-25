package com.guvnoh.boma.uidesigns.screens.stock

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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import com.guvnoh.boma.R
import com.guvnoh.boma.formatters.getDate
import com.guvnoh.boma.models.FullsStock
import com.guvnoh.boma.models.Screen
import com.guvnoh.boma.models.StockSplashScreen


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun StockFullsScreen(
    paddingValues: PaddingValues,
    stockViewModel: StockViewModel,
    modifier: Modifier = Modifier,
    navController: NavHostController,

    ) {
    val warehouse by stockViewModel.wareHouseStock.collectAsState()
    val headOffice by stockViewModel.headOfficeStock.collectAsState()
    var store by remember { mutableStateOf(Store.WAREHOUSE)}
    var stockChoice = when(store){
        Store.WAREHOUSE -> warehouse
        Store.HEAD_OFFICE -> headOffice
    }

    var showSplash by remember { mutableStateOf(true) }

    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .padding(paddingValues),
        containerColor = MaterialTheme.colorScheme.background,
        contentWindowInsets = WindowInsets(0, 0, 0, 0),

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
                    // warehouse stock button

                    Button(
                        onClick = {
                            stockChoice = warehouse
                            store = Store.WAREHOUSE
                        },
                        colors = if (stockChoice != warehouse) {
                            ButtonDefaults.buttonColors(containerColor = Color.LightGray)
                        }else ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                    ){
                        Text(
                            text = Screen.WarehouseStock.title,
                            color = MaterialTheme.colorScheme.onSurface
                        )

                    }

                    //headOffice button
                    Button(
                        onClick = {
                            stockChoice = headOffice
                            store = Store.HEAD_OFFICE
                        },
                        colors = if (stockChoice != headOffice) {
                            ButtonDefaults.buttonColors(containerColor = Color.LightGray)
                        }else ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                    ){
                        Text(
                            text = Screen.HeadOfficeStock.title,
                            color = MaterialTheme.colorScheme.onSurface
                        )

                    }
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
                    stock = stockChoice.values.toMutableList()
                )
            } else {
                LazyColumn(
                    modifier = Modifier
                        .padding(horizontal = 12.dp)
                ) {
                    items(stockChoice.keys.toMutableList()) {
                        brand ->
                        val name = brand.name?:"error"
                        val brandStock = stockChoice[brand] ?: FullsStock()
                        StockCard(
                            product = brand,
                            stock = brandStock,
                            viewModel = stockViewModel,
                            store = store )
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




@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
private fun ShowStock(){
    val vm: StockViewModel = viewModel()
   StockFullsScreen(
       paddingValues = PaddingValues(),
       stockViewModel = vm,
       navController = rememberNavController(),
       modifier = Modifier,
   )

}