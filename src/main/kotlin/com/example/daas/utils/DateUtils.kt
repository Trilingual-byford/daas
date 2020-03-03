package com.example.daas.utils

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class DateUtils {
    companion object {
        val STANDARD_DATE_PATTERN: String = "MM-dd-yyyy"
        val STD_DATE_FORMAT = SimpleDateFormat(STANDARD_DATE_PATTERN)
        fun DateToString(date: Date): String {
            return STD_DATE_FORMAT.format(date)
        }
    }
}