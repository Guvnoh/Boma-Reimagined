package com.guvnoh.boma.uidesigns.screens.addProduct

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
import androidx.navigation.compose.rememberNavController
import com.guvnoh.boma.models.EmptyCompany
import com.guvnoh.boma.models.ProductType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddProduct(
    padding: PaddingValues,
    navController: NavController,
    viewModel: AddProductViewModel
) {

    val newProduct by viewModel.newProduct

    var productName by remember { mutableStateOf(newProduct.name?:"") }
    var productPrice by remember { mutableStateOf(newProduct.stringPrice?:"") }
    //var emptiesType by remember { mutableStateOf<EmptyType?>(null) }
    var emptiesCompany by remember { mutableStateOf<EmptyCompany?>(newProduct.empties?.company?:EmptyCompany.HERO) }
    var productType by remember { mutableStateOf(newProduct.type?:ProductType.BOTTLE) }
    var categoryExpanded by remember { mutableStateOf(false) }
    var emptiesExpanded by remember { mutableStateOf(false) }

    val context = LocalContext.current


    var nameError by remember { mutableStateOf<String?>(null) }
    var priceError by remember { mutableStateOf<String?>(null) }



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
                            // Product name added
                            newProduct.name = name
                            nameError = viewModel.validateEntries("Name",productName)
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
                            //product prices added
                            newProduct.stringPrice = productPrice
                            newProduct.doublePrice = productPrice.toDoubleOrNull() ?: 0.0
                            priceError = viewModel.validateEntries("Price",productPrice)
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
                        expanded = categoryExpanded,
                        onExpandedChange = { categoryExpanded = !categoryExpanded }
                    ) {
                        //add category e.g can, pet or bottle
                        OutlinedTextField(
                            value = productType.name,
                            onValueChange = { categoryString ->
                                //the text field collects the text of the selected option
                                // and checks which product type matches that text

                                productType = ProductType.entries.first{it.name.equals(categoryString, ignoreCase = true)}
                                //new product category displayed on screen is set here
                                newProduct.type = productType
                            },
                            readOnly = true,
                            label = { Text("Category") },
                            trailingIcon = {
                                ExposedDropdownMenuDefaults.TrailingIcon(expanded = categoryExpanded)
                            },
                            modifier = Modifier
                                .menuAnchor()
                                .fillMaxWidth(),
                            shape = RoundedCornerShape(16.dp)
                        )
                        ExposedDropdownMenu(
                            expanded = categoryExpanded,
                            onDismissRequest = { categoryExpanded = false }
                        ) {
                            //setup product type/category e.g can, pet or bottle
                            ProductType.entries.forEach { option ->
                                DropdownMenuItem(
                                    text = { Text(option.name) },
                                    onClick = {
                                        productType = option
                                        categoryExpanded = false
                                        //new category/product type option created via drop down menu
                                        // when selected, already existing product type is updated
                                        newProduct.type = productType
                                        //setup default images for new products of different kinds
                                        val canImage = "can_image"
                                        if (productType == ProductType.CAN) newProduct.imageName = canImage

                                    }
                                )
                            }
                        }
                    }


                    if (productType == ProductType.BOTTLE){
                        // add empties company and type (e.g nb12)
                        ExposedDropdownMenuBox(
                            expanded = emptiesExpanded,
                            onExpandedChange = { emptiesExpanded = !emptiesExpanded }
                        ) {
                            OutlinedTextField(
                                //add empties type
                                value = emptiesCompany?.name?:"error",
                                onValueChange = {
                                    newProduct.empties?.company = emptiesCompany
                                },
                                readOnly = true,
                                label = { Text("Empty Type") },
                                trailingIcon = {
                                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = emptiesExpanded)
                                },
                                modifier = Modifier
                                    .menuAnchor()
                                    .fillMaxWidth(),
                                shape = RoundedCornerShape(16.dp)
                            )
                            ExposedDropdownMenu(
                                expanded = emptiesExpanded,
                                onDismissRequest = { emptiesExpanded = false }
                            ) {
                                EmptyCompany.entries.forEach { selected ->
                                    DropdownMenuItem(
                                        text = { Text(selected.name) },
                                        onClick = {
                                            //set new products empties company (for bottle products)
                                            emptiesCompany = selected //selected from dropdown
                                            emptiesExpanded = false
                                            //setup empties company via dropdown e.g nbl, cocacola
                                            newProduct.empties?.company = selected

                                            //setup empty type
                                            when (selected) {
                                                EmptyCompany.COCA_COLA -> {
                                                    newProduct.empties?.company = EmptyCompany.COCA_COLA
                                                }
                                                EmptyCompany.HERO -> {
                                                    newProduct.empties?.company = EmptyCompany.HERO
                                                }
                                                EmptyCompany.NBL -> {
                                                    newProduct.empties?.company = EmptyCompany.NBL
                                                }
                                                EmptyCompany.GUINNESS -> {
                                                    newProduct.empties?.company = EmptyCompany.GUINNESS
                                                }
                                            }

                                        }
                                    )
                                }
                            }
                        }

                    }

                    // Done Button
                    Button(
                        onClick = {
                            //product is added to database
                            viewModel.createNewProduct(navController = navController)
                            Toast.makeText(context,"Product added!", Toast.LENGTH_SHORT).show()
                        },
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

@Preview
@Composable
fun ShowAddScreen(){
    val avm: AddProductViewModel = viewModel()
    AddProduct(PaddingValues(5.dp), rememberNavController(),avm)
}