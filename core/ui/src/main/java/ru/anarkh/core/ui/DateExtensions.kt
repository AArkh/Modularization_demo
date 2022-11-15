package ru.anarkh.core.ui

import java.util.*

fun Date.monthBefore(): Date {
    val calendar = Calendar.getInstance()
    calendar.time = this
    calendar.add(Calendar.MONTH, -1)
    return calendar.time
}

fun Date.dayBefore(): Date {
    val calendar = Calendar.getInstance()
    calendar.time = this
    calendar.add(Calendar.DAY_OF_MONTH, -1)
    return calendar.time
}