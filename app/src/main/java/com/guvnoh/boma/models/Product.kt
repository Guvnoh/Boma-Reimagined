package com.guvnoh.boma.models

import com.guvnoh.boma.R

data class Products (
    var name: String? = null,
    var stringPrice: String? = null,
    var imageName: String? = null,
    var image: Int = R.drawable.bottle,
    var id: String? = null,//the id is the same as the database key
    var doublePrice: Double? = null,
    var store: Store? = null, //warehouse or head office
    var type: ProductType? = null, //bottle, can or pet
    var empties: Empties? = null

)

enum class ProductType(){
    BOTTLE,
    PET,
    CAN
}

data class SoldProduct(
    var product: Products? = null,
    var stringQuantity: String? = null,
    var doubleQuantity: Double? = null,
    var receiptQuantity: String? = null,
    var intTotal: Int? = null,
)


val brandData = mutableListOf(
    //coca cola
    Products(name = "50cl", stringPrice = "6300", imageName = "coke", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.COCA_COLA, emptyType = EmptyType.TWENTY_FOUR)),
    Products(name = "35cl", stringPrice = "3800", imageName = "coke", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.COCA_COLA, emptyType = EmptyType.TWENTY_FOUR)),

    //Hero
    Products(name = "Hero", stringPrice = "8500", imageName = "hero", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.HERO, emptyType = EmptyType.TWELVE)),
    Products(name = "Budweiser", stringPrice = "10000", imageName = "budweiser", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.HERO, emptyType = EmptyType.TWELVE)),
    Products(name = "Castle Lite", stringPrice = "9500", imageName = "castle_lite", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.HERO, emptyType = EmptyType.TWELVE)),
    Products(name = "Flying fish", stringPrice = "13000", imageName = "fish", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.HERO, emptyType = EmptyType.TWENTY)),
    Products(name = "Trophy", stringPrice = "8500", imageName = "trophy", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.HERO, emptyType = EmptyType.TWELVE)),
    Products(name = "Trophy Stout", stringPrice = "9500", imageName = "trophy_stout", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.HERO, emptyType = EmptyType.TWELVE)),

    //NBL
    Products(name = "Amstel", stringPrice =  "13000", imageName = "amstel", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.NBL, emptyType = EmptyType.TWENTY_FOUR)),
    Products(name = "Desperados", stringPrice = "16600", imageName = "despy", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.NBL, emptyType = EmptyType.TWENTY)),
    Products(name = "Gulder", stringPrice = "10800", imageName = "gulder", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.NBL, emptyType = EmptyType.TWELVE)),
    Products(name = "Heineken", stringPrice = "11900", imageName = "heineken", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.NBL, emptyType = EmptyType.TWELVE)),
    Products(name = "Legend(big)", stringPrice = "11200", imageName = "legend", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.NBL, emptyType = EmptyType.TWELVE)),
    Products(name = "Life", stringPrice = "9200", imageName = "life", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.NBL, emptyType = EmptyType.TWELVE)),
    Products(name = "Maltina", stringPrice = "13000", imageName = "maltina", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.NBL, emptyType = EmptyType.TWENTY_FOUR)),
    Products(name = "Radler", stringPrice = "13000", imageName = "radler", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.NBL, emptyType = EmptyType.TWENTY)),
    Products(name = "Star", stringPrice = "10500", imageName = "star", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.NBL, emptyType = EmptyType.TWELVE)),
    Products(name = "Tiger", stringPrice = "15000", imageName = "tiger", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.NBL, emptyType = EmptyType.TWENTY)),
    Products(name = "Medium Heineken", stringPrice = "17000", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.NBL, emptyType = EmptyType.TWENTY)),

    //Guinness
    Products(name = "Medium stout", stringPrice = "17000", imageName = "guinness", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.GUINNESS, emptyType = EmptyType.EIGHTEEN)),
    Products(name = "Small stout", stringPrice = "19000", imageName = "guinness", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.GUINNESS, emptyType = EmptyType.TWENTY_FOUR)),
    Products(name = "Orijin", stringPrice = "9500", imageName = "orijin", type = ProductType.BOTTLE,empties = Empties(company = EmptyCompany.GUINNESS, emptyType = EmptyType.TWELVE)),

    //Cans
    Products(name = "Beta Malt", stringPrice = "10500", imageName = "beta_malt", type = ProductType.CAN),
    Products(name = "Grand Malt", stringPrice = "10700", imageName = "grand_malt", type = ProductType.CAN),
    Products(name = "Amstel can", stringPrice = "12500", imageName = "amstel", type = ProductType.CAN),
    Products(name = "Life can", stringPrice = "15000", imageName = "life", type = ProductType.CAN),
    Products(name = "Star can", stringPrice = "12000", imageName = "star", type = ProductType.CAN),
    Products(name = "Hero can", stringPrice = "10500", imageName = "hero", type = ProductType.CAN),
    Products(name = "Trophy can", stringPrice = "10500", imageName = "trophy", type = ProductType.CAN),
    Products(name = "Heineken can", stringPrice = "15500", imageName = "heineken", type = ProductType.CAN),
    Products(name = "Guinness can", stringPrice = "25000", imageName = "guinness", type = ProductType.CAN),

    //Pets
    Products(name = "Bigger boy", stringPrice = "4600", imageName = "coke", type = ProductType.PET),
    Products(name = "Predator", stringPrice = "5400", imageName = "predator", type = ProductType.PET),
    Products(name = "Fearless", stringPrice = "5000", imageName = "fearless", type = ProductType.PET),
    Products(name = "Eva water (Big)", stringPrice =  "3900", imageName = "eva", type = ProductType.PET),
    Products(name = "Eva water (75cl)", stringPrice = "2900", imageName = "eva", type = ProductType.PET),
    Products(name = "Rex water (75cl)", stringPrice = "2900", type = ProductType.PET),
    Products(name = "zenee water", stringPrice = "1700", type = ProductType.PET),
    Products(name = "Aquafina", stringPrice = "2400", imageName = "aquafina", type = ProductType.PET),
    Products(name = "Nutri Milk", stringPrice = "6400", imageName = "nutri_milk", type = ProductType.PET),
    Products(name = "Nutri Choco", stringPrice = "7000", imageName = "nutri_choco", type = ProductType.PET),
    Products(name = "Nutri Yo", stringPrice = "7000", imageName = "nutri_yo", type = ProductType.PET),
    Products(name = "Pop cola (big)", stringPrice = "3600", imageName = "pop_cola", type = ProductType.PET),
    Products(name = "Pop cola (small)", stringPrice = "2600", imageName = "pop_cola", type = ProductType.PET),
    Products(name = "Pepsi", stringPrice = "4500", imageName = "pepsi", type = ProductType.PET),
)
