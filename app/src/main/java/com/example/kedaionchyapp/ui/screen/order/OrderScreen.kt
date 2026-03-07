package com.example.kedaionchyapp.ui.screen.order

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kedaionchyapp.data.FakeOrderData
import com.example.kedaionchyapp.ui.components.HistoryOrderCard
import com.example.kedaionchyapp.ui.theme.KedaiOnchyAppTheme

@Composable
fun OrderScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Judul Halaman
//        Text(
//            text = "Riwayat Pesanan",
//            fontSize = 24.sp,
//            fontWeight = FontWeight.Bold,
//            color = Color.White,
//            modifier = Modifier.padding(28.dp)
//        )

        // Daftar Card menggunakan LazyColumn
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 28.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp) // Jarak antar card
        ) {
            items(FakeOrderData.dummyOrder) { order ->
                HistoryOrderCard(order = order)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun OrderScreenPreview() {
    KedaiOnchyAppTheme() {
        OrderScreen()
    }
}