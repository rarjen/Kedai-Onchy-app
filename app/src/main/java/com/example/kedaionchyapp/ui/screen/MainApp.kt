package com.example.kedaionchyapp.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.*
import com.example.kedaionchyapp.data.FakeVoucherShipping
import com.example.kedaionchyapp.data.FakeVoucherShopping
import com.example.kedaionchyapp.ui.components.CustomBottomBar
import com.example.kedaionchyapp.ui.components.CustomTopBar
import com.example.kedaionchyapp.ui.navigation.Screen
import com.example.kedaionchyapp.ui.screen.home.HomeScreen
import com.example.kedaionchyapp.ui.screen.order.OrderScreen
import com.example.kedaionchyapp.ui.screen.profile.ProfileScreen
import com.example.kedaionchyapp.ui.screen.voucher.VoucherScreen

@Composable
fun MainApp() {

    val navController = rememberNavController()
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    val topBarTitle = when (currentRoute) {
        Screen.Order.route -> "Riwayat Pesanan"
        Screen.Voucher.route -> "Voucher"
        else -> null
    }

    Scaffold(
        modifier = Modifier.background(
            color = Color.DarkGray
        ),
        topBar = {
            if (topBarTitle != null) {
                if (topBarTitle === "Riwayat Pesanan") {
                    CustomTopBar(
                        title = topBarTitle,
                        onIconClick = { TODO() },
                        iconVector = Icons.Default.DateRange
                    )
                } else {
                    CustomTopBar(
                        title = topBarTitle,
                        onIconClick = { TODO() },
                    )
                }
            }
        },
        bottomBar = {
            CustomBottomBar(navController)
        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {

            composable(Screen.Home.route) { HomeScreen() }
            composable(Screen.Voucher.route) { VoucherScreen(
                onCardClick = { /*TODO*/ },
                voucherShoppingDataList = FakeVoucherShopping.dummyVoucherShopping,
                voucherShippingDataList = FakeVoucherShipping.dummyVoucherShipping
            ) }
            composable(Screen.Order.route) { OrderScreen() }
            composable(Screen.Profile.route) { ProfileScreen(
                profilePicture = "https://ik.imagekit.io/6v306xm58/218.jpg",
                fullNameUser = "Mulyono Sukajabat",
                phoneNumberUser = "+6281264008731",
                onProfileCardClick = { /*TODO*/ },
                onCardCustomerServiceClick = { /*TODO*/ }
            ) }
        }
    }
}