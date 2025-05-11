package com.kingsley.fitnessapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Custom dark color scheme
private val DarkColorScheme = darkColorScheme(
    primary = Color.Red,
    secondary = Color(0xFFEF5350),
    background = Color.Black,
    surface = Color.DarkGray,
    onPrimary = Color.Black,
    onSecondary = Color.Black,
    onBackground = Color.White,
    onSurface = Color.White,
)

// Optional light color scheme (if you want to support it later)
private val LightColorScheme = lightColorScheme(
    primary = Color.Red,
    secondary = Color(0xFFEF5350),
    background = Color.White,
    surface = Color.LightGray,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color.Black,
    onSurface = Color.Black,
)

@Composable
fun FitnessAppTheme(
    darkTheme: Boolean = true, // force dark theme
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography, // define or import your Typography
        shapes = Shapes(),       // default shapes
        content = content
    )
}
