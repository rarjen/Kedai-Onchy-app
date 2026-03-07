package com.example.kedaionchyapp.data

import com.example.kedaionchyapp.data.local.model.VoucherShipping
import java.math.BigDecimal
import java.time.LocalDate

object FakeVoucherShipping {
    val dummyVoucherShipping = listOf<VoucherShipping>(
        VoucherShipping(
            id = "VSHOP-001",
            iconVoucher = "https://ik.imagekit.io/6v306xm58/istockphoto-1267682418-612x612.jpg?updatedAt=1727172163017",
            voucherTitle = "Voucher Delivery. Max Radius 5Km!",
            voucherDescription = "Hemat Ongkir s/d 5K",
            expiredDate = LocalDate.of(2026, 3, 17),
            minimumTransactionTotal = BigDecimal(45000),
            totalDiscount = BigDecimal(5000),
            maxRadius = 5
        ),
        VoucherShipping(
            id = "VSHOP-002",
            iconVoucher = "https://ik.imagekit.io/6v306xm58/istockphoto-1267682418-612x612.jpg?updatedAt=1727172163017",
            voucherTitle = "Diskon Ongkir 3K!",
            voucherDescription = "Menggunakan kurir GrobExpress",
            expiredDate = LocalDate.of(2026, 3, 17),
            minimumTransactionTotal = BigDecimal(45000),
            totalDiscount = BigDecimal(3000),
            maxRadius = 0
        )
    )
}