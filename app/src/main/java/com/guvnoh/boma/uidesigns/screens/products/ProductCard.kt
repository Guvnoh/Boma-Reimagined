package com.guvnoh.boma.uidesigns.screens.products

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Remove
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.guvnoh.boma.formatters.nairaFormat
import com.guvnoh.boma.models.AutoScrollingText
import com.guvnoh.boma.models.Products
import com.guvnoh.boma.models.SoldProduct
import com.guvnoh.boma.repositories.ProductsRepository
import com.guvnoh.boma.ui.theme.BomaDimens
import com.guvnoh.boma.ui.theme.BomaColors
import com.guvnoh.boma.uidesigns.screens.stock.Store

@Composable
fun ProductCard(
    product: Products,
    viewModel: ProductsViewModel,
    soldProduct: SoldProduct?
) {
    val quantity = soldProduct?.stringQuantity ?: ""
    val total = soldProduct?.intTotal ?: 0
    val vmStore: Store = viewModel.selectedStore.value

    val stock = when (vmStore) {
        Store.WAREHOUSE -> product.store?.warehouse?.closingStock ?: 0.0
        Store.HEAD_OFFICE -> product.store?.headOffice?.closingStock ?: 0.0
    }

    val enabled: Boolean = stock > 0
    val hasQuantity = quantity.isNotEmpty() && (quantity.toDoubleOrNull() ?: 0.0) > 0

    val context = LocalContext.current
    val resId = ProductsRepository().getImage(
        context,
        product.imageName ?: "bottle.jpg",
        product.type!!
    )

    // Animation states
    val cardScale by animateFloatAsState(
        targetValue = if (hasQuantity) 1.02f else 1f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ),
        label = "cardScale"
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .graphicsLayer {
                scaleX = cardScale
                scaleY = cardScale
            }
            .shadow(
                elevation = if (hasQuantity) BomaDimens.elevationLg else BomaDimens.elevationSm,
                shape = RoundedCornerShape(BomaDimens.radiusLg),
                ambientColor = if (hasQuantity) MaterialTheme.colorScheme.primary.copy(alpha = 0.1f) else Color.Transparent,
                spotColor = if (hasQuantity) MaterialTheme.colorScheme.primary.copy(alpha = 0.1f) else Color.Transparent
            ),
        shape = RoundedCornerShape(BomaDimens.radiusLg),
        colors = CardDefaults.cardColors(
            containerColor = if (enabled) {
                if (hasQuantity) MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.3f)
                else MaterialTheme.colorScheme.surface
            } else {
                MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
            }
        )
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(BomaDimens.cardPadding),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(BomaDimens.spacingLg)
            ) {
                // ═══════════════════════════════════════════════════════════
                // PRODUCT IMAGE
                // ═══════════════════════════════════════════════════════════
                Box(
                    modifier = Modifier.size(BomaDimens.avatarLg),
                    contentAlignment = Alignment.Center
                ) {
                    // Gradient ring background
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(CircleShape)
                            .background(
                                brush = Brush.linearGradient(
                                    colors = if (enabled) {
                                        listOf(
                                            MaterialTheme.colorScheme.primary.copy(alpha = 0.2f),
                                            MaterialTheme.colorScheme.secondary.copy(alpha = 0.2f)
                                        )
                                    } else {
                                        listOf(
                                            MaterialTheme.colorScheme.surfaceVariant,
                                            MaterialTheme.colorScheme.surfaceVariant
                                        )
                                    }
                                )
                            )
                    )

                    // Product image
                    Image(
                        painter = painterResource(resId),
                        contentDescription = product.name,
                        modifier = Modifier
                            .size(BomaDimens.avatarMd)
                            .clip(CircleShape)
                            .border(
                                width = 2.dp,
                                color = if (enabled) MaterialTheme.colorScheme.primary
                                else MaterialTheme.colorScheme.outline,
                                shape = CircleShape
                            )
                    )
                }

                // ═══════════════════════════════════════════════════════════
                // PRODUCT DETAILS
                // ═══════════════════════════════════════════════════════════
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(BomaDimens.spacingXs)
                ) {
                    // Product Name
                    Text(
                        text = product.name ?: "Unknown",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        color = if (enabled) MaterialTheme.colorScheme.onSurface
                        else MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    // Price
                    Text(
                        text = nairaFormat(product.stringPrice?.toDouble() ?: 0.0),
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Medium,
                        color = if (enabled) MaterialTheme.colorScheme.primary
                        else MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    // Stock status
                    if (!enabled) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(BomaDimens.spacingXs),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                Icons.Default.Warning,
                                contentDescription = null,
                                modifier = Modifier.size(BomaDimens.iconXs),
                                tint = MaterialTheme.colorScheme.error
                            )
                            Text(
                                text = "Out of stock",
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.error
                            )
                        }
                    } else {
                        // Stock indicator
                        val stockText = when {
                            stock > 10 -> "In stock"
                            stock > 0 -> "Low stock (${stock.toInt()})"
                            else -> "Out of stock"
                        }
                        val stockColor = when {
                            stock > 10 -> BomaColors.success
                            stock > 0 -> BomaColors.warning
                            else -> MaterialTheme.colorScheme.error
                        }

                        Text(
                            text = stockText,
                            style = MaterialTheme.typography.labelSmall,
                            color = stockColor
                        )
                    }
                }

                // ═══════════════════════════════════════════════════════════
                // QUANTITY INPUT
                // ═══════════════════════════════════════════════════════════
                if (enabled) {
                    PremiumQuantityInput(
                        value = quantity,
                        onValueChange = { newValue ->
                            val input = newValue.toDoubleOrNull() ?: 0.0
                            viewModel.updateSoldProduct(
                                product = product,
                                stringQuantity = newValue,
                                doubleQuantity = input
                            )
                        }
                    )
                }
            }

            // ═══════════════════════════════════════════════════════════════
            // TOTAL BAR (when quantity is set)
            // ═══════════════════════════════════════════════════════════════
            AnimatedVisibility(
                visible = total > 0,
                enter = expandVertically() + fadeIn(),
                exit = shrinkVertically() + fadeOut()
            ) {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f),
                    shape = RoundedCornerShape(
                        bottomStart = BomaDimens.radiusLg,
                        bottomEnd = BomaDimens.radiusLg
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                horizontal = BomaDimens.cardPadding,
                                vertical = BomaDimens.spacingMd
                            ),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Subtotal",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        Text(
                            text = nairaFormat(total),
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = BomaColors.success
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun PremiumQuantityInput(
    value: String,
    onValueChange: (String) -> Unit
) {
    Surface(
        shape = RoundedCornerShape(BomaDimens.radiusMd),
        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
        border = androidx.compose.foundation.BorderStroke(
            width = 1.dp,
            color = if (value.isNotEmpty())
                MaterialTheme.colorScheme.primary.copy(alpha = 0.5f)
            else
                MaterialTheme.colorScheme.outline.copy(alpha = 0.3f)
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = BomaDimens.spacingXs)
        ) {
            // Decrease button
            IconButton(
                onClick = {
                    val current = value.toDoubleOrNull() ?: 0.0
                    if (current > 0) {
                        val newVal = (current - 1).coerceAtLeast(0.0)
                        onValueChange(if (newVal > 0) newVal.toInt().toString() else "")
                    }
                },
                modifier = Modifier.size(36.dp)
            ) {
                Icon(
                    Icons.Outlined.Remove,
                    contentDescription = "Decrease",
                    modifier = Modifier.size(BomaDimens.iconSm),
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            // Quantity text field
            OutlinedTextField(
                value = value,
                onValueChange = { newValue ->
                    // Only allow numbers and decimal point
                    if (newValue.isEmpty() || newValue.matches(Regex("^\\d*\\.?\\d*$"))) {
                        onValueChange(newValue)
                    }
                },
                modifier = Modifier.width(56.dp),
                textStyle = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.SemiBold,
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center
                ),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                ),
                placeholder = {
                    Text(
                        "0",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f),
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = androidx.compose.ui.text.style.TextAlign.Center
                    )
                }
            )

            // Increase button
            IconButton(
                onClick = {
                    val current = value.toDoubleOrNull() ?: 0.0
                    onValueChange((current + 1).toInt().toString())
                },
                modifier = Modifier.size(36.dp)
            ) {
                Icon(
                    Icons.Outlined.Add,
                    contentDescription = "Increase",
                    modifier = Modifier.size(BomaDimens.iconSm),
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}