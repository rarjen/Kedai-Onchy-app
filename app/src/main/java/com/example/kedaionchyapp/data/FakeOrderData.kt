package com.example.kedaionchyapp.data

import com.example.kedaionchyapp.data.local.model.OrderHistory
import com.example.kedaionchyapp.data.local.model.OrderItem
import java.math.BigDecimal

object FakeOrderData {
    val dummyOrder = listOf<OrderHistory>(
        OrderHistory(
            id = "ORD-001",
            status = "BERHASIL",
            outletName = "BSB, Semarang",
            dateTime = "Sabtu, 21 Feb 2026 16:29",
            items = listOf(
                OrderItem("Capcay Goreng", 1)
            ),
            totalPrice = BigDecimal(20000)
        ),

        OrderHistory(
            id = "ORD-002",
            status = "BERHASIL",
            outletName = "BSB, Semarang",
            dateTime = "Sabtu, 07 Feb 2026 17:08",
            items = listOf(
                OrderItem("Kwetiaw Goreng", 1),
                OrderItem("Bakmi Goreng", 1),
                OrderItem("Sapo Tahu", 1)
            ),
            totalPrice = BigDecimal(52000)
        ),

        OrderHistory(
            id = "ORD-003",
            status = "BERHASIL",
            outletName = "Gajah Mada, Semarang",
            dateTime = "Minggu, 18 Jan 2026 19:16",
            items = listOf(
                OrderItem("Fuyunghai", 1),
                OrderItem("Capcay Kuah", 1)
            ),
            totalPrice = BigDecimal(45000)
        ),

        OrderHistory(
            id = "ORD-004",
            status = "BERHASIL",
            outletName = "Tembalang, Semarang",
            dateTime = "Jumat, 02 Jan 2026 14:02",
            items = listOf(
                OrderItem("Ayam Koloke", 2)
            ),
            totalPrice = BigDecimal(40000)
        ),

        OrderHistory(
            id = "ORD-005",
            status = "DIBATALKAN",
            outletName = "Tlogosari, Semarang",
            dateTime = "Rabu, 24 Des 2025 09:45",
            items = listOf(
                OrderItem("Sapo Tahu", 1)
            ),
            totalPrice = BigDecimal(25000)
        )
    )
}