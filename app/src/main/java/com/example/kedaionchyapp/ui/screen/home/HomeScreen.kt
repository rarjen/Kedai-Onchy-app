package com.example.kedaionchyapp.ui.screen.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kedaionchyapp.ui.components.ImageCarousel
import com.example.kedaionchyapp.ui.theme.KedaiOnchyAppTheme

@Composable
fun HomeScreen() {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            ImageCarousel()
        }

        item {
            Column(modifier = Modifier.height(500.dp)) { }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    KedaiOnchyAppTheme() {
        HomeScreen()
    }
}