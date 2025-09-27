package com.guvnoh.boma.navigation

import android.graphics.drawable.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

open class MenuItems(
    val route: String,
    val icon: ImageVector
) {
    data object Products: MenuItems(route = "products", icon = Icons.Filled.ShoppingCart)
    data object PriceChange: MenuItems(route = "priceChange", icon = Icons.Filled.Edit)
}