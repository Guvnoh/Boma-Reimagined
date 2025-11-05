package com.guvnoh.boma.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.guvnoh.boma.models.BomaViewModel
import com.guvnoh.boma.uidesigns.screens.BottomBarItem
import com.guvnoh.boma.uidesigns.screens.StockEmptiesScreen
import com.guvnoh.boma.uidesigns.screens.StockFullsScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun StockPageNav(
    vm: BomaViewModel,
    paddingValues: PaddingValues
){
    val navController = rememberNavController()

    NavHost(
        startDestination = BottomBarItem.Fulls.route,
        navController = navController
    ){
        composable(BottomBarItem.Empties.route){ StockEmptiesScreen(paddingValues, vm, navController) }
        composable(BottomBarItem.Fulls.route){ StockFullsScreen(vm = vm, navController = navController) }
    }
}