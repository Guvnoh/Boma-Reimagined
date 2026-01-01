package com.guvnoh.boma.dateProvider

import android.os.Build
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.Date
import java.util.Locale

object DateProvider {
    fun todayString(): String {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            LocalDate.now().toString()
        } else {
            SimpleDateFormat("yyyy-MM-dd", Locale.US).format(Date())
        }
    }
}


