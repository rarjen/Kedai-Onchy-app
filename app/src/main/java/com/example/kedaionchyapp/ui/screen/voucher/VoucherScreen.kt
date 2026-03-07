package com.example.kedaionchyapp.ui.screen.voucher

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kedaionchyapp.R
import com.example.kedaionchyapp.data.FakeVoucherShipping
import com.example.kedaionchyapp.data.FakeVoucherShopping
import com.example.kedaionchyapp.data.local.model.VoucherShipping
import com.example.kedaionchyapp.data.local.model.VoucherShopping
import com.example.kedaionchyapp.ui.components.voucher.HeaderVoucherSection
import com.example.kedaionchyapp.ui.components.voucher.VoucherDiscountCard
import com.example.kedaionchyapp.ui.components.voucher.VoucherShippingCard
import com.example.kedaionchyapp.ui.theme.DeepJade
import com.example.kedaionchyapp.ui.theme.KedaiOnchyAppTheme
import com.example.kedaionchyapp.ui.theme.SoftGold

@Composable
fun VoucherScreen(
    onCardClick: () -> Unit,
    voucherShoppingDataList: List<VoucherShopping>,
    voucherShippingDataList: List<VoucherShipping>
) {

    val totalVoucherShopping = if (voucherShoppingDataList.isNotEmpty()) {
        voucherShoppingDataList.size
    } else {
        0
    }

    val totalVoucherShipping = if (voucherShippingDataList.isNotEmpty()) {
        voucherShippingDataList.size
    } else {
        0
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(vertical = 8.dp)
    ) {
        item {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = DeepJade
                ),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.fillMaxWidth().height(70.dp),
                onClick = onCardClick
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxSize().padding(16.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.percent_icon),
                            contentDescription = stringResource(id = R.string.percentage_icon),
                            colorFilter = ColorFilter.tint(SoftGold),
                            modifier = Modifier.size(40.dp)
                        )

                        Column(
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier.fillMaxHeight().width(230.dp)
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "Mau lebih banyak diskon tiap hari? Yuk langganan Onchy Plus!",
                                color = Color.White,
                                fontWeight = FontWeight.Normal,
                                fontSize = 13.sp,
                                lineHeight = 14.sp
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

        item {
            HeaderVoucherSection(
                title = stringResource(R.string.shopping_voucher),
                count = totalVoucherShopping
            )
        }

        items(voucherShoppingDataList) {data ->
            VoucherDiscountCard(data = data)
        }

        item {
            HeaderVoucherSection(
                title = stringResource(R.string.shipping_voucher),
                count = totalVoucherShipping
            )
        }

        items(voucherShippingDataList) { data ->
            VoucherShippingCard(data = data)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun VoucherScreenPreview(){
    KedaiOnchyAppTheme() {
        VoucherScreen(
            onCardClick = { /*TODO*/ },
            voucherShoppingDataList = FakeVoucherShopping.dummyVoucherShopping,
            voucherShippingDataList = FakeVoucherShipping.dummyVoucherShipping
        )
    }
}