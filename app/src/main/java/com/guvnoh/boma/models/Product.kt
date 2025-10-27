package com.guvnoh.boma.models

import com.guvnoh.boma.R
import com.guvnoh.boma.formatters.halfAndQuarter
import com.guvnoh.boma.uidesigns.screens.BottomBarItem

open class Product (
    open var name: String = "",
    open var stringPrice: String = "",
    open var imageName: String = "",
    open var image: Int = R.drawable.bottle,
    open val id: String = "",
    open var doublePrice: Double = stringPrice.toDoubleOrNull()?:0.0,
    open val type: ProductType = ProductType.BOTTLE

)
data class BottleProduct(
    override var name: String = "",
    override var stringPrice: String = "",
    override var imageName: String = "",
    override var image: Int = R.drawable.bottle,
    override var id: String = "",
    override var doublePrice: Double = stringPrice.toDoubleOrNull()?:0.0,
    override var type: ProductType = ProductType.BOTTLE,

    var empties: Empties = Empties()


): Product()

data class PetsAndCans(
    override var name: String = "",
    override var stringPrice: String = "",
    override var imageName: String = "",
    override var image: Int = R.drawable.bottle,
    override var id: String = "",
    override var doublePrice: Double = stringPrice.toDoubleOrNull()?:0.0,
    override var type: ProductType = ProductType.PET
):Product()

enum class ProductType(){
    BOTTLE,
    PET,
    CAN
}

data class SoldProduct(
    var product: Product = BottleProduct(
        name = "",
        stringPrice = "",
        imageName = "",
        image = 0,
        id = "",
        doublePrice = 0.0,
        type = ProductType.BOTTLE
    ),
    var stringQuantity: String = "",
    var doubleQuantity: Double = 0.0,
    var receiptQuantity: String = halfAndQuarter(doubleQuantity),
    var intTotal: Int = 0
) {
    var doubleTotal: Double = product.doublePrice * doubleQuantity
}

data class Receipt(
    var id: String = "",
    var soldProducts: List<SoldProduct> = emptyList(),
    var customerName: String = "",
    var date: String = "",
    var grandTotal: String = ""
)

//fun getBottleProducts(): List<BottleProduct>{
//    val list: List<BottleProduct> = mutableListOf()
//    list.toMutableList().addAll(cocacolaBottles)
//    list.toMutableList().addAll(hero)
//    list.toMutableList().addAll(nbl)
//    list.toMutableList().addAll(guinness)
//
//    return list
//}

//fun getPetsAndCans(): List<PetsAndCans>{
//    val list: List<PetsAndCans> = mutableListOf()
//    list.toMutableList().addAll(cans)
//    list.toMutableList().addAll(pets)
//    return list
//}

