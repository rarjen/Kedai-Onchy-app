package com.example.kedaionchyapp.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.kedaionchyapp.ui.navigation.Screen
import com.example.kedaionchyapp.ui.theme.GoldChinese
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

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black.copy(alpha = 0.0f))
            .padding(horizontal = 24.dp, vertical = 20.dp),
        contentAlignment = Alignment.Center
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(40.dp))
                .background(Color.Black)
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {

            items.forEach { screen ->

                val selected = currentRoute == screen.route

                val animatedColor by animateColorAsState(
                    targetValue = if (selected) GoldChinese else Color.White.copy(alpha = 0.6f),
                    animationSpec = tween(250),
                    label = ""
                )

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .clickable {
                            if (currentRoute != screen.route) {
                                navController.navigate(screen.route) {
                                    popUpTo(navController.graph.startDestinationId) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        }
                        .padding(horizontal = 18.dp, vertical = 6.dp)
                ) {

                    // Indicator animated
                    AnimatedVisibility(visible = selected) {
                        Box(
                            modifier = Modifier
                                .height(3.dp)
                                .width(24.dp)
                                .clip(RoundedCornerShape(50))
                                .background(GoldChinese)
                        )
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Icon(
                        imageVector = when (screen) {
                            Screen.Home -> Icons.Default.Home
                            Screen.Voucher -> Icons.Default.CheckCircle
                            Screen.Order -> Icons.Default.ShoppingCart
                            Screen.Profile -> Icons.Default.Person
                            else -> Icons.Default.Home
                        },
                        contentDescription = null,
                        tint = animatedColor
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = screen.route.replaceFirstChar { it.uppercase() },
                        color = animatedColor,
                        style = MaterialTheme.typography.labelSmall
                    )
                }
            }
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