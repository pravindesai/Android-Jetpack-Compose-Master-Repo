package com.example.androidlearningproject

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import com.example.androidlearningproject.ui.LocalSpacing
import com.example.androidlearningproject.ui.Spacing

@Composable
fun LocalCompositionContext() {
    CompositionLocalProvider(LocalSpacing provides Spacing()) {
        Column {
            Text(
                text = "ABCD", modifier = Modifier.size(
                LocalSpacing.current.extraLarge
            ))
        }
    }
}