val brandData = mutableListOf(
    //coca cola
    BottleProduct(name = "50cl", stringPrice = "6300", imageName = "coke", empties = Empties(company = EmptyCompany.COCA_COLA, noOfBottles = NoOfBottles.TWENTY_FOUR)),
    BottleProduct(name = "35cl", stringPrice = "3800", imageName = "coke", empties = Empties(company = EmptyCompany.COCA_COLA, noOfBottles = NoOfBottles.TWENTY_FOUR)),

    //Hero
    BottleProduct(name = "Hero", stringPrice = "8500", imageName = "hero", empties = Empties(company = EmptyCompany.HERO, noOfBottles = NoOfBottles.TWELVE)),
    BottleProduct(name = "Budweiser", stringPrice = "10000", imageName = "budweiser", empties = Empties(company = EmptyCompany.HERO, noOfBottles = NoOfBottles.TWELVE)),
    BottleProduct(name = "Castle Lite", stringPrice = "9500", imageName = "castle_lite", empties = Empties(company = EmptyCompany.HERO, noOfBottles = NoOfBottles.TWELVE)),
    BottleProduct(name = "Flying fish", stringPrice = "13000", imageName = "fish", empties = Empties(company = EmptyCompany.HERO, noOfBottles = NoOfBottles.TWENTY)),
    BottleProduct(name = "Trophy", stringPrice = "8500", imageName = "trophy", empties = Empties(company = EmptyCompany.HERO, noOfBottles = NoOfBottles.TWELVE)),
    BottleProduct(name = "Trophy Stout", stringPrice = "9500", imageName = "trophy_stout", empties = Empties(company = EmptyCompany.HERO, noOfBottles = NoOfBottles.TWELVE)),

    //NBL
    BottleProduct(name = "Amstel", stringPrice =  "13000", imageName = "amstel", empties = Empties(company = EmptyCompany.NBL, noOfBottles = NoOfBottles.TWENTY_FOUR)),
    BottleProduct(name = "Desperados", stringPrice = "16600", imageName = "despy", empties = Empties(company = EmptyCompany.NBL, noOfBottles = NoOfBottles.TWENTY)),
    BottleProduct(name = "Gulder", stringPrice = "10800", imageName = "gulder", empties = Empties(company = EmptyCompany.NBL, noOfBottles = NoOfBottles.TWELVE)),
    BottleProduct(name = "Heineken", stringPrice = "11900", imageName = "heineken", empties = Empties(company = EmptyCompany.NBL, noOfBottles = NoOfBottles.TWELVE)),
    BottleProduct(name = "Legend(big)", stringPrice = "11200", imageName = "legend", empties = Empties(company = EmptyCompany.NBL, noOfBottles = NoOfBottles.TWELVE)),
    BottleProduct(name = "Life", stringPrice = "9200", imageName = "life", empties = Empties(company = EmptyCompany.NBL, noOfBottles = NoOfBottles.TWELVE)),
    BottleProduct(name = "Maltina", stringPrice = "13000", imageName = "maltina", empties = Empties(company = EmptyCompany.NBL, noOfBottles = NoOfBottles.TWENTY_FOUR)),
    BottleProduct(name = "Radler", stringPrice = "13000", imageName = "radler", empties = Empties(company = EmptyCompany.NBL, noOfBottles = NoOfBottles.TWENTY)),
    BottleProduct(name = "Star", stringPrice = "10500", imageName = "star", empties = Empties(company = EmptyCompany.NBL, noOfBottles = NoOfBottles.TWELVE)),
    BottleProduct(name = "Tiger", stringPrice = "15000", imageName = "tiger", empties = Empties(company = EmptyCompany.NBL, noOfBottles = NoOfBottles.TWENTY)),
    BottleProduct(name = "Medium Heineken", stringPrice = "17000", empties = Empties(company = EmptyCompany.NBL, noOfBottles = NoOfBottles.TWENTY)),

    //Guinness
    BottleProduct(name = "Medium stout", stringPrice = "17000", imageName = "guinness", empties = Empties(company = EmptyCompany.GUINNESS, noOfBottles = NoOfBottles.EIGHTEEN)),
    BottleProduct(name = "Small stout", stringPrice = "19000", imageName = "guinness", empties = Empties(company = EmptyCompany.GUINNESS, noOfBottles = NoOfBottles.TWENTY_FOUR)),
    BottleProduct(name = "Orijin", stringPrice = "9500", imageName = "orijin", empties = Empties(company = EmptyCompany.GUINNESS, noOfBottles = NoOfBottles.TWELVE)),

    //Cans
    PetsAndCans(name = "Beta Malt", stringPrice = "10500", imageName = "beta_malt", type = ProductType.CAN),
    PetsAndCans(name = "Grand Malt", stringPrice = "10700", imageName = "grand_malt", type = ProductType.CAN),
    PetsAndCans(name = "Amstel can", stringPrice = "12500", imageName = "amstel", type = ProductType.CAN),
    PetsAndCans(name = "Life can", stringPrice = "15000", imageName = "life", type = ProductType.CAN),
    PetsAndCans(name = "Star can", stringPrice = "12000", imageName = "star", type = ProductType.CAN),
    PetsAndCans(name = "Hero can", stringPrice = "10500", imageName = "hero", type = ProductType.CAN),
    PetsAndCans(name = "Trophy can", stringPrice = "10500", imageName = "trophy", type = ProductType.CAN),
    PetsAndCans(name = "Heineken can", stringPrice = "15500", imageName = "heineken", type = ProductType.CAN),
    PetsAndCans(name = "Guinness can", stringPrice = "25000", imageName = "guinness", type = ProductType.CAN),

    //Pets
    PetsAndCans(name = "Bigger boy", stringPrice = "4600", imageName = "coke", type = ProductType.PET),
    PetsAndCans(name = "Predator", stringPrice = "5400", imageName = "predator", type = ProductType.PET),
    PetsAndCans(name = "Fearless", stringPrice = "5000", imageName = "fearless", type = ProductType.PET),
    PetsAndCans(name = "Eva water (Big)", stringPrice =  "3900", imageName = "eva", type = ProductType.PET),
    PetsAndCans(name = "Eva water (75cl)", stringPrice = "2900", imageName = "eva", type = ProductType.PET),
    PetsAndCans(name = "Rex water (75cl)", stringPrice = "2900", type = ProductType.PET),
    PetsAndCans(name = "zenee water", stringPrice = "1700", type = ProductType.PET),
    PetsAndCans(name = "Aquafina", stringPrice = "2400", imageName = "aquafina", type = ProductType.PET),
    PetsAndCans(name = "Nutri Milk", stringPrice = "6400", imageName = "nutri_milk", type = ProductType.PET),
    PetsAndCans(name = "Nutri Choco", stringPrice = "7000", imageName = "nutri_choco", type = ProductType.PET),
    PetsAndCans(name = "Nutri Yo", stringPrice = "7000", imageName = "nutri_yo", type = ProductType.PET),
    PetsAndCans(name = "Pop cola (big)", stringPrice = "3600", imageName = "pop_cola", type = ProductType.PET),
    PetsAndCans(name = "Pop cola (small)", stringPrice = "2600", imageName = "pop_cola", type = ProductType.PET),
    PetsAndCans(name = "Pepsi", stringPrice = "4500", imageName = "pepsi", type = ProductType.PET),
)
