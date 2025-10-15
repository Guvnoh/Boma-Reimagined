package com.guvnoh.boma.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Warning
import androidx.compose.ui.graphics.vector.ImageVector


open class Screen(
    val route: String,
    val title: String,
    val icon: ImageVector = Icons.Filled.Warning
) {
    data object Products: Screen(route = "products",title = "Products", icon = Icons.Default.ShoppingCart)
    data object PriceChange: Screen(route = "price_change",title = "Change Price",icon = Icons.Default.Edit)
    data object Receipt: Screen(route = "receipt",title = "Receipt",)
    data object AddProduct: Screen(route = "add_product",title = "Add Products",icon = Icons.Default.AddCircle)
    data object DeleteProduct: Screen(route = "delete_product",title = "Delete Products",icon = Icons.Default.Delete)
    data object Stock: Screen(route = "stock",title = "Stock",icon = Icons.Default.Info)
    data object Records: Screen(route = "records", title = "Records", icon = Icons.Filled.List)
    data object RecordDetails: Screen(route = "record_details", title = "Record")
}