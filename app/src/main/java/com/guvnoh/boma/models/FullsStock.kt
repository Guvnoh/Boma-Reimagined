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

data class Return(
    val product: Product? = null,
    var quantity: Double? = null,
    var type: ReturnType? = null
)
enum class ReturnType{
    COMPANY,
    CUSTOMER
}


data class EmptiesStock(
    var emptyType: EmptyType? = null,
    var company: EmptyCompany? = null,
    var quantity: Double? = null,
)
