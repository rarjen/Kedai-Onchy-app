package com.example.kedaionchyapp.ui.screen.auth.login

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kedaionchyapp.R
import com.example.kedaionchyapp.ui.theme.GoldChinese
import com.example.kedaionchyapp.ui.theme.KedaiOnchyAppTheme
import com.example.kedaionchyapp.ui.theme.RedChinese
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kedaionchyapp.ui.components.PasswordTextField
import com.example.kedaionchyapp.ui.navigation.Screen


@Composable
fun LoginScreen(
    navController: NavController,
    onLoginSuccess: () -> Unit,
    onClickGuest: () -> Unit
    ) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context = LocalContext.current.applicationContext
    var passwordVisible by remember { mutableStateOf(false) }

    val customTextFieldColors = OutlinedTextFieldDefaults.colors(
        // Warna saat Focus (Golden Chinese)
        focusedBorderColor = GoldChinese,
        focusedLabelColor = GoldChinese,
        focusedLeadingIconColor = GoldChinese,
        focusedContainerColor = Color.Black,

        // Warna saat Unfocus (Red Chinese)
        unfocusedBorderColor = Color.White,
        unfocusedLabelColor = Color.White,
        unfocusedLeadingIconColor = Color.White,
        unfocusedContainerColor = Color.Black,

        // Warna kursor agar mengikuti tema emas
        cursorColor = GoldChinese
    )

    val trailingIconContent: @Composable () -> Unit = {
        val image = if (passwordVisible) {
            Icons.Filled.Visibility
        } else {
            Icons.Filled.VisibilityOff
        }

        IconButton(onClick = { passwordVisible = !passwordVisible }) {
            Icon(
                imageVector = image,
                contentDescription = if (passwordVisible) "Sembunyikan password" else "Tampilkan password"
            )
        }
    }

    val passwordTransformation = if (passwordVisible) {
        VisualTransformation.None
    } else {
        PasswordVisualTransformation()
    }



    Scaffold() { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
                .background(Color.Black)
                .padding(innerPadding)
                .padding(horizontal = 28.dp, vertical = 56.dp)
                .verticalScroll(rememberScrollState()) // Tambah scroll agar aman di layar kecil
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Icon(
                    painter = painterResource(R.drawable.kedai_onchy_login_logo),
                    tint = GoldChinese,
                    contentDescription = null,
                    modifier = Modifier.size(120.dp)
                )

                Text(
                    text = "Kedai Onchy",
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                    fontFamily = FontFamily.Serif,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(top = 12.dp)
                )

                Text(
                    text = "Mulai petualangan rasa Anda di sini.",
                    color = Color.Gray,
                    fontSize = 14.sp,
                    fontStyle = FontStyle.Italic,
                    modifier = Modifier.padding(bottom = 40.dp)
                )

                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text(text = "Email") },
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp),
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Email, contentDescription = "email")
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next,
                        autoCorrect = false
                    ),
                    colors = customTextFieldColors
                )

                PasswordTextField(
                    label = "Password",
                    contentDescription = "password"
                )

                Button(
                    onClick = {
                        if (authentication(email, password)) {
                            Toast.makeText(context, "Success Login", Toast.LENGTH_SHORT).show()
                            onLoginSuccess()
                        } else {
                            Toast.makeText(context, "Invalid Credentials", Toast.LENGTH_SHORT).show()
                        }
                    },
                    colors = ButtonDefaults.buttonColors(RedChinese),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Masuk",
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
//                    fontSize = 18.dp
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth().padding(vertical = 18.dp),
                ) {
                    HorizontalDivider(
                        modifier = Modifier.weight(1f),
                        color = Color.Gray.copy(alpha = 0.5f),
                        thickness = 1.dp
                    )

                    Text(
                        text = "ATAU",
                        modifier = Modifier.padding(horizontal = 16.dp),
                        color = Color.Gray,
                        fontSize = 12.sp,
                        fontFamily = FontFamily.SansSerif
                    )

                    HorizontalDivider(
                        modifier = Modifier.weight(1f),
                        color = Color.Gray.copy(alpha = 0.5f),
                        thickness = 1.dp
                    )
                }

                OutlinedButton(
                    onClick = {
                        onClickGuest()
                    },
                    shape = RoundedCornerShape(10.dp),
                    border = BorderStroke(1.dp, GoldChinese),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = GoldChinese,
                    ),
                    modifier = Modifier.fillMaxWidth().padding(bottom = 18.dp)
                ) {
                    Text(
                        text = "Mulai eksplorasi",
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
//                    fontSize = 18.dp
                    )
                }

                Row() {
                    Text(
                        text = "Pengguna baru?",
                        fontSize = 12.sp,
                        color = Color.Gray,
                        fontFamily = FontFamily.SansSerif
                    )

                    Text(
                        text = "Daftar",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = GoldChinese,
                        fontFamily = FontFamily.SansSerif,
                        modifier = Modifier.padding(start = 2.dp).clickable{
                            navController.navigate(Screen.Register.route)
                        }
                    )
                }

            }

        }
    }
}

private fun authentication(email: String, password: String): Boolean {
    val validEmail = "admin@gmail.com"
    val validPassword = "admin123"

    return  email == validEmail && password == validPassword
}



@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    KedaiOnchyAppTheme() {
        val navController = rememberNavController()
        LoginScreen(
            navController = navController,
            onLoginSuccess = {},
            onClickGuest = {}
        )
    }
}