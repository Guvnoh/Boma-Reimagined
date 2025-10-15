package com.guvnoh.boma.formatters

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
fun getDateTime(): String{
    //Time format
    val watZoneId: ZoneId = ZoneId.of("Africa/Lagos")
    val watTime: ZonedDateTime = ZonedDateTime.now(watZoneId)
    val dateFormat: DateTimeFormatter = DateTimeFormatter.ofPattern("MMM d, yyyy")
    val timeFormat: DateTimeFormatter = DateTimeFormatter.ofPattern(" H:mma")
    val dateNow = watTime.format(dateFormat).toString()
    val timeNow = watTime.format(timeFormat).toString()
    return "$dateNow:$timeNow"
}