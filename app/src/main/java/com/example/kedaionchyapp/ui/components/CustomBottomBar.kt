package com.example.kedaionchyapp.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.kedaionchyapp.ui.navigation.Screen
import com.example.kedaionchyapp.ui.theme.DeepJade
import com.example.kedaionchyapp.ui.theme.ElegantBlack
import com.example.kedaionchyapp.ui.theme.GoldChinese
import com.example.kedaionchyapp.ui.theme.IvoryCream
import com.example.kedaionchyapp.ui.theme.KedaiOnchyAppTheme

@Composable
fun CustomBottomBar(navController: NavController) {
    val items = listOf(
        Screen.Home,
        Screen.Voucher,
        Screen.Order,
        Screen.Profile
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    // Gunakan NavigationBar (Bukan BottomAppBar manual) agar mengikuti Material 3 Guide
    NavigationBar(
        // NavigationBar otomatis mengambil warna surface dari theme (Dark/Light)
        containerColor = DeepJade,
        tonalElevation = 8.dp, // Memberikan sedikit efek bayangan/kedalaman
        modifier = Modifier.fillMaxWidth()
    ) {
        items.forEach { screen ->
            val selected = currentRoute == screen.route

            // Warna animasi untuk icon dan text
            val animatedColor by animateColorAsState(
                targetValue = if (selected) GoldChinese else IvoryCream,
                animationSpec = tween(300),
                label = "nav_color_anim"
            )

            NavigationBarItem(
                selected = selected,
                onClick = {
                    if (currentRoute != screen.route) {
                        navController.navigate(screen.route) {
                            popUpTo(navController.graph.startDestinationId) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        // Indikator garis kecil di atas icon saat terpilih
                        AnimatedVisibility(visible = selected) {
                            Box(
                                modifier = Modifier
                                    .height(3.dp)
                                    .width(20.dp)
                                    .clip(RoundedCornerShape(50))
                                    .background(GoldChinese)
                            )
                        }

                        Spacer(modifier = Modifier.height(4.dp))

                        Icon(
                            imageVector = when (screen) {
                                Screen.Home -> Icons.Default.Home
                                Screen.Voucher -> Icons.Default.ConfirmationNumber // Ikon tiket lebih cocok untuk voucher
                                Screen.Order -> Icons.Default.History // History lebih cocok untuk riwayat pesanan
                                Screen.Profile -> Icons.Default.Person
                                else -> Icons.Default.Home
                            },
                            contentDescription = null,
                            tint = animatedColor,
                            modifier = Modifier.size(26.dp)
                        )
                    }
                },
                label = {
                    Text(
                        text = screen.route.replaceFirstChar { it.uppercase() },
                        color = animatedColor,
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal
                    )
                },
                // Menghilangkan background pill bawaan Material 3 jika Anda ingin tampilan lebih clean
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun CustomBottomBarPreview() {
    KedaiOnchyAppTheme() {
        val navController = rememberNavController()
        CustomBottomBar(navController)
    }
}