package com.example.kedaionchyapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kedaionchyapp.ui.theme.DeepJade
import com.example.kedaionchyapp.ui.theme.IvoryCream
import com.example.kedaionchyapp.ui.theme.KedaiOnchyAppTheme

@Composable
fun CustomTopBar(
    title: String,
    iconVector: ImageVector? = null,
    onIconClick: () -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(86.dp)
            .background(DeepJade)
            .padding(start = 16.dp, end = 16.dp, top = 24.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            text = title,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = IvoryCream
        )

        // Icon di kanan
        if (iconVector != null) {
            IconButton(
                onClick = onIconClick,
                modifier = Modifier.align(Alignment.CenterEnd)
            ) {
                Icon(
                    imageVector = iconVector,
                    contentDescription = "icon",
                    tint = IvoryCream
                )
            }
        }


    }
}

@Preview(showBackground = true)
@Composable
private fun CustomTopBarPreview() {
    KedaiOnchyAppTheme() {
        CustomTopBar(
            title = "Riwayat Pesanan",
            onIconClick = {},
            iconVector = Icons.Default.DateRange
        )
    }
}