package com.guvnoh.boma.navigation

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import com.guvnoh.boma.R

sealed class MenuIcon (){
    data class Resource(@DrawableRes val resId: Int): MenuIcon()
    data class Vector( val imageVector: ImageVector): MenuIcon()
}

open class Screen(
    val route: String,
    val title: String,
    val icon: MenuIcon? = null
) {
    data object Products : Screen(
        route = "products",
        title = "Products",
        icon = MenuIcon.Vector(Icons.Default.ShoppingCart)
    )

    data object PriceChange : Screen(
        route = "price_change",
        title = "Change Price",
        icon = MenuIcon.Resource(R.drawable.naira)
    )

    data object Receipt : Screen(route = "receipt", title = "Receipt",)
    data object AddProduct : Screen(
        route = "add_product",
        title = "Add Products",
        icon = MenuIcon.Vector(Icons.Default.AddCircle)
    )

    data object DeleteProduct : Screen(
        route = "delete_product",
        title = "Delete Products",
        icon = MenuIcon.Vector(Icons.Default.Delete)
    )

    data object Stock :
        Screen(route = "stock", title = "Stock", icon = MenuIcon.Resource(R.drawable.stock))

    data object Records :
        Screen(route = "records", title = "Records", icon = MenuIcon.Resource(R.drawable.record))

    data object RecordDetails : Screen(route = "record_details", title = "Record")


}