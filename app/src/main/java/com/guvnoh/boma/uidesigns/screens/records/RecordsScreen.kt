package com.guvnoh.boma.uidesigns.screens.records

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.guvnoh.boma.uidesigns.screens.receipt.Receipt

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun RecordsScreen(
    vm: RecordViewModel,
    navController: NavHostController,
    paddingValues: PaddingValues
    ){
    val records by vm.records.collectAsState()

    var date by remember { mutableStateOf("") }

    val selectedItems = remember { mutableStateListOf<Receipt>() }

    val alert = remember { mutableStateOf(false) }


    Scaffold (
        modifier = Modifier.padding(paddingValues),
        topBar = {
            if (selectedItems.isNotEmpty()) {
                TopAppBar(
                    title = { Text("${selectedItems.size} selected") },
                    actions = {
                        IconButton(onClick = {
                            alert.value = true
                        }) {
                            Icon(Icons.Default.Delete, null)
                        }
                    }
                )
            }
        }

    ){
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
                    stickyHeader {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Text(
                                text = date,
                                style = MaterialTheme.typography.titleLarge,
                            )
                        }

                    }
                    items(records){
                            record ->
                        date = record.date.toString()

                        RecordCard(
                            record = record,
                            navController = navController,
                            vm = vm,
                            selected = selectedItems.contains(record),
                            selectedItems = selectedItems
                        )
                    }
                }
            }
        }
    }

    val context = LocalContext.current
    if (alert.value) {
        DeleteRecordAlertDialog(
            onDelete = {
                vm.deleteRecords(it)

                if (it.size == 1)
                    Toast.makeText(
                        context,
                        "${it.size} record deleted",
                        Toast.LENGTH_SHORT).show()
                else
                    Toast.makeText(
                        context,
                        "${it.size} records deleted",
                        Toast.LENGTH_SHORT).show()
                selectedItems.removeAll(it)
            },
            records = selectedItems,
            alert = alert,
        )
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeleteRecordAlertDialog(
    onDelete: (List<Receipt>) -> Unit,
    records: List<Receipt>,
    alert: MutableState<Boolean>,
){
    if (alert.value){
        BasicAlertDialog(
            onDismissRequest = {},
        ){
            Surface(
                shape = MaterialTheme.shapes.large,
                tonalElevation = AlertDialogDefaults.TonalElevation,
            ){
                Column (
                    modifier = Modifier.padding(24.dp)
                ){
                    Text(
                        text = "Delete Record(s)?",
                        style = MaterialTheme.typography.titleLarge
                    )
                    Text(
                        text = "Are you sure you want to delete selected record(s)?",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Spacer(modifier = Modifier.height(24.dp))

                    Row (
                        horizontalArrangement = Arrangement.End,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        TextButton(onClick = {alert.value = false}) {
                            Text(text = "Cancel")

                        }
                        TextButton(onClick = {
                            onDelete(records)
                            alert.value = false}) {
                            Text(
                                text = "Continue",
                                color = Color.Red
                                )
                        }
                    }
                }
            }
        }
    }
}
