package com.example.kedaionchyapp.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kedaionchyapp.R
import com.example.kedaionchyapp.data.FakeOrderData
import com.example.kedaionchyapp.data.local.model.OrderHistory
import com.example.kedaionchyapp.ui.theme.GoldChinese
import com.example.kedaionchyapp.ui.theme.GoldChineseLight
import com.example.kedaionchyapp.ui.theme.KedaiOnchyAppTheme
import com.example.kedaionchyapp.ui.theme.RedChinese
import com.example.kedaionchyapp.utils.CurrencyIDR
import java.math.BigDecimal

@Composable
fun HistoryOrderCard(
    order: OrderHistory
) {
    var totalItem: Int = 0
    var totalPriceFormatted: String = "Rp 0"

    val customizedColor = when (order.status) {
        "BERHASIL" -> GoldChinese
        "DIBATALKAN" -> RedChinese
        else -> Color.LightGray
    }

    val summaryOrder = if (order.items.size > 2) {
        // Ambil 2 menu pertama saja
        val firstTwoItems = order.items.take(2).joinToString(", ") {
            "${it.quantity} ${it.name}"
        }
        // Hitung sisa menu yang tidak ditampilkan
        val remainingCount = order.items.size - 2

        "$firstTwoItems, +$remainingCount menu lainnya"
    } else {
        // Jika menu 2 atau kurang, tampilkan semuanya
        order.items.joinToString(", ") {
            "${it.quantity} ${it.name}"
        }
    }

    order.items.forEach { it ->
        totalItem += it.quantity
    }

    if (order.totalPrice > BigDecimal(0)) {
        totalPriceFormatted = CurrencyIDR(order.totalPrice)
    }


    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.Black
        ),
        border = BorderStroke(2.dp, GoldChinese),
        modifier = Modifier.fillMaxWidth().height(215.dp),
        shape = RoundedCornerShape(18.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
//            Image(
//                painter = painterResource(R.drawable.dragon_scale_background),
//                contentDescription = null,
//                alignment = Alignment.BottomEnd,
//                colorFilter = GoldChineseLight,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .offset(x = 150.dp, y = (180).dp)
//                    .rotate(300f) // derajat rotasi
//            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(18.dp)
            ) {

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = order.status,
                        color = customizedColor,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(start = 10.dp).wrapContentWidth()
                    ) {

                        Text(
                            text = order.orderSource,
                            fontSize = 9.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.LightGray,
                            modifier = Modifier.padding(end = 5.dp)
                        )

                        Icon(
                            imageVector = Icons.Default.Phone,
                            contentDescription = null,
                            tint = Color.LightGray,
                            modifier = Modifier.size(15.dp)
                        )
                    }
                }

                Text(
                    text = order.outletName,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily.SansSerif,
                    color = Color.White
                )

                Text(
                    text = order.dateTime,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = FontFamily.SansSerif,
                    color = Color.White,
                    modifier = Modifier.offset(y = (-6).dp)
                )

                Text(
                    text = summaryOrder,
                    maxLines = 1,
                    fontSize = 10.sp,
                    overflow = TextOverflow.Ellipsis,
                    color = GoldChineseLight
                )

                HorizontalDivider(
                    thickness = 1.dp,
                    modifier = Modifier.padding(vertical = 16.dp)
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            text = "${totalItem.toString()} item",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = GoldChineseLight
                        )

                        Box(
                            modifier = Modifier.size(15.dp)
                                .padding(5.dp)
                                .background(color = GoldChineseLight, shape = CircleShape)
                        )

                        Text(
                            text = totalPriceFormatted,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = GoldChineseLight
                        )
                    }

                    Button(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(GoldChinese),
                        shape = RoundedCornerShape(10.dp),
                        contentPadding = PaddingValues(0.dp),
                        modifier = Modifier.width(90.dp)
                            .height(30.dp)
                    ) {
                        Text(
                            text = "Pesan Lagi",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            color = Color.White,
                            modifier = Modifier.fillMaxSize().wrapContentHeight(Alignment.CenterVertically)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HistoryOrderCardPreview() {
    KedaiOnchyAppTheme {
        HistoryOrderCard(
            order = FakeOrderData.dummyOrder[1]
        )
    }
}