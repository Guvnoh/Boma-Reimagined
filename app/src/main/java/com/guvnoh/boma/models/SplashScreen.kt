package com.guvnoh.boma.models

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Text

@Composable
fun StockSplashScreen(
    modifier: Modifier,
    onTimeOut: () -> Unit,
    list: MutableList<Stock>,
){
    Box (
        modifier = modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        LaunchedEffect(list) {
            if (list.isNotEmpty()){
                onTimeOut()
            }

        }
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = "Loading...",
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.padding(vertical = 8.dp))
            CircularProgressIndicator()
        }
    }
}

@Composable
fun ProductSplashScreen(
    modifier: Modifier,
    onTimeOut: () -> Unit,
    list: MutableList<Product>,
){
    Box (
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        LaunchedEffect(list) {
            if (list.isNotEmpty()){
                onTimeOut()
            }
        }
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = "Loading...",
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.padding(vertical = 8.dp))
            CircularProgressIndicator()
        }
    }
}