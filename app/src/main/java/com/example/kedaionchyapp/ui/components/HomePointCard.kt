package com.example.kedaionchyapp.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kedaionchyapp.R
import com.example.kedaionchyapp.ui.theme.ActionOrange
import com.example.kedaionchyapp.ui.theme.DeepJade
import com.example.kedaionchyapp.ui.theme.ElegantBlack
import com.example.kedaionchyapp.ui.theme.GoldChinese
import com.example.kedaionchyapp.ui.theme.GoldChineseLight
import com.example.kedaionchyapp.ui.theme.IvoryCream
import com.example.kedaionchyapp.ui.theme.KedaiOnchyAppTheme
import com.example.kedaionchyapp.ui.theme.OrangeChineseLight
import com.example.kedaionchyapp.ui.theme.PremiumGold
import com.example.kedaionchyapp.ui.theme.RedChinese
import com.example.kedaionchyapp.ui.theme.SoftGold

@Composable
fun HomePointCard(
    userPoint: Int = 0
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .background(Color.Black),
        shape = RoundedCornerShape(
            topStart = 16.dp,
            topEnd = 16.dp,
            bottomEnd = 0.dp,
            bottomStart = 0.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = ElegantBlack
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
                    .height(70.dp)
                    .padding(horizontal = 16.dp),
            ) {
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = DeepJade.copy(0.5f)
                    ),
                    modifier = Modifier.width(100.dp).height(35.dp),
                    shape = RoundedCornerShape(60.dp),
                    border = BorderStroke(1.dp, DeepJade)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxSize().padding(horizontal = 12.dp)
                    ) {
                        Icon(
                            painter = painterResource(id= R.drawable.kedai_onchy_login_logo),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp),
                            tint = GoldChinese
                        )
                        Spacer(
                            modifier = Modifier.width(4.dp)
                        )
                        Text(
                            text = "${userPoint} Poin",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = GoldChinese,
                            fontSize = 13.sp
                        )
                    }
                }
            }

            DashedDivider(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp),
                color = IvoryCream.copy(0.8f)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxSize()
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    text = "Yuk, Tukar poin anda sebelum kadaluarsa!",
                    color = IvoryCream,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp
                )

                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = ActionOrange
                    ),
                    modifier = Modifier.width(80.dp).height(24.dp),
                    shape = RoundedCornerShape(60.dp),
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxSize().padding(horizontal = 12.dp)
                    ) {
                        Text(
                            text = "Tukar",
                            color = IvoryCream,
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomePointCardPreview() {
    KedaiOnchyAppTheme() {
        HomePointCard(
            userPoint = 38
        )
    }
}