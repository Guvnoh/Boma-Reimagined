package com.guvnoh.boma.uidesigns.cards

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import com.guvnoh.boma.models.EmptiesStock

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.guvnoh.boma.formatters.halfAndQuarter
import com.guvnoh.boma.models.FullsStock
import com.guvnoh.boma.models.Product
import com.guvnoh.boma.models.brandData
import kotlinx.coroutines.launch

//@Composable
//fun EmptiesStockCard(emptiesStock: EmptiesStock){
//    val scope = rememberCoroutineScope()
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(horizontal = 12.dp, vertical = 8.dp),
//        shape = CardDefaults.shape,
//        elevation = CardDefaults.cardElevation(6.dp),
//        onClick = {
//            scope.launch {
//            }
//        },
//        colors = CardDefaults.cardColors(
//            containerColor = MaterialTheme.colorScheme.surfaceVariant
//        )
//    ) {
//        Column(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(16.dp),
//            verticalArrangement = Arrangement.spacedBy(12.dp)
//        ) {
//            // Product Name
//            Text(
//                text = emptiesStock.company.name,
//                style = MaterialTheme.typography.titleLarge,
//                color = MaterialTheme.colorScheme.primary,
//                fontWeight = FontWeight.Bold
//            )
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.SpaceBetween
//            ) {
//                Text(
//                    text = "Available: ",
//                    style = MaterialTheme.typography.bodyMedium,
//                    fontWeight = FontWeight.Medium
//                )
//                Text(
//                    text = "${emptiesStock.quantity?.let {  halfAndQuarter(it)}}",
//                    style = MaterialTheme.typography.bodyMedium,
//                    color = MaterialTheme.colorScheme.onSurfaceVariant,
//                    fontWeight = FontWeight.Medium,
//                    modifier = Modifier.padding(end = 30.dp)
//
//                )
//            }
//
//        }
//
//    }
//}

@Composable
fun EmptiesStockCard(emptiesStock: EmptiesStock) {
    val scope = rememberCoroutineScope()

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        onClick = { scope.launch { /* handle click */ } },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // --- Header Row ---
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = emptiesStock.company?.name?:"unknown",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    color = MaterialTheme.colorScheme.primary
                )

                // Optional visual indicator for low stock
                val isLowStock = (emptiesStock.quantity ?: 0.0) < 25.0
                val indicatorColor = if (isLowStock)
                    MaterialTheme.colorScheme.error
                else
                    MaterialTheme.colorScheme.primary

                Box(
                    modifier = Modifier
                        .size(12.dp)
                        .background(indicatorColor, CircleShape)
                )
            }

            HorizontalDivider(
                color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.3f),
                thickness = 1.dp
            )


            // --- Current Stock ---
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Available",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = halfAndQuarter(emptiesStock.quantity ?: 0.0),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.SemiBold
                    ),
                    color = if ((emptiesStock.quantity ?: 0.0) <= 25.0)
                        MaterialTheme.colorScheme.error
                    else
                        MaterialTheme.colorScheme.onSurface
                )
            }

            // --- Optional Footer Highlight ---
            if ((emptiesStock.quantity ?: 0.0) <= 25.0) {
                Text(
                    text = "⚠️ Low stock — restock soon",
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = MaterialTheme.colorScheme.error
                    ),
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
private fun ShowStockCard(){
    StockCard(Product())
}