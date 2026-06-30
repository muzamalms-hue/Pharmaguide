package com.example.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = PharmaTealDark,
    secondary = PharmaBlueDark,
    tertiary = PharmaAmber,
    background = PharmaBgDark,
    surface = PharmaSurfaceDark,
    onBackground = PharmaOnBgDark,
    onSurface = PharmaOnSurfaceDark
)

private val LightColorScheme = lightColorScheme(
    primary = PharmaTeal,
    secondary = PharmaBlue,
    tertiary = PharmaAmber,
    background = PharmaBgLight,
    surface = PharmaSurfaceLight,
    onBackground = PharmaOnBgLight,
    onSurface = PharmaOnSurfaceLight
)

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
