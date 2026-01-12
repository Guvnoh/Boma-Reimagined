package com.guvnoh.boma.uidesigns.screens.receipt

import com.guvnoh.boma.models.SoldProduct

data class Receipt(
    var id: String? = null,
    val timeStamp: Long? = null,
    val ref: String? = null,
    var customerName: String? = "",
    var date: String? = "",
    var time: String? = "",
    var soldProducts: List<SoldProduct>? = null,
    var grandTotal: String? = null,
    var notes: String? = ""
)
