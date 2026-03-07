package com.example.kedaionchyapp.data.local.model

import java.math.BigDecimal
import java.time.LocalDate

data class VoucherShopping(
    val id: String,
    val iconVoucher: String,
    val voucherTitle: String,
    val voucherDescription: String,
    val expiredDate: LocalDate,

    val minimumTransactionTotal: BigDecimal,
    val maximumVoucherCoverage: BigDecimal,
    val discountPercentage: BigDecimal,
)
