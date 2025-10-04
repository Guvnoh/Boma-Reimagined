package com.guvnoh.boma.navigation


open class Screen(
    val route: String
) {
    data object Products: Screen(route = "products")
    data object PriceChange: Screen(route = "price_change")
    data object Receipt: Screen(route = "receipt")
    data object AddProduct: Screen(route = "add_product")
    data object DeleteProduct: Screen(route = "delete_product")
}