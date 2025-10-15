package com.guvnoh.boma.uidesigns.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.guvnoh.boma.formatters.getDateTime
import com.guvnoh.boma.models.Receipt
import com.guvnoh.boma.models.RecordViewModel
import com.guvnoh.boma.models.SoldProduct
import com.guvnoh.boma.models.hero
import com.guvnoh.boma.navigation.Screen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun RecordCard(
    record: Receipt,
    navController: NavHostController,
    vm: RecordViewModel
){
    //val getDetails = remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp),
        shape = CardDefaults.shape,
        elevation = CardDefaults.cardElevation(6.dp),
        onClick = {
            vm.setCurrentRecord(record)
            navController.navigate(Screen.RecordDetails.route){
                launchSingleTop = true
            }

            //RecordsNavigation(record,vm, navController)

        },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    )  {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        )  {
            Text(
                text = record.customerName,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = record.date,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
private fun RecordsCardDemo(){
    RecordCard(
        Receipt(
            customerName = "Chukwuka",
            date = getDateTime(),
            soldProducts = listOf(
                SoldProduct(
                    product = hero[0],
                    stringQuantity = "1",
                    doubleQuantity = 1.0,

                    )
            ),
        ), rememberNavController(), viewModel()
    )
}