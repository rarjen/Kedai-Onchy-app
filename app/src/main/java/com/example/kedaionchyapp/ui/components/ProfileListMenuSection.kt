package com.example.kedaionchyapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kedaionchyapp.ui.theme.ElegantBlack
import com.example.kedaionchyapp.ui.theme.GoldChinese
import com.example.kedaionchyapp.ui.theme.IvoryCream
import com.example.kedaionchyapp.ui.theme.KedaiOnchyAppTheme

@Composable
fun ProfileListMenuSection(
    menu: String,
    onClickList: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth().background(Color.Black)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = menu,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = IvoryCream
            )

            Icon(
                imageVector =  Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = null,
                tint = IvoryCream,
                modifier = Modifier.padding(end = 18.dp)
            )
        }

//        Divider
        HorizontalDivider(
            thickness = 1.dp,
            color = GoldChinese,
            modifier = Modifier.padding(vertical = 20.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun ProfileListMenuSectionPreview(){
    KedaiOnchyAppTheme() {
        ProfileListMenuSection(
            menu = "Alamat Tersimpan",
            onClickList = { /*TODO*/ }
        )
    }
}