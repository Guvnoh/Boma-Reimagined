package com.guvnoh.boma.models

data class FullsStock(
    var openingStock: Double? = null,
    var closingStock: Double? = null,
    val depletion: Double? = null,
    val lastTimeSold: String? = null,
    val soldLast: Double? = null,
    var soldToday: Double? = null
)

data class ReceivedStock(
    val product: Product? = null,
    var quantity: Double? = null,
    var source: String? = null
)

data class ReturnedToCompany(
    val product: Product? = null,
    var quantity: Double? = null,
    var company: String? = null
)

data class ReturnedToBoma(
    val product: Product? = null,
    var quantity: Double? = null,
    var customer: String? = ""
)

data class EmptiesStock(
    var noOfBottles: NoOfBottles? = null,
    var company: EmptyCompany? = null,
    var quantity: Double? = null,
)
