package com.example.kedaionchyapp.data.local.model

import java.math.BigDecimal
import java.time.LocalDate

data class VoucherShipping(
    val id: String,
    val iconVoucher: String,
    val voucherTitle: String,
    val voucherDescription: String,
    val expiredDate: LocalDate,

    val maxRadius: Int,
    val minimumTransactionTotal: BigDecimal,
    val totalDiscount: BigDecimal,
)
