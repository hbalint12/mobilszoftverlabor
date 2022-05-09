package com.bme.aut.stockdatamonitor.ui.main

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun StockTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val darkThemeColors = darkColors(
        primary = Color(0xFFEA6D7E),
        primaryVariant = Color(0xFFDD0D3E),
        onPrimary = Color.Black,
        secondary = Color(0xFF121212),
        onSecondary = Color.White,
        surface = Color(0xFF121212),
        background = Color(0xFF121212),
        onBackground = Color.White,
        onSurface = Color.White
    )
    MaterialTheme(
        colors = darkThemeColors,
        content = content
    )
}