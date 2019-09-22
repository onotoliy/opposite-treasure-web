package com.github.onotoliy.opposite.treasure.utils

import kotlin.js.Date

fun getCurrentDate(): String = Date().toISOString().substring(0, 10)

fun String.fromISO(): String = Date(this).toISOString().substring(0, 10)

fun String.toISO() = Date(this).toISOString()

fun String.toReadableDateString(): String {
    val date = Date(this)
    return dateToReadableDateString(date)
}

fun dateToReadableDateString(date: Date): String {
    val day = "0${date.getDate()}".takeLast(2)
    val month = "0${date.getMonth() + 1}".takeLast(2)
    return "$day.$month.${date.getFullYear()}"
}
