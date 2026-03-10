package com.example.kedaionchyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kedaionchyapp.ui.navigation.Screen
import com.example.kedaionchyapp.ui.screen.MainApp
import com.example.kedaionchyapp.ui.screen.auth.login.LoginScreen
import com.example.kedaionchyapp.ui.screen.auth.register.RegisterScreen // Pastikan import ini benar
import com.example.kedaionchyapp.ui.screen.home.HomeScreen
import com.example.kedaionchyapp.ui.theme.KedaiOnchyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()
        setContent {
            KedaiOnchyAppTheme {
                val navController = rememberNavController()

                // Hapus Scaffold di sini, biarkan MainApp yang handle
                NavHost(
                    navController = navController,
                    startDestination = Screen.Login.route,
                ) {
                    composable(Screen.Login.route) {
                        LoginScreen(
                            navController = navController,
                            onLoginSuccess = {
                                navController.navigate("main") {
                                    popUpTo(Screen.Login.route) { inclusive = true }
                                }
                            },
                            onClickGuest = {
                                navController.navigate("main") {
                                    popUpTo(Screen.Login.route) { inclusive = true }
                                }
                            }
                        )
                    }

                    composable(Screen.Register.route) {
                        RegisterScreen(navController = navController)
                    }

                    composable("main") {
                        MainApp()
                    }
                }
            }
        }
    }
}