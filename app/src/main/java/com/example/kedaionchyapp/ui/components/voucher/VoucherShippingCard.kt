package com.example.kedaionchyapp.ui.components.voucher

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kedaionchyapp.R
import com.example.kedaionchyapp.data.FakeVoucherShipping
import com.example.kedaionchyapp.data.local.model.VoucherShipping
import com.example.kedaionchyapp.ui.components.DashedDivider
import com.example.kedaionchyapp.ui.theme.ActionOrange
import com.example.kedaionchyapp.ui.theme.DeepJade
import com.example.kedaionchyapp.ui.theme.IvoryCream
import com.example.kedaionchyapp.ui.theme.KedaiOnchyAppTheme
import com.example.kedaionchyapp.ui.theme.PremiumGold
import com.example.kedaionchyapp.ui.theme.SoftGold
import com.example.kedaionchyapp.utils.CurrencyIDR
import com.example.kedaionchyapp.utils.FormatDateToString
import java.math.BigDecimal

@Composable
fun VoucherShippingCard(
    data: VoucherShipping
) {

    val formattedDate: String = FormatDateToString(data.expiredDate)

    val formattedCurrency = if (data.minimumTransactionTotal != BigDecimal(0)) {
        CurrencyIDR(data.minimumTransactionTotal)
    } else {
        "-"
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(135.dp) // <--- FIX 1: Berikan tinggi tetap pada kartu
            .clip(TicketShape())
            // Gunakan merah gelap sebagai latar belakang utama
            .background(DeepJade)
            .border(
                width = 1.dp,
                color = PremiumGold.copy(alpha = 0.3f), // Emas yang agak transparan
                shape = TicketShape()
            )
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // --- BAGIAN ATAS (Info Diskon) ---
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.50f)
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = data.voucherTitle,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        fontSize = 11.sp,
                        // Gunakan kuning keemasan untuk judul
                        color = IvoryCream
                    )
                    Text(
                        text = data.voucherDescription,
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 11.sp,
                        // Gunakan kuning krem pucat untuk teks sekunder
                        color = SoftGold
                    )
                }

                // Tempat menaruh ikon/gambar kanan atas
                // Gunakan emas cerah untuk latar belakang ikon
                Box(
                    modifier = Modifier.size(40.dp)
                        .background(IvoryCream.copy(alpha = 0.15f), shape = CircleShape)
                        .border(1.dp, IvoryCream.copy(alpha = 0.3f), CircleShape)
                ) {
                    Image(
                        painter = painterResource(R.drawable.voucher_shopping_icon),
                        contentDescription = null,
                        contentScale = ContentScale.Crop, // Gunakan Crop jika ingin mengisi seluruh lingkaran
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(CircleShape)
                    )
                }
            }

            // --- GARIS PUTUS-PUTUS ---
            DashedDivider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
                    .height(1.dp),
                color = IvoryCream.copy(alpha = 0.4f)
            )

            // --- BAGIAN BAWAH (Tanggal & Tombol) ---
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .weight(0.50f),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(text = "Berlaku Hingga", fontSize = 11.sp, color = IvoryCream.copy(alpha = 0.7f))
                    Text(text = formattedDate, fontWeight = FontWeight.SemiBold, fontSize = 11.sp, color = IvoryCream)
                }

                Column {
                    Text(text = "Min Transaksi", fontSize = 11.sp, color = IvoryCream.copy(alpha = 0.6f))
                    Text(text = formattedCurrency, fontWeight = FontWeight.SemiBold, fontSize = 11.sp, color = IvoryCream)
                }

                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = ActionOrange,
                        contentColor = DeepJade
                    ),
                    shape = RoundedCornerShape(24.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 4.dp),
                    modifier = Modifier.height(30.dp) // Sesuaikan tinggi tombol agar tidak terlalu besar di area 35%
                ) {
                    Text("Pakai", color = Color.White) // Teks tombol putih agar kontras
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun VoucherShippingCardPreview(){
    KedaiOnchyAppTheme() {
        VoucherShippingCard(
            data = FakeVoucherShipping.dummyVoucherShipping[1]
        )
    }
}