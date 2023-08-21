package com.example.androidlearningproject.ui

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Spacing(
    val default:Dp = 2.dp,
    val extraSmall:Dp = 4.dp,
    val small:Dp = 8.dp,
    val medium:Dp = 16.dp,
    val large:Dp = 18.dp,
    val extraLarge:Dp = 22.dp
)

val LocalSpacing = compositionLocalOf { Spacing() }