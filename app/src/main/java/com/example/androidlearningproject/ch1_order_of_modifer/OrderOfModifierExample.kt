package com.example.androidlearningproject.ch1_order_of_modifer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview
@Composable
fun OrderOfModifier(modifier: Modifier = Modifier) {
    Text(
        text = "Im the content",
        modifier = Modifier
        .background(color = Color.Green)
        .padding(10.dp)
        .background(Color.Black)
        .padding(1.dp)
        .background(color = Color.Yellow)
        .padding(10.dp),
        )
}