package com.guvnoh.boma.uidesigns

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.guvnoh.boma.R
import com.guvnoh.boma.formatters.nairaFormat
import com.guvnoh.boma.getImage
import com.guvnoh.boma.models.BomaViewModel
import com.guvnoh.boma.models.Product
import com.guvnoh.boma.models.hero

@Composable
fun PriceChangeCard(product: Product, vm: BomaViewModel) {
    var newPrice by remember { mutableStateOf("") }
    var priceError by remember { mutableStateOf<String?>(null) }

    val context = LocalContext.current
    val resId =
        if (getImage(context, product.imageName) != 0) {
            getImage(context, product.imageName)
        } else R.drawable.bottle

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Product image
            Image(
                painter = painterResource(resId),
                contentDescription = product.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(72.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.width(16.dp))

            // Product details
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = product.name,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = nairaFormat(product.doublePrice),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 14.sp
                    )
                )
            }

            // New Price input
            OutlinedTextField(
                value = newPrice,
                onValueChange = {
                    newPrice = it.filter { ch -> ch.isDigit() || ch == '.' }
                    val parsed = newPrice.toDoubleOrNull()
                    if (parsed != null && parsed > 0.0) {
                        product.stringPrice = newPrice
                        vm.addToPriceChangeList(product, newPrice)
                        priceError = null
                    } else if (newPrice.isNotBlank()) {
                        priceError = "Invalid price"
                    }
                },
                label = { Text("New Price") },
                singleLine = true,
                isError = priceError != null,
                supportingText = {
                    if (priceError != null) {
                        Text(priceError!!, color = MaterialTheme.colorScheme.error)
                    }
                },
                modifier = Modifier.width(120.dp),
                shape = RoundedCornerShape(12.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowCard() {
    PriceChangeCard(hero[1], viewModel())
}
