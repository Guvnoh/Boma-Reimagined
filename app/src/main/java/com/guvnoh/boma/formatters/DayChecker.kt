package com.guvnoh.boma.formatters

import java.util.Calendar
import java.util.Date

//how to make the code know which day it is
//fetch last record and check the date on it
fun Date.getTimeAgo(){
    val calendar = Calendar.getInstance()
    calendar.time = this
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val week = calendar.get(Calendar.DAY_OF_WEEK)
    val day = calendar.get(Calendar.DAY_OF_MONTH)
    val hour = calendar.get(Calendar.HOUR_OF_DAY)
    val minute = calendar.get(Calendar.MINUTE)
//when date of last saved record is not today's date, 'sold today' resets to zero for all products

}