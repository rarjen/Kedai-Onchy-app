package com.example.kedaionchyapp.ui.navigation

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Register : Screen("register")
    object Home : Screen("home")
    object Profile : Screen("profile")
    object Order : Screen("order")
    object Voucher : Screen("voucher")
}