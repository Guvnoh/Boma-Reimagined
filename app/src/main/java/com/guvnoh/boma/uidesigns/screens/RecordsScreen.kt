package com.guvnoh.boma.uidesigns.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.guvnoh.boma.models.RecordViewModel
import com.guvnoh.boma.uidesigns.cards.RecordCard

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun RecordsScreen(
    vm: RecordViewModel,
    navController: NavHostController,
    paddingValues: PaddingValues
    ){
val records by vm.records.collectAsState()
    Scaffold (modifier = Modifier.padding(paddingValues)){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (records.isEmpty()){
                Column (
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text("No Records Yet!")
                }
            }else{
                LazyColumn {
                    items(records){
                            record ->

                        RecordCard(
                            record = record,
                            navController = navController,
                            vm = vm)
                    }
                }
            }
        }
    }

}
