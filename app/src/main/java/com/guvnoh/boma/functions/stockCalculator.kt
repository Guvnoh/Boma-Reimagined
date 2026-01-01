package com.guvnoh.boma.functions

object StockCalculator {

    fun calculateClosingStock(
        opening: Double,
        received: Double,
        sold: Double
    ): Double {
        return (opening + received - sold).coerceAtLeast(0.0)
    }
}
