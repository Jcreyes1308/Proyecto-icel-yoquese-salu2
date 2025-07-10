package com.example.proyecto.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Paleta personalizada
private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF5E2A36),
    secondary = Color(0xFF3E1F27),
    background = Color(0xFF1E1E1E),
    surface = Color(0xFF2C2C2C),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White,
)

@Composable
fun FuneralAppTheme(content: @Composable () -> Unit) {
    val colors = DarkColorScheme

    MaterialTheme(
        colorScheme = colors,
        typography = Typography(),
        content = content
    )
}
