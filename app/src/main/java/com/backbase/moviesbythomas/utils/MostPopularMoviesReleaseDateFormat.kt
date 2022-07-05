package com.backbase.moviesbythomas.utils

fun releaseDateFormat(date: String): String{
    val year = date.substring(0,4)
    val month = date.substring(5,7)
    val day = date.substring(8,10)

    return "${toNameOfMonth(month.toInt())} $day, $year"
}