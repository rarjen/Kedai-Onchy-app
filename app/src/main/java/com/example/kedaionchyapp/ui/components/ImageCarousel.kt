package com.example.kedaionchyapp.ui.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.kedaionchyapp.ui.theme.DeepJade
import com.example.kedaionchyapp.ui.theme.IvoryCream
import com.example.kedaionchyapp.ui.theme.KedaiOnchyAppTheme
import com.example.kedaionchyapp.ui.theme.PremiumGold
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield

@Composable
fun ImageCarousel() {
    val images = listOf(
        "https://ik.imagekit.io/6v306xm58/1.png?updatedAt=1728110985979",
        "https://ik.imagekit.io/6v306xm58/3.png?updatedAt=1728110987556",
        "https://ik.imagekit.io/6v306xm58/2.png?updatedAt=1728110987658",
        "https://ik.imagekit.io/6v306xm58/5.png?updatedAt=1728111109463",
    )

    val pagerState = rememberPagerState(pageCount = { images.size })

    // Auto-swipe logic tetap sama
    LaunchedEffect(Unit) {
        while (true) {
            yield()
            delay(3000)
            pagerState.animateScrollToPage((pagerState.currentPage + 1) % images.size)
        }
    }

    // Gunakan Box untuk menumpuk dots di atas Pager
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(258.dp)
    ) {
        // 1. Lapisan Bawah: Pager Gambar
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
                .clip(
                    RoundedCornerShape(
                        topStart = 0.dp,
                        topEnd = 0.dp,
                        bottomEnd = 16.dp,
                        bottomStart = 16.dp
                    )
                )
                .background(DeepJade)
        ) { page ->
            AsyncImage(
                model = images[page],
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize(),
            )
        }

        // 2. Lapisan Atas: Indikator Dots
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter) // Meletakkan di tengah bawah dalam Box
                .padding(bottom = 68.dp) // Jarak dari tepi bawah gambar
                .wrapContentHeight()
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(pagerState.pageCount) { iteration ->
                val color = if (pagerState.currentPage == iteration) PremiumGold else IvoryCream.copy(0.5f)
                val width = if (pagerState.currentPage == iteration) 18.dp else 8.dp

                Box(
                    modifier = Modifier
                        .padding(horizontal = 3.dp)
                        .clip(CircleShape)
                        .background(color)
                        .width(width)
                        .height(8.dp)
                        .animateContentSize()
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ImageCarouselPreview(){
    KedaiOnchyAppTheme() {
        ImageCarousel()
    }
}