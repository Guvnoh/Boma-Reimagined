package com.guvnoh.boma.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.guvnoh.boma.models.BomaViewModel
import com.guvnoh.boma.uidesigns.screens.PriceChangePage
import com.guvnoh.boma.uidesigns.screens.ProductsPage
import com.guvnoh.boma.uidesigns.screens.ReceiptPage


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Navigation(
    paddingValues: PaddingValues,
    navController: NavHostController
    ){
    val vm: BomaViewModel = viewModel()

    NavHost(
        startDestination = Screen.Products.route,
        navController = navController

    ){
        composable(Screen.Products.route){ ProductsPage(navController, paddingValues, vm) }
        composable(Screen.PriceChange.route){ PriceChangePage(navController, paddingValues, vm) }
        composable(Screen.Receipt.route){ ReceiptPage(vm) }
    }

}