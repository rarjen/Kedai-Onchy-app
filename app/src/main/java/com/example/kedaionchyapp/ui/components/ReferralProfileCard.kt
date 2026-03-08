package com.example.kedaionchyapp.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kedaionchyapp.R
import com.example.kedaionchyapp.ui.theme.DeepJade
import com.example.kedaionchyapp.ui.theme.ElegantBlack
import com.example.kedaionchyapp.ui.theme.GoldChinese
import com.example.kedaionchyapp.ui.theme.IvoryCream
import com.example.kedaionchyapp.ui.theme.KedaiOnchyAppTheme
import com.example.kedaionchyapp.ui.theme.PremiumGold
import com.example.kedaionchyapp.ui.theme.RedChinese

@Composable
fun ReferralProfileCard(
    onCardClick: () -> Unit
){
    Card(
        colors = CardDefaults.cardColors(
            containerColor = ElegantBlack
        ),
        border = BorderStroke(1.dp, PremiumGold),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp,
            pressedElevation = 2.dp
        ),
        modifier = Modifier.fillMaxWidth().height(110.dp),
        onClick = onCardClick
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.referral_icon_card),
                contentDescription = stringResource(id = R.string.description_referral_icon_card),
                colorFilter = ColorFilter.tint(DeepJade)
            )

            Column(
                modifier = Modifier.padding(start = 16.dp)
            ) {
                Text(
                    text = stringResource(R.string.title_referral_icon_card),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = GoldChinese
                )
                Text(
                    text = stringResource(R.string.description_raferral_icon_card),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    color = IvoryCream,
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun ReferralProfileCardPreview(){
    KedaiOnchyAppTheme() {
        ReferralProfileCard(
            onCardClick = { /*TODO*/ }
        )
    }
}