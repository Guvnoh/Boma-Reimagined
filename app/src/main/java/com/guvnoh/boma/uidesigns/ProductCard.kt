package com.guvnoh.boma.uidesigns

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.guvnoh.boma.formatters.nairaFormat
import com.guvnoh.boma.models.BomaViewModel
import com.guvnoh.boma.models.Product
import com.guvnoh.boma.models.productList
import androidx.compose.runtime.collectAsState
import com.guvnoh.boma.models.SoldProduct

@Composable
fun ProductCard(product: Product, viewModel: BomaViewModel) {

    val soldProducts = viewModel.soldProducts.collectAsState()

    val soldProduct = soldProducts.value.find { it.product.name == product.name }?:SoldProduct(product)

    val quantity = soldProduct.stringQuantity

    val total = soldProduct.intTotal?:0

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Product image
            Image(
                painter = painterResource(product.image),
                contentDescription = product.name,
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
            )

            // Product details
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 12.dp, end = 8.dp)
            ) {
                Text(
                    text = product.name,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = nairaFormat(product.intPrice),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 14.sp
                    )
                )

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.End
                ) {
                    if (total>0) {
                        Text(
                            text = nairaFormat( total),
                            style = MaterialTheme.typography.bodyLarge.copy(
                                fontWeight = FontWeight.Medium
                            )
                        )
                    }
                }
            }
//            OutlinedTextField(
//                value = quantity,
//                onValueChange = {
//                    quantity = it
//                    if (total > 0){
//                        viewModel.addTotal(product.name, total.toInt())
//                    }else{
//                        viewModel.removeTotal(product.name)
//                    }
//                                },
//                label = { Text("Qty") },
//                singleLine = true,
//                modifier = Modifier.width(90.dp)
//            )
            OutlinedTextField(
                value = quantity,
                onValueChange = { newValue ->
                    val qty = newValue.toIntOrNull() ?: 0

                    val newSoldProduct = SoldProduct(product,qty.toString(),qty)
                    if (qty > 0) {
                        viewModel.addProduct( soldProduct = newSoldProduct)
                    } else {
                        viewModel.removeProduct( newSoldProduct )
                    }


                },
                label = { Text("Qty") },
                singleLine = true,
                modifier = Modifier.width(90.dp)
            )


        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowCard2() {
    ProductCard(product = productList[2], viewModel())
}

