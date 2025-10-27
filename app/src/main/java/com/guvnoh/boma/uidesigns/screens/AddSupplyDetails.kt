package com.guvnoh.boma.uidesigns.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.guvnoh.boma.models.Product
import com.guvnoh.boma.models.ReceivedStock

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateStockCard(padding: PaddingValues,product: Product){
    var quantity by remember { mutableStateOf("") }
    var source by remember { mutableStateOf("") }
    var stock = ReceivedStock(product,0.0,source)
    var nameError by remember { mutableStateOf<String?>(null) }
    var sourceError by remember { mutableStateOf<String?>(null) }
    Scaffold(
        modifier = Modifier.padding(padding),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Add Received Stock",
                        style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold)
                    )
                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.TopCenter
        ) {
            Card(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                shape = RoundedCornerShape(28.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    Text(
                        text = "Enter product details below",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    // Quantity received
                    OutlinedTextField(
                        value = quantity,
                        onValueChange = { entry ->
                            quantity = entry
                            stock.quantity = entry.toDoubleOrNull()

                            nameError = if ((quantity.toDoubleOrNull() ?: 0.0) <= 0.0) "Valid quantity is required" else null
                        },
                        label = { Text("Product Quantity") },
                        modifier = Modifier.fillMaxWidth(),
                        isError = nameError != null,
                        singleLine = true,
                        supportingText = {
                            if (nameError != null) {
                                Text(nameError!!, color = MaterialTheme.colorScheme.error)
                            }
                        },
                        shape = RoundedCornerShape(16.dp)
                    )

                    // Supplier info
                    OutlinedTextField(
                        value = source,
                        onValueChange = { input ->
                            stock.source = input

                        },
                        label = { Text("Supplier") },
                        modifier = Modifier.fillMaxWidth(),
                        isError = sourceError != null,
                        singleLine = true,
                        supportingText = {
                            if (sourceError != null) {
                                Text(sourceError!!, color = MaterialTheme.colorScheme.error)
                            }
                        },
                        shape = RoundedCornerShape(16.dp)
                    )


                    // Done Button
                    Button(
                        onClick = {}
//                            if (productName.isNotBlank() && productPrice.isNotBlank() && category.isNotBlank()) {
//                                databasePrices.child(newProduct.name).setValue(newProduct)
//                                navController.navigate(Screen.Products.route) {
//                                    popUpTo(navController.graph.findStartDestination().id) {
//                                        inclusive = true
//                                    }
//                                    launchSingleTop = true
//                                }
//                            } else {
//                                if (productName.isBlank()) nameError = "Name is required"
//                                if (productPrice.isBlank()) priceError = "Price is required"
//                                if (category.isBlank()) categoryError = "Category is required"
//                                Toast.makeText(context, "Please enter all fields", Toast.LENGTH_SHORT).show()
//                            }
//                        },
                                ,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                        shape = CircleShape
                    ) {
                        Icon(Icons.Filled.Done, contentDescription = "Done")
                        Spacer(Modifier.width(8.dp))
                        Text("Save Product", style = MaterialTheme.typography.labelLarge)
                    }
                }
            }
        }
    }
}