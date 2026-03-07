package com.example.kedaionchyapp.utils

import java.math.BigDecimal
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols

fun CurrencyIDR(amount: BigDecimal): String {
    val symbols = DecimalFormatSymbols()
    symbols.groupingSeparator = '.' // '.' for IDR standard
    symbols.decimalSeparator = ','

    symbols.decimalSeparator = ','

    // Pattern: Rp followed by thousands separator
    val formatter = DecimalFormat("Rp #,###", symbols)
    return formatter.format(amount)
}