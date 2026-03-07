package com.example.kedaionchyapp.ui.screen.auth.register

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kedaionchyapp.R
import com.example.kedaionchyapp.ui.components.PasswordTextField
import com.example.kedaionchyapp.ui.navigation.Screen
import com.example.kedaionchyapp.ui.theme.GoldChinese
import com.example.kedaionchyapp.ui.theme.KedaiOnchyAppTheme
import com.example.kedaionchyapp.ui.theme.RedChinese

@Composable
fun RegisterScreen(navController: NavController) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    // Reusable Color Configuration (Sama dengan Login agar konsisten)
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

    Scaffold() { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
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
                // Header
                Text(
                    text = "Daftar Akun Baru",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontFamily = FontFamily.Serif,
                    fontSize = 28.sp,
                    modifier = Modifier.padding(top = 12.dp)
                )

                Text(
                    text = "Lengkapi data untuk memulai petualangan kuliner.",
                    color = Color.Gray,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    fontStyle = FontStyle.Italic,
                    modifier = Modifier.padding(top = 8.dp, bottom = 32.dp)
                )

                // Field Nama Lengkap
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text(text = "Nama Lengkap") },
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp),
                    leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) },
                    colors = customTextFieldColors,
                    singleLine = true
                )

                // Field Email
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text(text = "Email") },
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp),
                    leadingIcon = { Icon(Icons.Default.Email, contentDescription = null) },
                    colors = customTextFieldColors,
                    singleLine = true
                )

                // Field Password
//                OutlinedTextField(
//                    value = password,
//                    onValueChange = { password = it },
//                    label = { Text(text = "Password") },
//                    shape = RoundedCornerShape(10.dp),
//                    modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp),
//                    leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null) },
//                    visualTransformation = PasswordVisualTransformation(),
//                    colors = customTextFieldColors,
//                    singleLine = true
//                )
                PasswordTextField(
                    label = "Password",
                    contentDescription = "password"
                )


                // Field Konfirmasi Password
//                OutlinedTextField(
//                    value = confirmPassword,
//                    onValueChange = { confirmPassword = it },
//                    label = { Text(text = "Konfirmasi Password") },
//                    shape = RoundedCornerShape(10.dp),
//                    modifier = Modifier.fillMaxWidth().padding(bottom = 32.dp),
//                    leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null) },
//                    visualTransformation = PasswordVisualTransformation(),
//                    colors = customTextFieldColors,
//                    singleLine = true
//                )

                PasswordTextField(
                    label = "Konfirmasi Password",
                    contentDescription = "konfirmasi password"
                )

                // Button Daftar
                Button(
                    onClick = { /* Handle Register */ },
                    colors = ButtonDefaults.buttonColors(containerColor = RedChinese),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.fillMaxWidth().height(50.dp)
                ) {
                    Text(
                        text = "Daftar Sekarang",
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        fontSize = 16.sp
                    )
                }

                // Back to Login
                Row (modifier = Modifier.padding(top = 24.dp)) {
                    Text(text = "Sudah punya akun?", fontSize = 14.sp, color = Color.Gray)
                    Text(
                        text = " Masuk",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = GoldChinese,
                        modifier = Modifier.clickable {
                            navController.popBackStack()
                        }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun RegisterScreenPreview() {
    KedaiOnchyAppTheme() {
        val navController = rememberNavController()
        RegisterScreen(navController)
    }
}