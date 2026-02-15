package com.guvnoh.boma.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.guvnoh.boma.models.PreferenceManager
import com.guvnoh.boma.models.Screen
import com.guvnoh.boma.uidesigns.screens.addProduct.AddProduct
import com.guvnoh.boma.uidesigns.screens.deleteProducts.DeleteProduct
import com.guvnoh.boma.uidesigns.screens.priceChange.PriceChangePage
import com.guvnoh.boma.uidesigns.screens.products.ProductsPage
import com.guvnoh.boma.uidesigns.screens.addProduct.AddProductViewModel
import com.guvnoh.boma.uidesigns.screens.receipt.ReceiptPage
import com.guvnoh.boma.uidesigns.screens.records.RecordDetails
import com.guvnoh.boma.uidesigns.screens.records.RecordsScreen
import com.guvnoh.boma.uidesigns.screens.priceChange.PriceChangeViewmodel
import com.guvnoh.boma.uidesigns.screens.receipt.ReceiptViewmodel
import com.guvnoh.boma.uidesigns.screens.records.RecordViewModel
import com.guvnoh.boma.viewmodels.AppMetaViewModel
import com.guvnoh.boma.uidesigns.screens.products.ProductsViewModel
import com.guvnoh.boma.uidesigns.screens.stock.StockViewModel


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Navigation(
    paddingValues: PaddingValues,
    navController: NavHostController,
    startDestination: String? = null
) {
    val context = LocalContext.current

    val records: RecordViewModel = viewModel()
    val record by records.record.collectAsState()
    val productsViewModel: ProductsViewModel = viewModel()
    val bomaViewModel: AppMetaViewModel = viewModel()
    val stockViewModel: StockViewModel = viewModel()
    val addProductViewModel: AddProductViewModel = viewModel()
    val receiptViewmodel: ReceiptViewmodel = viewModel()

    // Create PriceChangeViewmodel with PreferenceManager using factory
    val preferenceManager = PreferenceManager(context)
    val priceChangeViewmodel: PriceChangeViewmodel = viewModel(
        factory = PriceChangeViewmodel.Factory(preferenceManager)
    )

    LaunchedEffect(Unit) {
        bomaViewModel.checkDailyReset {
            AppMetaViewModel().resetSoldToday()
        }
    }

//    LaunchedEffect(Unit) {
//        FirebaseMessaging.getInstance().token
//            .addOnSuccessListener { token ->
//                Log.d("FCM", "Device token: $token")
//
//                // Save token to Firebase DB under this user/device
//                FirebaseRefs
//                    .Tokens
//                    .child(System.currentTimeMillis().toString())
//                    .setValue(token)
//            }
//    }

    NavHost(
        startDestination = startDestination ?: Screen.Products.route,
        navController = navController
    ) {
        composable(Screen.Products.route) {
            ProductsPage(navController, paddingValues, productsViewModel, receiptViewmodel)
        }
        composable(Screen.PriceChange.route) {
            PriceChangePage(navController, paddingValues, priceChangeViewmodel)
        }
        composable(Screen.Receipt.route) {
            ReceiptPage(stockViewModel, receiptViewmodel)
        }
        composable(Screen.AddProduct.route) {
            AddProduct(paddingValues, navController, addProductViewModel)
        }
        composable(Screen.DeleteProduct.route) {
            DeleteProduct(paddingValues, productsViewModel)
        }
        composable(Screen.Stock.route) {
            StockPageNav(vm = stockViewModel, paddingValues = paddingValues)
        }
        composable(Screen.WarehouseStock.route) {
            StockPageNav(vm = stockViewModel, paddingValues = paddingValues)
        }
        composable(Screen.Records.route) {
            RecordsScreen(records, navController, paddingValues)
        }
        composable(Screen.RecordDetails.route) {
            record?.let { selectedRecord -> RecordDetails(selectedRecord) }
        }
    }
}