package com.guvnoh.boma.models

import com.guvnoh.boma.R
import com.guvnoh.boma.formatters.halfAndQuarter
import kotlin.time.times

data class Product(


    val name: String = "",
    var stringPrice: String = "",
    var imageName: String = "",
    var image: Int = R.drawable.bottle,
    val id: String = "",
    val doublePrice: Double = stringPrice.toDoubleOrNull()?:0.0,
    val sortCategory: SortCategory = SortCategory.OTHER

)

data class SoldProduct(
    val product: Product = Product(),
    var stringQuantity: String = "",
    var doubleQuantity: Double = 0.0,
    val receiptQuantity: String = halfAndQuarter(doubleQuantity)
) {
    private val doubleTotal: Double = product.doublePrice * doubleQuantity
    val intTotal: Int get() = doubleTotal.toInt()?:0
}

data class Receipt(
    val id: String = "",
    val products: List<SoldProduct>,
    val customerName: String = "",
    val date: String = ""
)

enum class SortCategory {
    COCACOLA,
    HERO,
    NBL,
    GUINNESS,
    PETS,
    CANS,
    OTHER
}
fun getSortedBrandData(list: MutableList<Product>): List<Product>{
    val sortedBrandList = list.sortedBy { it.sortCategory }
    return sortedBrandList
}
val cocacolaBottles = mutableListOf(
    //coca cola
    Product(name = "50cl", stringPrice = "6300", imageName = "coke", sortCategory = SortCategory.COCACOLA),
    Product(name = "35cl", stringPrice = "3800", imageName = "coke", sortCategory = SortCategory.COCACOLA),
)

val hero = mutableListOf(
    //international breweries

    Product(name = "Hero", stringPrice = "8500", imageName = "hero", sortCategory = SortCategory.HERO),
    Product(name = "Budweiser", stringPrice = "10400", imageName = "budweiser", sortCategory = SortCategory.HERO),
    Product(name = "Castle Lite", stringPrice = "8500", imageName = "castle_lite", sortCategory = SortCategory.HERO),
    Product(name = "Flying fish", stringPrice = "13000", imageName = "fish", sortCategory = SortCategory.HERO),
    Product(name = "Trophy", stringPrice = "9000", imageName = "trophy", sortCategory = SortCategory.HERO),
    Product(name = "Trophy Stout", stringPrice = "8500", imageName = "trophy_stout", sortCategory = SortCategory.HERO),
)

val nbl = mutableListOf(
    //NBL
    Product(name = "Amstel", stringPrice =  "13500", imageName = "amstel", sortCategory = SortCategory.NBL),
    Product(name = "Desperados", stringPrice = "16600", imageName = "despy", sortCategory = SortCategory.NBL),
    Product(name = "Gulder", stringPrice = "10800", imageName = "gulder", sortCategory = SortCategory.NBL),
    Product(name = "Heineken", stringPrice = "11900", imageName = "heineken", sortCategory = SortCategory.NBL),
    Product(name = "Legend(big)", stringPrice = "11200", imageName = "legend", sortCategory = SortCategory.NBL),
    Product(name = "Life", stringPrice = "9200", imageName = "life", sortCategory = SortCategory.NBL),
    Product(name = "Maltina", stringPrice = "13000", imageName = "maltina", sortCategory = SortCategory.NBL),
    Product(name = "Radler", stringPrice = "13000", imageName = "radler", sortCategory = SortCategory.NBL),
    Product(name = "Star", stringPrice = "10500", imageName = "star", sortCategory = SortCategory.NBL),
    Product(name = "Tiger", stringPrice = "15000", imageName = "tiger", sortCategory = SortCategory.NBL),
    Product(name = "Medium Heineken", stringPrice = "17000", sortCategory = SortCategory.NBL)
)

val guinness = mutableListOf(
    //Guinness
    Product(name = "Medium stout", stringPrice = "17500", imageName = "guinness", sortCategory = SortCategory.GUINNESS),
    Product(name = "Small stout", stringPrice = "19000", imageName = "guinness", sortCategory = SortCategory.GUINNESS),
    Product(name = "Orijin", stringPrice = "9500", imageName = "orijin", sortCategory = SortCategory.GUINNESS)
)
val cans = mutableListOf(
    Product(name = "Beta Malt", stringPrice = "10700", imageName = "beta_malt", sortCategory = SortCategory.CANS),
    Product(name = "Grand Malt", stringPrice = "10700", imageName = "grand_malt", sortCategory = SortCategory.CANS),
    Product(name = "Amstel can", stringPrice = "13000", imageName = "amstel", sortCategory = SortCategory.CANS),
    Product(name = "Life can", stringPrice = "15000", imageName = "life", sortCategory = SortCategory.CANS),
    Product(name = "Star can", stringPrice = "12000", imageName = "star", sortCategory = SortCategory.CANS),
    Product(name = "Hero can", stringPrice = "10500", imageName = "hero", sortCategory = SortCategory.CANS),
    Product(name = "Trophy can", stringPrice = "10500", imageName = "trophy", sortCategory = SortCategory.CANS),
    Product(name = "Heineken can", stringPrice = "15500", imageName = "heineken", sortCategory = SortCategory.CANS),
    Product(name = "Guinness can", stringPrice = "25000", imageName = "guinness", sortCategory = SortCategory.CANS),

    )
val pets = mutableListOf(
    //Pets
    Product(name = "Bigger boy", stringPrice = "4600", imageName = "coke", sortCategory = SortCategory.PETS),
    Product(name = "Predator", stringPrice = "5400", imageName = "predator", sortCategory = SortCategory.PETS),
    Product(name = "Fearless", stringPrice = "5000", imageName = "fearless", sortCategory = SortCategory.PETS ),
    Product(name = "Eva water (Big)", stringPrice =  "3900", imageName = "eva", sortCategory = SortCategory.PETS),
    Product(name = "Eva water (75cl)", stringPrice = "2900", imageName = "eva", sortCategory = SortCategory.PETS),
    Product(name = "Rex water (75cl)", stringPrice = "2900", sortCategory = SortCategory.PETS),
    Product(name = "zenee water", stringPrice = "1700", sortCategory = SortCategory.PETS),
    Product(name = "Aquafina", stringPrice = "2400", imageName = "aquafina", sortCategory = SortCategory.PETS),
    Product(name = "Nutri Milk", stringPrice = "6400", imageName = "nutri_milk", sortCategory = SortCategory.PETS),
    Product(name = "Nutri Choco", stringPrice = "7000", imageName = "nutri_choco", sortCategory = SortCategory.PETS),
    Product(name = "Nutri Yo", stringPrice = "7000", imageName = "nutri_yo", sortCategory = SortCategory.PETS),
    Product(name = "Pop cola (big)", stringPrice = "3600", imageName = "pop_cola", sortCategory = SortCategory.PETS),
    Product(name = "Pop cola (small)", stringPrice = "2600", imageName = "pop_cola", sortCategory = SortCategory.PETS),
    Product(name = "Pepsi", stringPrice = "4500", imageName = "pepsi", sortCategory = SortCategory.PETS),
)


