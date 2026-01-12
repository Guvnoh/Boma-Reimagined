package com.guvnoh.boma.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.guvnoh.boma.models.Screen
import com.guvnoh.boma.uidesigns.screens.AddProduct
import com.guvnoh.boma.uidesigns.screens.DeleteProduct
import com.guvnoh.boma.uidesigns.screens.priceChange.PriceChangePage
import com.guvnoh.boma.uidesigns.screens.ProductsPage
import com.guvnoh.boma.uidesigns.screens.receipt.ReceiptPage
import com.guvnoh.boma.uidesigns.screens.records.RecordDetails
import com.guvnoh.boma.uidesigns.screens.records.RecordsScreen
import com.guvnoh.boma.uidesigns.screens.priceChange.PriceChangeViewmodel
import com.guvnoh.boma.uidesigns.screens.receipt.ReceiptViewmodel
import com.guvnoh.boma.uidesigns.screens.records.RecordViewModel
import com.guvnoh.boma.viewmodels.AppMetaViewModel
import com.guvnoh.boma.viewmodels.ProductsViewModel
import com.guvnoh.boma.uidesigns.screens.stock.StockViewModel


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Navigation(
    paddingValues: PaddingValues,
    navController: NavHostController,
    ){

    val records: RecordViewModel = viewModel()
    val record by records.record.collectAsState()
    val productsViewModel: ProductsViewModel = viewModel()
    val bomaViewModel: AppMetaViewModel = viewModel()
    val stockViewModel: StockViewModel = viewModel()
    val receiptViewmodel: ReceiptViewmodel = viewModel()
    val priceChangeViewmodel: PriceChangeViewmodel = viewModel()





    LaunchedEffect(Unit) {
        bomaViewModel.checkDailyReset{
            AppMetaViewModel().resetSoldToday()
        }
    }



    NavHost(
        startDestination = Screen.Products.route,
        navController = navController

    ){
        composable(Screen.Products.route){ ProductsPage(navController, paddingValues, productsViewModel, receiptViewmodel) }
        composable(Screen.PriceChange.route){ PriceChangePage(navController, paddingValues, priceChangeViewmodel) }
        composable(Screen.Receipt.route){ ReceiptPage(stockViewModel, receiptViewmodel) }
        composable(Screen.AddProduct.route){ AddProduct(paddingValues, navController, productsViewModel) }
        composable(Screen.DeleteProduct.route){ DeleteProduct(navController, paddingValues, productsViewModel) }
        composable(Screen.Stock.route){ StockPageNav(vm = stockViewModel, paddingValues = paddingValues) }
        composable(Screen.WarehouseStock.route){ StockPageNav(vm = stockViewModel, paddingValues = paddingValues) }
        composable(Screen.Records.route){ RecordsScreen(records, navController, paddingValues) }
        composable(Screen.RecordDetails.route){
            record?.let { selectedRecord -> RecordDetails(selectedRecord) }
        }
    }

}