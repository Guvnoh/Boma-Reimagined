package com.guvnoh.boma.uidesigns.cards

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.guvnoh.boma.formatters.getDate
import com.guvnoh.boma.models.Receipt
import com.guvnoh.boma.models.RecordViewModel
import com.guvnoh.boma.models.SoldProduct
import com.guvnoh.boma.models.brandData
import com.guvnoh.boma.navigation.Screen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun RecordCard(
    record: Receipt,
    navController: NavHostController,
    vm: RecordViewModel
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp) ,
        onClick = {
                vm.setCurrentRecord(record)
                navController.navigate(Screen.RecordDetails.route) {
                    launchSingleTop = true
                }
                  },
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                // Customer name
                Text(
                    text = record.customerName?:"noName",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    color = MaterialTheme.colorScheme.onSurface
                )

                // Date (smaller and lighter)
                Text(
                    text = record.date?:"noDATE",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                )
            }

            // Optional amount or indicator (if available in Receipt)
            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = "₦${"%,.2f".format(record.grandTotal?.toDoubleOrNull())}",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    color = MaterialTheme.colorScheme.primary
                )

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "View Details",
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
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
            date = getDate(),
            soldProducts = listOf(
                SoldProduct(
                    product = brandData[0],
                    stringQuantity = "1",
                    doubleQuantity = 1.0,

                    )
            ),
        ), rememberNavController(), viewModel()
    )
}