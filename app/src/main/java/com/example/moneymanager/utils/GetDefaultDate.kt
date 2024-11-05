package com.example.moneymanager.utils

import java.util.Calendar

fun getDefaultStartDate(): Long {
    val calendar = Calendar.getInstance()
    calendar.set(Calendar.DAY_OF_MONTH, 1)
    return calendar.timeInMillis
}

fun getDefaultEndDate(): Long {
    val calendar = Calendar.getInstance()
    calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH))
    return calendar.timeInMillis
}