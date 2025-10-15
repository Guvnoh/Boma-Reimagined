package com.guvnoh.boma.models

data class Stock(
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

data class ReturnedStock(
    val product: Product?,
    var quantity: Double? = 0.0,
    var customer: String? = ""
)
