package com.example.kedaionchyapp.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

//private val DarkColorScheme = darkColorScheme(
//    primary = GoldChinese,         // Emas sebagai aksen utama di mode gelap
//    onPrimary = Color.Black,       // Teks di atas emas jadi hitam agar kontras
//    secondary = RedChinese,
//    background = Color(0xFF121212), // Hitam pekat
//    surface = Color(0xFF1E1E1E),    // Abu-abu sangat tua untuk Card & BottomBar
//    onBackground = Color.White,
//    onSurface = Color.White
//)
//
//private val LightColorScheme = lightColorScheme(
//    primary = GoldChinese,         // Emas sebagai aksen utama di mode gelap
//    onPrimary = Color.Black,       // Teks di atas emas jadi hitam agar kontras
//    secondary = RedChinese,
//    background = Color(0xFF121212), // Hitam pekat
//    surface = Color(0xFF1E1E1E),    // Abu-abu sangat tua untuk Card & BottomBar
//    onBackground = Color.White,
//    onSurface = Color.White
//)

// Definisikan skema tetap Anda di sini
private val OnchyPersistentScheme = darkColorScheme(
    primary = GoldChinese,
    onPrimary = ElegantBlack,
    secondary = RedChinese,
    background = Color.Black, // Dasar selalu Hitam
    surface = ElegantBlack,   // Card & BottomBar menggunakan Hitam Elegan Anda
    onBackground = IvoryCream, // Teks menggunakan Krem Gading agar tidak terlalu silau
    onSurface = IvoryCream
)

@Composable
fun KedaiOnchyAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
//    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {

    val colorScheme = OnchyPersistentScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
//    val colorScheme = when {
//        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
//            val context = LocalContext.current
//            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
//        }
//
//        darkTheme -> DarkColorScheme
//        else -> LightColorScheme
//    }

//    MaterialTheme(
//        colorScheme = colorScheme,
//        typography = Typography,
//        content = content
//    )
}