//package com.guvnoh.boma.uidesigns.screens.priceChange
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.border
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.input.KeyboardType
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.lifecycle.viewmodel.compose.viewModel
//import com.guvnoh.boma.R
//import com.guvnoh.boma.formatters.nairaFormat
//import com.guvnoh.boma.models.AutoScrollingText
//import com.guvnoh.boma.models.Product
//import com.guvnoh.boma.models.brandData
//import com.guvnoh.boma.repositories.ProductsRepository
//import com.guvnoh.boma.viewmodels.ProductsViewModel
//
//@Composable
//fun PriceChangeCard(
//    product: Product,
//    priceChangeViewmodel: PriceChangeViewmodel
//) {
//
//    var newPrice by remember { mutableStateOf("") }
//    var priceError by remember { mutableStateOf<String?>(null) }
//
//    val context = LocalContext.current
//    val imageRes = ProductsRepository()
//        .getImage(context, product.imageName?:"bottle.jpg")
//        .takeIf { it != 0 } ?: R.drawable.bottle
//
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(horizontal = 16.dp, vertical = 8.dp),
//        shape = RoundedCornerShape(20.dp),
//        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
//        colors = CardDefaults.cardColors(
//            containerColor = MaterialTheme.colorScheme.surfaceVariant
//        )
//    ) {
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(16.dp),
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.spacedBy(16.dp)
//        ) {
//            // 🖼️ Product Image
//            Image(
//                painter = painterResource(imageRes),
//                contentDescription = product.name,
//                contentScale = ContentScale.Crop,
//                modifier = Modifier
//                    .size(72.dp)
//                    .clip(CircleShape)
//                    .border(2.dp, MaterialTheme.colorScheme.outlineVariant, CircleShape)
//            )
//
//            // 🧾 Product Info
//            Column(
//                modifier = Modifier
//                    .weight(1f)
//                    .padding(end = 8.dp),
//                verticalArrangement = Arrangement.spacedBy(6.dp)
//            ) {
//                //auto scrolling text enables long product names animated horizontal movement
//                AutoScrollingText(
//                    text = product.name ?: "unknown",
//                    modifier = Modifier,
//                )
//
//                //Price Display
//                val price = newPrice.ifEmpty {
//                    (product.stringPrice?.toDoubleOrNull() ?: 0.0).toString()
//                }
//                Text(
//                    text = if (priceError == null) nairaFormat(price.toDouble()) else "₦0.00",
//                    style = MaterialTheme.typography.bodyMedium.copy(
//                        color = MaterialTheme.colorScheme.primary,
//                        fontWeight = FontWeight.Medium,
//                        fontSize = 15.sp
//                    )
//                )
//            }
//
//             //New Price input
//            OutlinedTextField(
//                value = newPrice,
//                onValueChange = {
//                    newPrice = ""
//                    priceChangeViewmodel.changePrices(
//                        newPrice = newPrice,
//                        product = product,
//                    )
//                    newPrice = it
//                    priceChangeViewmodel.changePrices(
//                        newPrice = newPrice,
//                        product = product,
//                    )
//                    priceError = priceChangeViewmodel.errorCheck(newPrice)
//                },
//                label = { Text("New Price") },
//                singleLine = true,
//                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//                isError = priceError != null,
//                supportingText = {
//                    if (priceError != null) {
//                        Text(priceError!!, color = MaterialTheme.colorScheme.error)
//                    }
//                },
//                modifier = Modifier.width(120.dp),
//                shape = RoundedCornerShape(12.dp)
//            )
//        }
//    }
//}
//
//
//@Preview(showBackground = true)
//@Composable
//fun ShowCard() {
//    PriceChangeCard(brandData[1], viewModel())
//}
//package com.guvnoh.boma.uidesigns.screens.priceChange
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.border
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Edit
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Brush
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.input.KeyboardType
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.lifecycle.viewmodel.compose.viewModel
//import com.guvnoh.boma.R
//import com.guvnoh.boma.formatters.nairaFormat
//import com.guvnoh.boma.models.Product
//import com.guvnoh.boma.models.brandData
//import com.guvnoh.boma.repositories.ProductsRepository
//
//@Composable
//fun PriceChangeCard(
//    product: Product,
//    priceChangeViewmodel: PriceChangeViewmodel
//) {
//    var newPrice by remember { mutableStateOf("") }
//    var priceError by remember { mutableStateOf<String?>(null) }
//    var isEditing by remember { mutableStateOf(false) }
//
//    val context = LocalContext.current
//    val imageRes = ProductsRepository()
//        .getImage(context, product.imageName ?: "bottle.jpg")
//        .takeIf { it != 0 } ?: R.drawable.bottle
//
//    val currentPrice = product.doublePrice ?: product.stringPrice?.toDoubleOrNull() ?: 0.0
//    val displayPrice = if (newPrice.isNotEmpty() && priceError == null) {
//        newPrice.toDoubleOrNull() ?: currentPrice
//    } else {
//        currentPrice
//    }
//
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(horizontal = 16.dp, vertical = 8.dp),
//        shape = RoundedCornerShape(24.dp),
//        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
//        colors = CardDefaults.cardColors(
//            containerColor = MaterialTheme.colorScheme.surface
//        )
//    ) {
//        Column(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(20.dp)
//        ) {
//            // Header Row: Product Image + Name
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.spacedBy(16.dp)
//            ) {
//                // Product Image with gradient border
//                Box(
//                    modifier = Modifier
//                        .size(72.dp)
//                        .clip(CircleShape)
//                        .background(
//                            brush = Brush.linearGradient(
//                                colors = listOf(
//                                    MaterialTheme.colorScheme.primary.copy(alpha = 0.2f),
//                                    MaterialTheme.colorScheme.secondary.copy(alpha = 0.2f)
//                                )
//                            )
//                        ),
//                    contentAlignment = Alignment.Center
//                ) {
//                    Image(
//                        painter = painterResource(imageRes),
//                        contentDescription = product.name,
//                        contentScale = ContentScale.Crop,
//                        modifier = Modifier
//                            .size(60.dp)
//                            .clip(CircleShape)
//                            .border(2.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.3f), CircleShape)
//                    )
//                }
//
//                // Product Name
//                Column(
//                    modifier = Modifier.weight(1f),
//                    verticalArrangement = Arrangement.spacedBy(4.dp)
//                ) {
//                    Text(
//                        text = product.name ?: "Unknown Product",
//                        style = MaterialTheme.typography.titleLarge.copy(
//                            fontWeight = FontWeight.Bold,
//                            fontSize = 20.sp
//                        ),
//                        color = MaterialTheme.colorScheme.onSurface
//                    )
//                }
//            }
//
//            Spacer(modifier = Modifier.height(20.dp))
//
//            // Price Display Section
//            Surface(
//                modifier = Modifier.fillMaxWidth(),
//                shape = RoundedCornerShape(16.dp),
//                color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.15f)
//            ) {
//                Column(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(16.dp),
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                    verticalArrangement = Arrangement.spacedBy(8.dp)
//                ) {
//                    Text(
//                        text = "Current Price",
//                        style = MaterialTheme.typography.bodyMedium,
//                        color = MaterialTheme.colorScheme.onSurfaceVariant,
//                        fontSize = 13.sp
//                    )
//
//                    Text(
//                        text = nairaFormat(displayPrice),
//                        style = MaterialTheme.typography.displaySmall.copy(
//                            fontWeight = FontWeight.ExtraBold
//                        ),
//                        color = MaterialTheme.colorScheme.primary,
//                        textAlign = TextAlign.Center
//                    )
//                }
//            }
//
//            Spacer(modifier = Modifier.height(20.dp))
//
//            // Edit Section
//            if (!isEditing) {
//                // Edit Button
//                OutlinedButton(
//                    onClick = { isEditing = true },
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(56.dp),
//                    shape = RoundedCornerShape(16.dp),
//                    colors = ButtonDefaults.outlinedButtonColors(
//                        contentColor = MaterialTheme.colorScheme.primary
//                    )
//                ) {
//                    Icon(
//                        imageVector = Icons.Default.Edit,
//                        contentDescription = "Edit Price",
//                        modifier = Modifier.size(20.dp)
//                    )
//                    Spacer(Modifier.width(8.dp))
//                    Text(
//                        text = "Change Price",
//                        style = MaterialTheme.typography.titleMedium.copy(
//                            fontWeight = FontWeight.SemiBold
//                        )
//                    )
//                }
//            } else {
//                // Edit Mode: Input Field + Buttons
//                Column(
//                    modifier = Modifier.fillMaxWidth(),
//                    verticalArrangement = Arrangement.spacedBy(12.dp)
//                ) {
//                    OutlinedTextField(
//                        value = newPrice,
//                        onValueChange = { input ->
//                            // Filter input to only allow digits and one decimal point
//                            val filtered = input.filter { it.isDigit() || it == '.' }
//
//                            // Prevent multiple decimal points
//                            val decimalCount = filtered.count { it == '.' }
//                            if (decimalCount <= 1) {
//                                newPrice = filtered
//
//                                // Update viewmodel
//                                if (filtered.isNotEmpty() && filtered != ".") {
//                                    priceChangeViewmodel.changePrices(
//                                        newPrice = filtered,
//                                        product = product
//                                    )
//                                }
//
//                                // Validate input
//                                priceError = priceChangeViewmodel.errorCheck(filtered)
//                            }
//                        },
//                        label = {
//                            Text(
//                                "New Price",
//                                style = MaterialTheme.typography.bodyLarge
//                            )
//                        },
//                        leadingIcon = {
//                            Text(
//                                "₦",
//                                style = MaterialTheme.typography.titleLarge.copy(
//                                    fontWeight = FontWeight.Bold,
//                                    color = MaterialTheme.colorScheme.primary
//                                )
//                            )
//                        },
//                        placeholder = {
//                            Text(
//                                nairaFormat(currentPrice).removePrefix("₦"),
//                                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f)
//                            )
//                        },
//                        singleLine = true,
//                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
//                        isError = priceError != null,
//                        supportingText = {
//                            if (priceError != null) {
//                                Text(
//                                    priceError!!,
//                                    color = MaterialTheme.colorScheme.error,
//                                    style = MaterialTheme.typography.bodySmall
//                                )
//                            }
//                        },
//                        modifier = Modifier.fillMaxWidth(),
//                        shape = RoundedCornerShape(16.dp),
//                        colors = OutlinedTextFieldDefaults.colors(
//                            focusedBorderColor = MaterialTheme.colorScheme.primary,
//                            unfocusedBorderColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.5f)
//                        ),
//                        textStyle = MaterialTheme.typography.titleLarge.copy(
//                            fontWeight = FontWeight.Bold
//                        )
//                    )
//
//                    // Action Buttons
//                    Row(
//                        modifier = Modifier.fillMaxWidth(),
//                        horizontalArrangement = Arrangement.spacedBy(12.dp)
//                    ) {
//                        // Cancel Button
//                        OutlinedButton(
//                            onClick = {
//                                newPrice = ""
//                                priceError = null
//                                isEditing = false
//                            },
//                            modifier = Modifier
//                                .weight(1f)
//                                .height(48.dp),
//                            shape = RoundedCornerShape(12.dp),
//                            colors = ButtonDefaults.outlinedButtonColors(
//                                contentColor = MaterialTheme.colorScheme.onSurfaceVariant
//                            )
//                        ) {
//                            Text(
//                                "Cancel",
//                                style = MaterialTheme.typography.titleMedium
//                            )
//                        }
//
//                        // Save Button
//                        Button(
//                            onClick = {
//                                if (priceError == null && newPrice.isNotEmpty()) {
//                                    isEditing = false
//                                }
//                            },
//                            modifier = Modifier
//                                .weight(1f)
//                                .height(48.dp),
//                            enabled = priceError == null && newPrice.isNotEmpty(),
//                            shape = RoundedCornerShape(12.dp),
//                            colors = ButtonDefaults.buttonColors(
//                                containerColor = MaterialTheme.colorScheme.primary
//                            )
//                        ) {
//                            Text(
//                                "Save",
//                                style = MaterialTheme.typography.titleMedium.copy(
//                                    fontWeight = FontWeight.Bold
//                                )
//                            )
//                        }
//                    }
//                }
//            }
//        }
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun ShowCard() {
//    MaterialTheme {
//        Surface(
//            modifier = Modifier
//                .fillMaxSize()
//                .background(MaterialTheme.colorScheme.background)
//                .padding(16.dp)
//        ) {
//            PriceChangeCard(brandData[1], viewModel())
//        }
//    }
//}

package com.guvnoh.boma.uidesigns.screens.priceChange

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.guvnoh.boma.R
import com.guvnoh.boma.formatters.nairaFormat
import com.guvnoh.boma.models.Product
import com.guvnoh.boma.models.brandData
import com.guvnoh.boma.repositories.ProductsRepository

@Composable
fun PriceChangeCard(
    product: Product,
    priceChangeViewmodel: PriceChangeViewmodel
) {
    var newPrice by remember { mutableStateOf("") }
    var priceError by remember { mutableStateOf<String?>(null) }
    var isExpanded by remember { mutableStateOf(false) }

    val context = LocalContext.current
    val imageRes = ProductsRepository()
        .getImage(context, product.imageName ?: "bottle.jpg")
        .takeIf { it != 0 } ?: R.drawable.bottle

    val currentPrice by remember { mutableDoubleStateOf(
        product.doublePrice ?: product.stringPrice?.toDoubleOrNull() ?: 0.0)}
    val pendingPrice = newPrice.toDoubleOrNull()?:0.0
    val priceChange  = pendingPrice - currentPrice
    val priceChangePercent  = if (currentPrice >0.0 && pendingPrice >0.0 ) {
        ((pendingPrice - currentPrice) / currentPrice) * 100
    } else 0.0


    Card(
        onClick = { isExpanded = !isExpanded },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 6.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isExpanded)
                MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.08f)
            else
                MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = if (isExpanded) 4.dp else 2.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Main Row: Image + Product Info + Price
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                // Product Image
                Surface(
                    modifier = Modifier.size(64.dp),
                    shape = CircleShape,
                    color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                ) {
                    Image(
                        painter = painterResource(imageRes),
                        contentDescription = product.name,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.padding(8.dp)
                    )
                }

                // Product Name & Current Price
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = product.name ?: "Unknown",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold
                        ),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = nairaFormat(currentPrice),
                            style = MaterialTheme.typography.bodyLarge.copy(
                                fontWeight = FontWeight.SemiBold
                            ),
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        if (pendingPrice != null && priceError == null) {
                            Icon(
                                imageVector = Icons.Default.TrendingUp,
                                contentDescription = null,
                                modifier = Modifier.size(16.dp),
                                tint = if (priceChange!! > 0)
                                    Color(0xFF4CAF50)
                                else
                                    Color(0xFFF44336)
                            )
                        }
                    }
                }

                // New Price Badge
                if (priceError == null && pendingPrice >0.0) {
                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(start = 4.dp)
                    ) {
                        Text(
                            text = nairaFormat(pendingPrice),
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                            style = MaterialTheme.typography.labelLarge.copy(
                                fontWeight = FontWeight.Bold
                            ),
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                }
            }

            // Expanded Section: Input + Stats
            AnimatedVisibility(
                visible = isExpanded,
                enter = expandVertically() + fadeIn(),
                exit = shrinkVertically() + fadeOut()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Divider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))

                    // Input Field
                    OutlinedTextField(
                        value = newPrice,
                        onValueChange = { input ->
                            val filtered = input.filter { it.isDigit() || it == '.' }
                            if (filtered.count { it == '.' } <= 1) {
                                newPrice = filtered
                                if (filtered.isNotEmpty()) {
                                    priceChangeViewmodel.changePrices(
                                        newPrice = filtered,
                                        product = product
                                    )
                                }
                                priceError = priceChangeViewmodel.errorCheck(filtered)
                            }
                        },
                        label = { Text("Enter New Price") },
                        leadingIcon = {
                            Text(
                                "₦",
                                style = MaterialTheme.typography.titleMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.primary
                                )
                            )
                        },
                        trailingIcon = {
                            if (newPrice.isNotEmpty()) {
                                IconButton(onClick = {
                                    newPrice = ""
                                    priceError = null
                                }) {
                                    Icon(
                                        Icons.Default.Close,
                                        contentDescription = "Clear",
                                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                            }
                        },
                        placeholder = {
                            Text(
                                currentPrice.toString(),
                                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.4f)
                            )
                        },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                        isError = priceError != null,
                        supportingText = {
                            if (priceError != null) {
                                Text(priceError!!, color = MaterialTheme.colorScheme.error)
                            }
                        },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(14.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = MaterialTheme.colorScheme.primary,
                            unfocusedBorderColor = MaterialTheme.colorScheme.outline
                        )
                    )

                    // Price Change Stats
                    if (priceError == null) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            // Change Amount
                            Surface(
                                modifier = Modifier.weight(1f),
                                shape = RoundedCornerShape(12.dp),
                                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                            ) {
                                Column(
                                    modifier = Modifier.padding(12.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = "Change",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                    Text(
                                        text = "${if (priceChange > 0) "+" else ""}${nairaFormat(priceChange)}",
                                        style = MaterialTheme.typography.titleMedium.copy(
                                            fontWeight = FontWeight.Bold
                                        ),
                                        color = if (priceChange > 0) Color(0xFF4CAF50) else Color(0xFFF44336)
                                    )
                                }
                            }

                            // Percentage Change

                            Surface(
                                modifier = Modifier.weight(1f),
                                shape = RoundedCornerShape(12.dp),
                                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                            ) {
                                Column(
                                    modifier = Modifier.padding(12.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = "Percent",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                    Text(
                                        text = "${if (priceChangePercent > 0) "+" else ""}%.1f%%".format(priceChangePercent),
                                        style = MaterialTheme.typography.titleMedium.copy(
                                            fontWeight = FontWeight.Bold
                                        ),
                                        color = if (priceChangePercent > 0) Color(0xFF4CAF50) else Color(0xFFF44336)
                                    )
                                }
                            }
                        }
                    }

                    // Confirm Button
                    if (priceError == null) {
                        Button(
                            onClick = {
                                newPrice = ""
                                isExpanded = false
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(48.dp),
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.primary
                            )
                        ) {
                            Icon(Icons.Default.Check, contentDescription = null)
                            Spacer(Modifier.width(8.dp))
                            Text(
                                "Confirm Price Change",
                                style = MaterialTheme.typography.titleMedium.copy(
                                    fontWeight = FontWeight.SemiBold
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ShowCard() {
    MaterialTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            Column(
                modifier = Modifier.padding(vertical = 16.dp)
            ) {
                PriceChangeCard(brandData[1], viewModel())
            }
        }
    }
}