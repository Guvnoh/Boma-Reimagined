package com.guvnoh.boma.models

import com.google.firebase.database.ServerValue
import com.guvnoh.boma.R

data class Product (
     var name: String? = null,
     var stringPrice: String? = null,
     var imageName: String? = null,
     var image: Int = R.drawable.bottle,
     val id: String? = null,
     var doublePrice: Double? = null ,
     var stock: FullsStock? = null,
     val type: ProductType? = null,
     var empties: Empties? = null

)

enum class ProductType(){
    BOTTLE,
    PET,
    CAN
}

data class SoldProduct(
    var product: Product? = null,
    var stringQuantity: String? = null,
    var doubleQuantity: Double? = null,
    var receiptQuantity: String? = null,
    var intTotal: Int? = null
)

data class Receipt(
    val timeStamp: Long? = null,
    var id: String? = null,
    var soldProducts: List<SoldProduct>? = null,
    var customerName: String? = null,
    var date: String? = null,
    var grandTotal: String? = null
)

val brandData = mutableListOf(
    //coca cola
    Product(name = "50cl", stringPrice = "6300", imageName = "coke", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.COCA_COLA, emptyType = EmptyType.TWENTY_FOUR)),
    Product(name = "35cl", stringPrice = "3800", imageName = "coke", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.COCA_COLA, emptyType = EmptyType.TWENTY_FOUR)),

    //Hero
    Product(name = "Hero", stringPrice = "8500", imageName = "hero", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.HERO, emptyType = EmptyType.TWELVE)),
    Product(name = "Budweiser", stringPrice = "10000", imageName = "budweiser", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.HERO, emptyType = EmptyType.TWELVE)),
    Product(name = "Castle Lite", stringPrice = "9500", imageName = "castle_lite", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.HERO, emptyType = EmptyType.TWELVE)),
    Product(name = "Flying fish", stringPrice = "13000", imageName = "fish", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.HERO, emptyType = EmptyType.TWENTY)),
    Product(name = "Trophy", stringPrice = "8500", imageName = "trophy", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.HERO, emptyType = EmptyType.TWELVE)),
    Product(name = "Trophy Stout", stringPrice = "9500", imageName = "trophy_stout", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.HERO, emptyType = EmptyType.TWELVE)),

    //NBL
    Product(name = "Amstel", stringPrice =  "13000", imageName = "amstel", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.NBL, emptyType = EmptyType.TWENTY_FOUR)),
    Product(name = "Desperados", stringPrice = "16600", imageName = "despy", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.NBL, emptyType = EmptyType.TWENTY)),
    Product(name = "Gulder", stringPrice = "10800", imageName = "gulder", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.NBL, emptyType = EmptyType.TWELVE)),
    Product(name = "Heineken", stringPrice = "11900", imageName = "heineken", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.NBL, emptyType = EmptyType.TWELVE)),
    Product(name = "Legend(big)", stringPrice = "11200", imageName = "legend", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.NBL, emptyType = EmptyType.TWELVE)),
    Product(name = "Life", stringPrice = "9200", imageName = "life", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.NBL, emptyType = EmptyType.TWELVE)),
    Product(name = "Maltina", stringPrice = "13000", imageName = "maltina", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.NBL, emptyType = EmptyType.TWENTY_FOUR)),
    Product(name = "Radler", stringPrice = "13000", imageName = "radler", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.NBL, emptyType = EmptyType.TWENTY)),
    Product(name = "Star", stringPrice = "10500", imageName = "star", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.NBL, emptyType = EmptyType.TWELVE)),
    Product(name = "Tiger", stringPrice = "15000", imageName = "tiger", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.NBL, emptyType = EmptyType.TWENTY)),
    Product(name = "Medium Heineken", stringPrice = "17000", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.NBL, emptyType = EmptyType.TWENTY)),

    //Guinness
    Product(name = "Medium stout", stringPrice = "17000", imageName = "guinness", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.GUINNESS, emptyType = EmptyType.EIGHTEEN)),
    Product(name = "Small stout", stringPrice = "19000", imageName = "guinness", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.GUINNESS, emptyType = EmptyType.TWENTY_FOUR)),
    Product(name = "Orijin", stringPrice = "9500", imageName = "orijin", type = ProductType.BOTTLE,empties = Empties(company = EmptyCompany.GUINNESS, emptyType = EmptyType.TWELVE)),

    //Cans
    Product(name = "Beta Malt", stringPrice = "10500", imageName = "beta_malt", type = ProductType.CAN),
    Product(name = "Grand Malt", stringPrice = "10700", imageName = "grand_malt", type = ProductType.CAN),
    Product(name = "Amstel can", stringPrice = "12500", imageName = "amstel", type = ProductType.CAN),
    Product(name = "Life can", stringPrice = "15000", imageName = "life", type = ProductType.CAN),
    Product(name = "Star can", stringPrice = "12000", imageName = "star", type = ProductType.CAN),
    Product(name = "Hero can", stringPrice = "10500", imageName = "hero", type = ProductType.CAN),
    Product(name = "Trophy can", stringPrice = "10500", imageName = "trophy", type = ProductType.CAN),
    Product(name = "Heineken can", stringPrice = "15500", imageName = "heineken", type = ProductType.CAN),
    Product(name = "Guinness can", stringPrice = "25000", imageName = "guinness", type = ProductType.CAN),

    //Pets
    Product(name = "Bigger boy", stringPrice = "4600", imageName = "coke", type = ProductType.PET),
    Product(name = "Predator", stringPrice = "5400", imageName = "predator", type = ProductType.PET),
    Product(name = "Fearless", stringPrice = "5000", imageName = "fearless", type = ProductType.PET),
    Product(name = "Eva water (Big)", stringPrice =  "3900", imageName = "eva", type = ProductType.PET),
    Product(name = "Eva water (75cl)", stringPrice = "2900", imageName = "eva", type = ProductType.PET),
    Product(name = "Rex water (75cl)", stringPrice = "2900", type = ProductType.PET),
    Product(name = "zenee water", stringPrice = "1700", type = ProductType.PET),
    Product(name = "Aquafina", stringPrice = "2400", imageName = "aquafina", type = ProductType.PET),
    Product(name = "Nutri Milk", stringPrice = "6400", imageName = "nutri_milk", type = ProductType.PET),
    Product(name = "Nutri Choco", stringPrice = "7000", imageName = "nutri_choco", type = ProductType.PET),
    Product(name = "Nutri Yo", stringPrice = "7000", imageName = "nutri_yo", type = ProductType.PET),
    Product(name = "Pop cola (big)", stringPrice = "3600", imageName = "pop_cola", type = ProductType.PET),
    Product(name = "Pop cola (small)", stringPrice = "2600", imageName = "pop_cola", type = ProductType.PET),
    Product(name = "Pepsi", stringPrice = "4500", imageName = "pepsi", type = ProductType.PET),
)
