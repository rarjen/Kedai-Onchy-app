package com.example.kedaionchyapp.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.kedaionchyapp.ui.theme.GoldChinese

@Composable
fun PasswordTextField(
    label: String,
    contentDescription: String
) {

    var password by remember { mutableStateOf("") }
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
                contentDescription = if (passwordVisible) "Sembunyikan" else "Tampilkan"
            )
        }
    }

    val passwordTransformation = if (passwordVisible) {
        VisualTransformation.None
    } else {
        PasswordVisualTransformation()
    }

    OutlinedTextField(
        value = password,
        onValueChange = { password = it },
        label = { Text(text = label) },
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp),
        leadingIcon = {
            Icon(imageVector = Icons.Default.Lock, contentDescription = contentDescription)
        },
        visualTransformation = passwordTransformation,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done,
            autoCorrect = false
        ),
        colors = customTextFieldColors,
        trailingIcon = trailingIconContent,
        singleLine = true
    )

}