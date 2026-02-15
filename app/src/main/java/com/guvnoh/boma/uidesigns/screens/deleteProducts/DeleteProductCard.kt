package com.guvnoh.boma.uidesigns.screens.deleteProducts

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.material3.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.guvnoh.boma.models.Products
import com.guvnoh.boma.formatters.nairaFormat
import com.guvnoh.boma.models.ProductType
import com.guvnoh.boma.models.brandData
import com.guvnoh.boma.repositories.ProductsRepository
import com.guvnoh.boma.uidesigns.screens.products.ProductsViewModel

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDeletionDialog(
    product: Products,
    productsViewModel: ProductsViewModel,
    alert: MutableState<Boolean>){
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
                        text = "Delete product?",
                        style = MaterialTheme.typography.titleLarge
                    )
                    Text(
                        text = "Are you sure you want to delete this product?",
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
                            productsViewModel.deleteProduct(product.id!!)
                            alert.value = false}) {
                            Text(
                                text = "Continue",
                                color = MaterialTheme.colorScheme.error
                            )
                        }
                    }
                }
            }
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DeleteProductCard(
    productsViewModel: ProductsViewModel,
    product: Products,
) {
    val alert = remember { mutableStateOf(false) }
    val context = LocalContext.current
    val resId =
        ProductsRepository().getImage(context, product.imageName ?: "bottle", product.type?:ProductType.BOTTLE)

    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // 🖼 Product Image with gradient ring
            Box(
                modifier = Modifier
                    .size(72.dp)
                    .clip(CircleShape)
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                MaterialTheme.colorScheme.primary.copy(alpha = 0.3f),
                                MaterialTheme.colorScheme.secondary.copy(alpha = 0.3f)
                            )
                        )
                    ),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(resId),
                    contentDescription = product.name,
                    modifier = Modifier
                        .size(56.dp)
                        .clip(CircleShape)
                        .border(2.dp, MaterialTheme.colorScheme.primary, CircleShape)
                )
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // 📋 Product Details
                Column(
                    modifier = Modifier
                        .weight(1f),
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    //product name
                    Text(
                        text = product.name?:"unknown",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        ),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    //product price
                    Text(
                        text = nairaFormat(product.stringPrice?.toDoubleOrNull()?:0.0),
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            fontSize = 14.sp
                        )
                    )
                }
                // delete icon
                Column(
                    modifier = Modifier
                ){
                    IconButton(
                        onClick = {alert.value = true}
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Delete,
                            contentDescription = "delete button",
                            tint = MaterialTheme.colorScheme.onSurface,
                            modifier = Modifier.size(50.dp)
                        )
                    }
                }
            }


        }
    }
    if (alert.value){
        ProductDeletionDialog(
            product = product,
            productsViewModel = productsViewModel,
            alert = alert
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun DeleteProductCardPreview(){
    val vm : ProductsViewModel = viewModel()
    DeleteProductCard(
        productsViewModel = vm,
        product = brandData[0]
    )
}
