package com.example.kedaionchyapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kedaionchyapp.ui.theme.KedaiOnchyAppTheme
import com.example.kedaionchyapp.ui.theme.RedChinese
import coil.compose.AsyncImage
import com.example.kedaionchyapp.ui.theme.GoldChinese
import com.example.kedaionchyapp.ui.theme.OrangeChinese

@Composable

fun ClickableCardProfile(
    profilePicture: String,
    fullNameUser: String,
    phoneNumberUser: String,
    onCardClick: () -> Unit
){
    Card(
        colors = CardDefaults.cardColors(
            containerColor = OrangeChinese
        ),
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.fillMaxWidth().height(110.dp).padding(bottom = 16.dp),
        onClick = onCardClick
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxSize().padding(16.dp)
        ) {
//                Profile Picture & Creds
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                AsyncImage(
                    model = profilePicture,
                    contentDescription = "Foto Profil Pengguna",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(60.dp)
                        .border(
                            width = 2.dp,
                            color = RedChinese,
                            shape = CircleShape
                        )
                        .clip(CircleShape)
                        .background(Color.White)
                )

                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxHeight()
                            .padding(start = 10.dp)
                ) {
                    Text(
                        text = fullNameUser.uppercase(),
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = phoneNumberUser,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
//                Button Arrow
            Row() {
                Icon(
                    imageVector =  Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun ClickableCardProfilePreview(){
    KedaiOnchyAppTheme() {
        ClickableCardProfile(
            profilePicture = "https://ik.imagekit.io/6v306xm58/218.jpg",
            fullNameUser = "Mulyono Sukajabat",
            phoneNumberUser = "+6281264008731",
            onCardClick = { /*TODO*/ }
        )
    }
}


