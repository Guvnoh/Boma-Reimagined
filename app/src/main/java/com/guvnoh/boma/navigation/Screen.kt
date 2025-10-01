package com.guvnoh.boma.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

open class Screen(
    val route: String
) {
    data object Products: Screen(route = "products")
    data object PriceChange: Screen(route = "priceChange")
    data object Receipt: Screen(route = "receipt")
}