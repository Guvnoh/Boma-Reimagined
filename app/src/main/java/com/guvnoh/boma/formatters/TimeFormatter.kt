package com.guvnoh.boma.formatters

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.Month
import java.time.ZoneId
import java.time.ZonedDateTime
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
fun getDay():Int{
    return  LocalDateTime.now().dayOfMonth
}

//@RequiresApi(Build.VERSION_CODES.O)
//fun checkIfSoldToday(timeInput: List<String> = listOf("Thu", "oct", "30", "2025")): Boolean{
//    //Input time comes in the pattern [Thu, Oct, 30, 2025]
//    val recordYear = timeInput[3].toInt()
//    //val recordMonth = timeInput[1].lowercase()
//    val recordMonth = Month.valueOf(timeInput[1].uppercase().take(3))
//
//
//    val recordDay = timeInput[2].toInt() //oct
//
//    val yearNow = LocalDateTime.now().year
//    //val monthNow = LocalDateTime.now().month.name.lowercase().take
//    val monthNow = LocalDateTime.now().month
//    val dayNow = LocalDateTime.now().dayOfMonth
//    var isSoldToday: Boolean = false
//    if (
//        yearNow == recordYear &&
//        monthNow == recordMonth &&
//        dayNow == recordDay
//        ){
//        isSoldToday = true
//    }
//    return  isSoldToday
//}


@RequiresApi(Build.VERSION_CODES.O)
fun checkIfSoldToday(timeInput: List<String> = listOf("Thu", "Oct", "30", "2025")): Boolean {
    val recordYear = timeInput[3].toInt()
    val recordMonth = Month.valueOf(timeInput[1].uppercase().take(3))
    val recordDay = timeInput[2].toInt()

    val now = LocalDateTime.now()

    return (
            now.year == recordYear &&
                    now.month == recordMonth &&
                    now.dayOfMonth == recordDay
            )

}
