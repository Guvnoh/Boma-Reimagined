package com.guvnoh.boma.formatters

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
fun getDate(): String{
    val now = LocalDateTime.now()
    val date = DateTimeFormatter.ofPattern("EEE, MMM dd yyyy")
    return now.format(date)
}

@RequiresApi(Build.VERSION_CODES.O)
fun getTime(): String{
    val now = LocalDateTime.now()
    val time = DateTimeFormatter.ofPattern("HH:mm:ss")
    return now.format(time)
}

@RequiresApi(Build.VERSION_CODES.O)
fun getDay(): String{
    return  LocalDateTime.now().toString()
}


@RequiresApi(Build.VERSION_CODES.O)
fun checkIfSoldToday(timeSold: String): Boolean {
    val now = LocalDateTime.now()
    val date = DateTimeFormatter.ofPattern("EEE, MMM dd yyyy")
    val timeNow = now.format(date)

//    val todayString = "$dayOfWeek, $monthNow $dayOfMonth $yearNow"
//    val formattedReceiptTime = timeSold.replace("[, ]", "")
//    val formattedTimeToday = todayString.replace("[, ]", "")

    return (timeSold.lowercase() == timeNow.lowercase())

}
