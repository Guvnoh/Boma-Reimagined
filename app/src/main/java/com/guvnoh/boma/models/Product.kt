package com.guvnoh.boma.models

import com.guvnoh.boma.R

data class Product(
    val id: String = "",
    val name: String = "",
    var stringPrice: String = "",
    var intPrice: Int = stringPrice.toIntOrNull()?:0,
    val image: Int = R.drawable.bottle

)
data class SoldProduct(
    val product: Product = Product(),
    var stringQuantity: String = "",
    var intQuantity: Int = 0,
) {
    val intTotal: Int get() = product.intPrice * intQuantity

    val stringTotal: String get() = intTotal.toString()
}

val productList = mutableListOf(
    Product(name = "Hero", stringPrice = "8500", image = R.drawable.hero),
    Product(name = "Coca-cola", stringPrice = "6300", image = R.drawable.coke),
    Product(name = "Budweiser", stringPrice = "10400", image = R.drawable.budweiser),
    Product(name = "Castle Lite", stringPrice = "8500"),
    Product(name = "Flying fish", stringPrice = "13000", image = R.drawable.fish),
    Product(name = "Hero", stringPrice = "9000", image = R.drawable.hero),
    Product(name = "Trophy", stringPrice = "9000", image =  R.drawable.trophy),
    Product(name = "Trophy Stout", stringPrice = "8500"),
)


