package com.guvnoh.boma.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.guvnoh.boma.models.StockViewModel
import com.guvnoh.boma.uidesigns.screens.BottomBarItem
import com.guvnoh.boma.uidesigns.screens.StockEmptiesScreen
import com.guvnoh.boma.uidesigns.screens.StockFullsScreen

@Composable
fun StockPageNav(
    paddingValues: PaddingValues
){
    val navController = rememberNavController()
    val vm: StockViewModel = viewModel()

    NavHost(
        startDestination = BottomBarItem.Fulls.route,
        navController = navController
    ){
        composable(BottomBarItem.Empties.route){ StockEmptiesScreen(paddingValues, vm, navController) }
        composable(BottomBarItem.Fulls.route){ StockFullsScreen(paddingValues, vm, navController) }
    }
}