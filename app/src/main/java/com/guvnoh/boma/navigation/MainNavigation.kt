package com.guvnoh.boma.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.guvnoh.boma.models.BomaViewModel
import com.guvnoh.boma.models.RecordViewModel
import com.guvnoh.boma.uidesigns.screens.AddProduct
import com.guvnoh.boma.uidesigns.screens.DeleteProduct
import com.guvnoh.boma.uidesigns.screens.PriceChangePage
import com.guvnoh.boma.uidesigns.screens.ProductsPage
import com.guvnoh.boma.uidesigns.screens.ReceiptPage
import com.guvnoh.boma.uidesigns.screens.RecordDetails
import com.guvnoh.boma.uidesigns.screens.RecordsScreen


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Navigation(
    paddingValues: PaddingValues,
    navController: NavHostController,
    vm: BomaViewModel,
    ){
    val records: RecordViewModel  = viewModel()
    val record by records.record.collectAsState()
    //val recordsNavController = rememberNavController()

    NavHost(
        startDestination = Screen.Products.route,
        navController = navController

    ){
        composable(Screen.Products.route){ ProductsPage(navController, paddingValues, vm) }
        composable(Screen.PriceChange.route){ PriceChangePage(navController, paddingValues, vm) }
        composable(Screen.Receipt.route){ ReceiptPage(vm) }
        composable(Screen.AddProduct.route){ AddProduct(paddingValues, navController) }
        composable(Screen.DeleteProduct.route){ DeleteProduct(navController, paddingValues, vm) }
        composable(Screen.Stock.route){ StockPageNav(vm = vm, paddingValues = paddingValues) }
        composable(Screen.Records.route){ RecordsScreen(records, navController, paddingValues) }
        composable(Screen.RecordDetails.route){
            record?.let { selectedRecord -> RecordDetails(selectedRecord) }
        }
    }

}