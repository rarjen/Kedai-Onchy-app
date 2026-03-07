package com.example.kedaionchyapp.utils


import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

fun FormatDateToString(date: LocalDate): String {
    val localeID = Locale.forLanguageTag("id-ID")
    val formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", localeID)
    return date.format(formatter)
}