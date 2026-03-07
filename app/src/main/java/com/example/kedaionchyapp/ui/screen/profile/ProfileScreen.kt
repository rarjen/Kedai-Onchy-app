package com.example.kedaionchyapp.ui.screen.profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kedaionchyapp.R
import com.example.kedaionchyapp.ui.components.ClickableCardProfile
import com.example.kedaionchyapp.ui.components.ProfileListMenuSection
import com.example.kedaionchyapp.ui.components.ReferralProfileCard
import com.example.kedaionchyapp.ui.theme.GoldChinese
import com.example.kedaionchyapp.ui.theme.GoldChineseLight
import com.example.kedaionchyapp.ui.theme.KedaiOnchyAppTheme
import com.example.kedaionchyapp.ui.theme.RedChinese

@Composable
fun ProfileScreen(
    profilePicture: String,
    fullNameUser: String,
    phoneNumberUser: String,
    onProfileCardClick: () -> Unit,
    onCardCustomerServiceClick: () -> Unit
) {
    val scrollState = rememberScrollState()
    val versionApp = stringResource(R.string.version_app)

    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color.Black)
            .verticalScroll(scrollState)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().background(Color.White).padding(16.dp)
        ) {
            ClickableCardProfile(
                profilePicture = profilePicture,
                fullNameUser = fullNameUser,
                phoneNumberUser =phoneNumberUser,
                onProfileCardClick
            )

            ReferralProfileCard{}
        }

        HorizontalDivider(
            thickness = 4.dp,
            color = Color.Black,
            modifier = Modifier.fillMaxWidth()
        )

//        Menu Section top
        Column(
            modifier = Modifier.fillMaxWidth().background(Color.White).padding(start = 16.dp, end = 16.dp, top = 16.dp)
        ) {
            ProfileListMenuSection(
                menu = "Alamat Tersimpan",
                onClickList = { /*TODO*/ }
            )
            ProfileListMenuSection(
                menu = "Pembayaran",
                onClickList = { /*TODO*/ }
            )
            ProfileListMenuSection(
                menu = "Pusat Bantuan",
                onClickList = { /*TODO*/ }
            )
            ProfileListMenuSection(
                menu = "Pengaturan",
                onClickList = { /*TODO*/ }
            )
        }

        HorizontalDivider(
            thickness = 4.dp,
            color = Color.Black,
            modifier = Modifier.fillMaxWidth()
        )

        Column(
            modifier = Modifier.fillMaxWidth().background(Color.White).padding(start = 16.dp, end = 16.dp, top = 16.dp)
        ) {
            ProfileListMenuSection(
                menu = "Syarat dan Ketentuan",
                onClickList = { /*TODO*/ }
            )
            ProfileListMenuSection(
                menu = "Kebijakan Privasi",
                onClickList = { /*TODO*/ }
            )

            ProfileListMenuSection(
                menu = "Media Sosial",
                onClickList = { /*TODO*/ }
            )
        }

        HorizontalDivider(
            thickness = 4.dp,
            color = Color.Black,
            modifier = Modifier.fillMaxWidth()
        )

        Column(
            modifier = Modifier.fillMaxWidth().background(Color.White).padding(start = 16.dp, end = 16.dp, top = 10.dp, bottom = 18.dp)
        ) {
            Text(
                text = "Butuh Bantuan?",
                color = Color.Black,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp
            )
            Text(
                text = "Hubungi Customer Service kami",
                fontWeight = FontWeight.Light,
                color = Color.Black,
                fontSize = 12.sp
            )

            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 8.dp,
                    pressedElevation = 2.dp
                ),
                modifier = Modifier.fillMaxWidth().height(70.dp),
                onClick = onCardCustomerServiceClick
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth().padding(10.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.wa_icon),
                        contentDescription = stringResource(id = R.string.description_referral_icon_card),
                        modifier = Modifier.size(50.dp)
                    )

                    Column(
                        modifier = Modifier.padding(start = 8.dp)
                    ) {
                        Text(
                            text = "Kedai Oncy Customer Service (chat only)",
                            fontSize = 12.sp,
                            color = Color.Black
                        )
                        Text(
                            text = stringResource(R.string.customer_service_phone_number),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color.Black,
                        )
                    }

                    Icon(
                        imageVector =  Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        contentDescription = null,
                        tint = Color.Black,
                        modifier = Modifier.padding(start = 10.dp)
                    )
                }
            }
        }

        HorizontalDivider(
            thickness = 4.dp,
            color = Color.Black,
            modifier = Modifier.fillMaxWidth()
        )

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth().background(Color.White).padding(16.dp)
        ) {
            Text(
                text = "Version ${versionApp}",
                fontWeight = FontWeight.Normal,
                color = Color.Gray,
                fontStyle = FontStyle.Normal,
                fontFamily = FontFamily.SansSerif
            )

            Text(
                text = stringResource(R.string.logout_text),
                color = Color.Red,
                fontStyle = FontStyle.Normal,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Normal
            )
        }

        HorizontalDivider(
            thickness = 4.dp,
            color = Color.Black,
            modifier = Modifier.fillMaxWidth()
        )


    }
}

@Preview(showBackground = true)
@Composable
private fun ProfileScreenPreview(){
    KedaiOnchyAppTheme() {
        ProfileScreen(
            profilePicture = "https://ik.imagekit.io/6v306xm58/218.jpg",
            fullNameUser = "Mulyono Sukajabat",
            phoneNumberUser = "+6281264008731",
            onProfileCardClick = { /*TODO*/ },
            onCardCustomerServiceClick = { /*TODO*/ }
        )
    }
}