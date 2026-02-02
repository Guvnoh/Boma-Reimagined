package com.guvnoh.boma.formatters

import java.text.DecimalFormat

fun nairaFormat(num: Double): String {
    val hasDecimal = num % 1 != 0.0
    val absValue = kotlin.math.abs(num)

    val format = if (hasDecimal) {
        DecimalFormat("#,##0.00")
    } else {
        DecimalFormat("#,###")
    }

    val formatted = format.format(absValue)

    return if (num < 0) {
        "-₦$formatted"
    } else {
        "₦$formatted"
    }
}

fun nairaFormat(num: Int): String {
    val format = DecimalFormat("#,###")
    val absValue = kotlin.math.abs(num)

    return if (num < 0) {
        "-₦${format.format(absValue)}"
    } else {
        "₦${format.format(absValue)}"
    }
}



//fun nairaFormat(num: Int): String{
//    val format = DecimalFormat("#,###")
//    return if (num>0){"₦${format.format(num)}"}else{"₦0.00"}
//}