package com.example.kedaionchyapp.data

import com.example.kedaionchyapp.data.local.model.VoucherShopping
import java.math.BigDecimal
import java.time.LocalDate

object FakeVoucherShopping {

    val dummyVoucherShopping = listOf<VoucherShopping>(
        VoucherShopping(
            id = "VSHOP-001",
            iconVoucher = "https://ik.imagekit.io/6v306xm58/istockphoto-1267682418-612x612.jpg?updatedAt=1727172163017",
            voucherTitle = "Ramadhan Sale! Diskon 20%",
            voucherDescription = "Menu berbuka kamu!",
            expiredDate = LocalDate.of(2026, 3, 17),
            minimumTransactionTotal = BigDecimal(0),
            maximumVoucherCoverage = BigDecimal(75000),
            discountPercentage = BigDecimal(20)
        ),
        VoucherShopping(
            id = "VSHOP-002",
            iconVoucher = "https://ik.imagekit.io/6v306xm58/istockphoto-1267682418-612x612.jpg?updatedAt=1727172163017",
            voucherTitle = "Gratis Ongkir Semua Produk!",
            voucherDescription = "Nikmati gratis ongkir tanpa minimum belanja.",
            expiredDate = LocalDate.of(2026, 4, 1),
            minimumTransactionTotal = BigDecimal(0),
            maximumVoucherCoverage = BigDecimal(25000),
            discountPercentage = BigDecimal(100)
        ),
        VoucherShopping(
            id = "VSHOP-003",
            iconVoucher = "https://ik.imagekit.io/6v306xm58/istockphoto-1267682418-612x612.jpg?updatedAt=1727172163017",
            voucherTitle = "Cashback 15% Produk Elektronik",
            voucherDescription = "Cashback untuk pembelian elektronik pilihan.",
            expiredDate = LocalDate.of(2026, 5, 31),
            minimumTransactionTotal = BigDecimal(200000),
            maximumVoucherCoverage = BigDecimal(150000),
            discountPercentage = BigDecimal(15)
        ),
        VoucherShopping(
            id = "VSHOP-004",
            iconVoucher = "https://ik.imagekit.io/6v306xm58/istockphoto-1267682418-612x612.jpg?updatedAt=1727172163017",
            voucherTitle = "Diskon 10% Fashion Wanita",
            voucherDescription = "Belanja fashion wanita lebih hemat!",
            expiredDate = LocalDate.of(2026, 6, 15),
            minimumTransactionTotal = BigDecimal(100000),
            maximumVoucherCoverage = BigDecimal(50000),
            discountPercentage = BigDecimal(10)
        ),
        VoucherShopping(
            id = "VSHOP-005",
            iconVoucher = "https://ik.imagekit.io/6v306xm58/istockphoto-1267682418-612x612.jpg?updatedAt=1727172163017",
            voucherTitle = "Super Sale 25% Produk Dapur",
            voucherDescription = "Lengkapi dapurmu dengan harga spesial.",
            expiredDate = LocalDate.of(2026, 7, 20),
            minimumTransactionTotal = BigDecimal(150000),
            maximumVoucherCoverage = BigDecimal(100000),
            discountPercentage = BigDecimal(25)
        ),
        VoucherShopping(
            id = "VSHOP-006",
            iconVoucher = "https://ik.imagekit.io/6v306xm58/istockphoto-1267682418-612x612.jpg?updatedAt=1727172163017",
            voucherTitle = "Promo Ulang Tahun Diskon 30%",
            voucherDescription = "Rayakan ulang tahun dengan belanja hemat!",
            expiredDate = LocalDate.of(2026, 8, 10),
            minimumTransactionTotal = BigDecimal(250000),
            maximumVoucherCoverage = BigDecimal(200000),
            discountPercentage = BigDecimal(30)
        ),
        VoucherShopping(
            id = "VSHOP-007",
            iconVoucher = "https://ik.imagekit.io/6v306xm58/istockphoto-1267682418-612x612.jpg?updatedAt=1727172163017",
            voucherTitle = "Flash Sale 50% Produk Kecantikan",
            voucherDescription = "Penawaran terbatas produk kecantikan favoritmu!",
            expiredDate = LocalDate.of(2026, 9, 5),
            minimumTransactionTotal = BigDecimal(75000),
            maximumVoucherCoverage = BigDecimal(125000),
            discountPercentage = BigDecimal(50)
        )
    )
}