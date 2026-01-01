package com.guvnoh.boma.models

import com.guvnoh.boma.formatters.getDate

data class FullsStock(
    var openingStock: Double? = null,
    var closingStock: Double? = null,
    val depletion: Double? = null,
    var lastTimeSold: String? = null,
    var soldLast: Double? = null,
    var soldToday: Double? = null,
    var receivedStock: ReceivedStock? = null
)

data class ReceivedStock(
    val date: String? = null,
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
