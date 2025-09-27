package com.guvnoh.boma.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.guvnoh.boma.uidesigns.screens.PriceChangePage
import com.guvnoh.boma.uidesigns.screens.ProductsPage


@Composable
fun Navigation(
    paddingValues: PaddingValues,
    navController: NavHostController
    ){

    NavHost(
        startDestination = MenuItems.Products.route,
        navController = navController

    ){
        composable(MenuItems.Products.route){ ProductsPage(navController, paddingValues) }
        composable(MenuItems.PriceChange.route){ PriceChangePage(navController, paddingValues) }
    }

}