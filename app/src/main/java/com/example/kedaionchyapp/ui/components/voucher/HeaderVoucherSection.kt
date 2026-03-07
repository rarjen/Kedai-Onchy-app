package com.example.kedaionchyapp.ui.components.voucher

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kedaionchyapp.ui.components.DashedDivider
import com.example.kedaionchyapp.ui.theme.ElegantBlack

@Composable
fun HeaderVoucherSection(
    title: String,
    count: Int
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Text(
                text = "$count voucher",
                fontSize = 12.sp,
                color = ElegantBlack.copy(alpha = 0.6f)
            )
        }
        DashedDivider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp)
                .height(2.dp),
        )
    }
}