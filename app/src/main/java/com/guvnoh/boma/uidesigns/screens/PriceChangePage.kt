package com.guvnoh.boma.uidesigns.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.guvnoh.boma.models.Product
import com.guvnoh.boma.models.productList
import com.guvnoh.boma.uidesigns.PriceChangeCard

@Composable
fun PriceChangePage(navController: NavController, paddingValues: PaddingValues){
    LazyColumn (modifier = Modifier.padding(paddingValues)){
        items(productList){
            product ->
            PriceChangeCard(product)
        }
    }
}