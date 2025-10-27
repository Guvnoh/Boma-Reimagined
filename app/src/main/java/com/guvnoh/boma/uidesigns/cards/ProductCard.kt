
package com.guvnoh.boma.uidesigns.cards

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.guvnoh.boma.R
import com.guvnoh.boma.formatters.nairaFormat
import com.guvnoh.boma.functions.getImage
import com.guvnoh.boma.models.AutoScrollingText
import com.guvnoh.boma.models.BomaViewModel
import com.guvnoh.boma.models.Product
import com.guvnoh.boma.models.SoldProduct

@Composable
fun ProductCard(
    product: Product,
    viewModel: BomaViewModel
) {
    val soldProducts = viewModel.soldProducts.collectAsState()

    val soldProduct = soldProducts.value.find { it.product.name == product.name }

    var quantity = soldProduct?.stringQuantity?:""

    val total = soldProduct?.intTotal?:0

    val context = LocalContext.current
    val resId =
        if (getImage(context,product.imageName) !=0) {
            getImage(context,product.imageName)
        }else R.drawable.bottle

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 12.dp),
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

            // 📋 Product Details
            Column(
                modifier = Modifier
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
//                Text(
//                    text = product.name,
//                    style = MaterialTheme.typography.titleMedium.copy(
//                        fontWeight = FontWeight.Bold,
//                        fontSize = 18.sp
//                    ),
//                    maxLines = 1,
//                    overflow = TextOverflow.Ellipsis
//                )
                AutoScrollingText(product.name, modifier = Modifier)

                Text(
                    text = nairaFormat(product.stringPrice.toInt()),
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        fontSize = 14.sp
                    )
                )
                Column (Modifier.fillMaxWidth(), horizontalAlignment = Alignment.End){
                    // 🧮 Show Total if available
                    AnimatedVisibility(
                        visible = total > 0,
                        enter = fadeIn(),
                        exit = fadeOut()
                    ) {
                        Text(
                            text = nairaFormat(total),
                            style = MaterialTheme.typography.bodyLarge.copy(
                                fontWeight = FontWeight.SemiBold,
                                color = Color(0xFF2E7D32) // deep green
                            )
                        )
                    }
                }
            }

            // 🔢 Quantity Input
            OutlinedTextField(
                value = quantity,
                onValueChange = { newValue ->
                    val inputToDouble = newValue.toDoubleOrNull()
                    quantity = newValue

                    val newSoldProduct = SoldProduct(
                        product = product,
                        doubleQuantity = inputToDouble ?: 0.0,
                        stringQuantity = newValue
                    )
                    viewModel.recordSoldProduct(newSoldProduct)
                },
                label = { Text("Qty") },
                singleLine = true,
                modifier = Modifier
                    .width(90.dp),
                shape = RoundedCornerShape(12.dp)
            )
        }
    }
}
