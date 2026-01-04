package com.guvnoh.boma.uidesigns.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController
import com.guvnoh.boma.models.Product
import com.guvnoh.boma.models.Empties
import com.guvnoh.boma.models.EmptyCompany
import com.guvnoh.boma.models.EmptyType
import com.guvnoh.boma.models.ProductType
import com.guvnoh.boma.models.Screen
import com.guvnoh.boma.viewmodels.ProductsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddProduct(padding: PaddingValues,
               navController: NavController,
               productsViewModel: ProductsViewModel) {

    var productName by remember { mutableStateOf("") }
    var productPrice by remember { mutableStateOf("") }
    val noOfBottles by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    var isBottleProduct by remember { mutableStateOf(false) }

    val context = LocalContext.current


    var nameError by remember { mutableStateOf<String?>(null) }
    var priceError by remember { mutableStateOf<String?>(null) }
    var categoryError by remember { mutableStateOf<String?>(null) }

    val sortCategories = listOf(
        "COCACOLA", "HERO", "NBL", "GUINNESS", "PETS", "CANS", "OTHER"
    )

    val newProduct = Product()

    Scaffold(
        modifier = Modifier.padding(padding),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Add Product",
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

                    // Product Name
                    OutlinedTextField(
                        value = productName,
                        onValueChange = { name ->
                            productName = name
                            newProduct.name = name
                            nameError = if (name.isBlank()) "Name is required" else null
                        },
                        label = { Text("Product Name") },
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

                    // Product Price
                    OutlinedTextField(
                        value = productPrice,
                        onValueChange = { input ->
                            productPrice = input.filter { it.isDigit() || it == '.' }
                            newProduct.stringPrice = productPrice
                            newProduct.doublePrice = productPrice.toDoubleOrNull() ?: 0.0
                            priceError = if (productPrice.isBlank()) "Price is required" else null
                        },
                        label = { Text("Product Price (₦)") },
                        modifier = Modifier.fillMaxWidth(),
                        isError = priceError != null,
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        supportingText = {
                            if (priceError != null) {
                                Text(priceError!!, color = MaterialTheme.colorScheme.error)
                            }
                        },
                        shape = RoundedCornerShape(16.dp)
                    )

                    // Category Dropdown
                    ExposedDropdownMenuBox(
                        expanded = expanded,
                        onExpandedChange = { expanded = !expanded }
                    ) {
                        OutlinedTextField(
                            value = category,
                            onValueChange = {},
                            readOnly = true,
                            label = { Text("Category") },
                            trailingIcon = {
                                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                            },
                            isError = categoryError != null,
                            supportingText = {
                                if (categoryError != null) {
                                    Text(categoryError!!, color = MaterialTheme.colorScheme.error)
                                }
                            },
                            modifier = Modifier
                                .menuAnchor()
                                .fillMaxWidth(),
                            shape = RoundedCornerShape(16.dp)
                        )
                        ExposedDropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false }
                        ) {
                            sortCategories.forEach { option ->
                                DropdownMenuItem(
                                    text = { Text(option) },
                                    onClick = {
                                        category = option
                                        expanded = false
                                        when (option) {
                                            "COCACOLA" -> {
                                                newProduct.empties = Empties(EmptyCompany.COCA_COLA)
                                                isBottleProduct = true
                                            }
                                            "HERO" -> {
                                                newProduct.empties = Empties(EmptyCompany.HERO)
                                                isBottleProduct = true
                                            }
                                            "NBL" -> {
                                                newProduct.empties = Empties(EmptyCompany.NBL)
                                                isBottleProduct = true
                                            }
                                            "GUINNESS" -> {
                                                newProduct.empties = Empties(EmptyCompany.GUINNESS)
                                                isBottleProduct = true
                                            }
                                            else -> {isBottleProduct = false}
                                        }
                                        categoryError = null
                                    }
                                )
                            }
                        }
                    }


                    if (isBottleProduct){
                        ExposedDropdownMenuBox(
                            expanded = expanded,
                            onExpandedChange = { expanded = !expanded }
                        ) {
                            OutlinedTextField(
                                value = category,
                                onValueChange = {},
                                readOnly = true,
                                label = { Text("Empty Type") },
                                trailingIcon = {
                                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                                },
                                isError = categoryError != null,
                                supportingText = {
                                    if (categoryError != null) {
                                        Text(categoryError!!, color = MaterialTheme.colorScheme.error)
                                    }
                                },
                                modifier = Modifier
                                    .menuAnchor()
                                    .fillMaxWidth(),
                                shape = RoundedCornerShape(16.dp)
                            )
                            ExposedDropdownMenu(
                                expanded = expanded,
                                onDismissRequest = { expanded = false }
                            ) {
                                noOfBottles.forEach { option ->
                                    DropdownMenuItem(
                                        text = { Text(option.toString()) },
                                        onClick = {
                                            expanded = false

                                            //no of bottles
                                            newProduct.empties?.emptyType = when(option.toString()){
                                                "12" -> EmptyType.TWELVE
                                                "18" -> EmptyType.EIGHTEEN
                                                "20" -> EmptyType.TWENTY
                                                "24" -> EmptyType.TWENTY_FOUR
                                                else -> EmptyType.TWELVE

                                            }

                                            categoryError = null
                                        }
                                    )
                                }
                            }
                        }

                    }

                    // Done Button
                    Button(
                        onClick = {
                            if (productName.isNotBlank()
                                && productPrice.isNotBlank()
                                && category.isNotBlank()
                                && isBottleProduct) {
                                newProduct.type = ProductType.BOTTLE
                                productsViewModel.addProduct(newProduct)
                                navController.navigate(Screen.Products.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        inclusive = true
                                    }
                                    launchSingleTop = true
                                }
                            } else {
                                if (productName.isBlank()) nameError = "Name is required"
                                if (productPrice.isBlank()) priceError = "Price is required"
                                if (category.isBlank()) categoryError = "Category is required"
                                Toast.makeText(context, "Incomplete product details!", Toast.LENGTH_SHORT).show()
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                        shape = CircleShape
                    ) {
                        Icon(Icons.Filled.Done, contentDescription = "Lmaooooooooo")
                        Spacer(Modifier.width(8.dp))
                        Text("Save Product", style = MaterialTheme.typography.labelLarge)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun ShowAddScreen(){
    val pvm: ProductsViewModel = viewModel()
    AddProduct(PaddingValues(5.dp), rememberNavController(), pvm)
}