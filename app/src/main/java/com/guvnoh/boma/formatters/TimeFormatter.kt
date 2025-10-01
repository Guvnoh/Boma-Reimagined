package com.guvnoh.boma.formatters

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

//Time format
@RequiresApi(Build.VERSION_CODES.O)
val watZoneId: ZoneId = ZoneId.of("Africa/Lagos")
@RequiresApi(Build.VERSION_CODES.O)
val watTime: ZonedDateTime = ZonedDateTime.now(watZoneId)
@RequiresApi(Build.VERSION_CODES.O)
val dateFormat: DateTimeFormatter = DateTimeFormatter.ofPattern("d-MMM-yyyy")
@RequiresApi(Build.VERSION_CODES.O)
val timeFormat: DateTimeFormatter = DateTimeFormatter.ofPattern("H:mma")
@RequiresApi(Build.VERSION_CODES.O)
val dateNow = watTime.format(dateFormat).toString()
@RequiresApi(Build.VERSION_CODES.O)
val timeNow = watTime.format(timeFormat).toString()