package com.example.kedaionchyapp.data.local.model

import java.math.BigDecimal

data class OrderItem(
    val name: String,
    val quantity: Int
)

data class OrderHistory(
    val id: String,
    val status: String,
    val outletName: String,
    val dateTime: String,
    val items: List<OrderItem>,
    val totalPrice: BigDecimal,
    val orderSource: String = "Pesanan via Aplikasi"
)
