package com.guvnoh.boma.formatters

import java.text.DecimalFormat

fun nairaFormat(num: Double): String{
    val format = DecimalFormat("#,###")
    return if (num>0){"₦${format.format(num)}"}else{"₦0.00"}
}

fun nairaFormat(num: Int): String{
    val format = DecimalFormat("#,###")
    return if (num>0){"₦${format.format(num)}"}else{"₦0.00"}
}