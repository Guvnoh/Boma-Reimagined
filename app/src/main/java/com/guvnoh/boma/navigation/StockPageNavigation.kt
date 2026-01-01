package com.guvnoh.boma.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.guvnoh.boma.uidesigns.screens.BottomBarItem
import com.guvnoh.boma.uidesigns.screens.StockEmptiesScreen
import com.guvnoh.boma.uidesigns.screens.StockFullsScreen
import com.guvnoh.boma.viewmodels.StockViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun StockPageNav(
    vm: StockViewModel,
    paddingValues: PaddingValues
){
    val navController = rememberNavController()

    NavHost(
        startDestination = BottomBarItem.Fulls.route,
        navController = navController
    ){
        composable(BottomBarItem.Empties.route){ StockEmptiesScreen(paddingValues, vm, navController) }
        composable(BottomBarItem.Fulls.route){
            StockFullsScreen(
                paddingValues = paddingValues,
                stockViewModel = vm,
                navController = navController
            ) }
    }
}