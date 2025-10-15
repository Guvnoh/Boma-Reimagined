//package com.guvnoh.boma.navigation
//
//import android.os.Build
//import androidx.annotation.RequiresApi
//import androidx.compose.runtime.Composable
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import com.guvnoh.boma.models.RecordViewModel
//import com.guvnoh.boma.uidesigns.screens.RecordDetails
//
//@RequiresApi(Build.VERSION_CODES.O)
//@Composable
//fun RecordsNavigation(vm: RecordViewModel, navHostController: NavHostController) {
//
//    NavHost(
//        startDestination = Screen.RecordDetails.route,
//        navController = navHostController
//
//    ) {
//        composable(Screen.RecordDetails.route){ RecordDetails(vm) }
//
//    }
//}
