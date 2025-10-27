package com.guvnoh.boma.models

data class FullsStock(
    val product: Product? = null,
    val openingStock: Double? = null,
    val closingStock: Double? = null,
    val depletion: Double? = null,
)

data class ReceivedStock(
    val product: Product?,
    var quantity: Double? = 0.0,
    var source: String? = ""
)

data class ReturnedToCompany(
    val product: Product?,
    var quantity: Double? = 0.0,
    var company: String? = ""
)

data class ReturnedToBoma(
    val product: Product?,
    var quantity: Double? = 0.0,
    var customer: String? = ""
)

data class EmptiesStock(
    var noOfBottles: NoOfBottles = NoOfBottles.TWELVE,
    var company: EmptyCompany = EmptyCompany.NBL,
    var quantity: Double? = 0.0,
)
