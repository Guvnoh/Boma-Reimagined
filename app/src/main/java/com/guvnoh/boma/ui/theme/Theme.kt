package com.guvnoh.boma.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat

/**
 * BOMA Professional Theme
 * A premium, modern design system for a professional business app
 */

// ═══════════════════════════════════════════════════════════════════════════
// LIGHT COLOR SCHEME
// ═══════════════════════════════════════════════════════════════════════════
private val LightColorScheme = lightColorScheme(
    // Primary
    primary = BomaPrimary,
    onPrimary = Color.White,
    primaryContainer = BomaPrimaryContainer,
    onPrimaryContainer = OnBomaPrimaryContainer,

    // Secondary
    secondary = BomaSecondary,
    onSecondary = Color.White,
    secondaryContainer = BomaSecondaryContainer,
    onSecondaryContainer = OnBomaSecondaryContainer,

    // Tertiary
    tertiary = BomaTertiary,
    onTertiary = Color.White,
    tertiaryContainer = BomaTertiaryContainer,
    onTertiaryContainer = OnBomaTertiaryContainer,

    // Background & Surface
    background = BomaBackground,
    onBackground = BomaOnBackground,
    surface = BomaSurface,
    onSurface = BomaOnSurface,
    surfaceVariant = BomaSurfaceVariant,
    onSurfaceVariant = BomaOnSurfaceVariant,

    // Outline
    outline = BomaOutline,
    outlineVariant = BomaOutlineVariant,

    // Error
    error = BomaError,
    onError = Color.White,
    errorContainer = BomaErrorContainer,
    onErrorContainer = OnBomaErrorContainer,

    // Inverse
    inverseSurface = BomaOnBackground,
    inverseOnSurface = BomaBackground,
    inversePrimary = BomaPrimaryLight,

    // Scrim
    scrim = BomaOverlay
)

// ═══════════════════════════════════════════════════════════════════════════
// DARK COLOR SCHEME
// ═══════════════════════════════════════════════════════════════════════════
private val DarkColorScheme = darkColorScheme(
    // Primary
    primary = BomaPrimaryLight,
    onPrimary = BomaPrimaryDark,
    primaryContainer = BomaPrimaryDark,
    onPrimaryContainer = BomaPrimaryContainer,

    // Secondary
    secondary = BomaSecondaryLight,
    onSecondary = BomaSecondaryDark,
    secondaryContainer = BomaSecondaryDark,
    onSecondaryContainer = BomaSecondaryContainer,

    // Tertiary
    tertiary = BomaTertiaryLight,
    onTertiary = BomaTertiaryDark,
    tertiaryContainer = BomaTertiaryDark,
    onTertiaryContainer = BomaTertiaryContainer,

    // Background & Surface
    background = BomaBackgroundDark,
    onBackground = BomaOnBackgroundDark,
    surface = BomaSurfaceDark,
    onSurface = BomaOnSurfaceDark,
    surfaceVariant = BomaSurfaceVariantDark,
    onSurfaceVariant = BomaOnSurfaceVariantDark,

    // Outline
    outline = BomaOutlineDark,
    outlineVariant = BomaOutlineVariantDark,

    // Error
    error = BomaErrorLight,
    onError = BomaErrorContainer,
    errorContainer = OnBomaErrorContainer,
    onErrorContainer = BomaErrorContainer,

    // Inverse
    inverseSurface = BomaOnBackgroundDark,
    inverseOnSurface = BomaBackgroundDark,
    inversePrimary = BomaPrimary,

    // Scrim
    scrim = BomaOverlay
)

// ═══════════════════════════════════════════════════════════════════════════
// SHAPES - Modern, refined corner radii
// ═══════════════════════════════════════════════════════════════════════════
val BomaShapes = Shapes(
    // Buttons, Chips, Small elements
    extraSmall = RoundedCornerShape(8.dp),
    // Text Fields, Small cards
    small = RoundedCornerShape(12.dp),
    // Cards, Dialogs
    medium = RoundedCornerShape(16.dp),
    // Bottom sheets, Large cards
    large = RoundedCornerShape(24.dp),
    // Full screen modals
    extraLarge = RoundedCornerShape(32.dp)
)

// ═══════════════════════════════════════════════════════════════════════════
// DIMENSION CONSTANTS
// ═══════════════════════════════════════════════════════════════════════════
object BomaDimens {
    // Spacing (8pt grid system)
    val spacingXxs = 2.dp
    val spacingXs = 4.dp
    val spacingSm = 8.dp
    val spacingMd = 12.dp
    val spacingLg = 16.dp
    val spacingXl = 24.dp
    val spacingXxl = 32.dp
    val spacingXxxl = 48.dp

    // Corner Radius
    val radiusXs = 4.dp
    val radiusSm = 8.dp
    val radiusMd = 12.dp
    val radiusLg = 16.dp
    val radiusXl = 24.dp
    val radiusXxl = 32.dp
    val radiusFull = 999.dp

    // Elevation
    val elevationNone = 0.dp
    val elevationXs = 1.dp
    val elevationSm = 2.dp
    val elevationMd = 4.dp
    val elevationLg = 8.dp
    val elevationXl = 16.dp

    // Icon Sizes
    val iconXs = 16.dp
    val iconSm = 20.dp
    val iconMd = 24.dp
    val iconLg = 32.dp
    val iconXl = 48.dp

    // Component Heights
    val buttonHeight = 52.dp
    val buttonHeightSmall = 40.dp
    val inputHeight = 56.dp
    val cardMinHeight = 80.dp
    val appBarHeight = 64.dp
    val bottomBarHeight = 80.dp

    // Avatar/Image Sizes
    val avatarSm = 32.dp
    val avatarMd = 48.dp
    val avatarLg = 64.dp
    val avatarXl = 80.dp
    val avatarXxl = 120.dp

    // Card dimensions
    val cardPadding = 16.dp
    val cardPaddingLarge = 20.dp
}

// ═══════════════════════════════════════════════════════════════════════════
// MAIN THEME COMPOSABLE
// ═══════════════════════════════════════════════════════════════════════════
@Composable
fun BOMATheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            // Use dynamic colors on Android 12+ if enabled
            // For now, stick with our custom palette
            if (darkTheme) DarkColorScheme else LightColorScheme
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    // Set status bar color
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.background.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = BomaTypography,
        shapes = BomaShapes,
        content = content
    )
}

// ═══════════════════════════════════════════════════════════════════════════
// THEME EXTENSION COLORS
// ═══════════════════════════════════════════════════════════════════════════
// Access custom colors that aren't part of MaterialTheme

object BomaColors {
    val success = BomaSuccess
    val successLight = BomaSuccessLight
    val successContainer = BomaSuccessContainer
    val onSuccessContainer = OnBomaSuccessContainer

    val warning = BomaWarning
    val warningLight = BomaWarningLight
    val warningContainer = BomaWarningContainer
    val onWarningContainer = OnBomaWarningContainer

    val info = BomaInfo
    val infoLight = BomaInfoLight
    val infoContainer = BomaInfoContainer
    val onInfoContainer = OnBomaInfoContainer

    val gradientPrimary = listOf(BomaGradientStart, BomaGradientMiddle, BomaGradientEnd)
    val gradientGold = listOf(BomaSecondaryDark, BomaSecondary, BomaSecondaryLight)

    // Product type colors
    val bottles = BomaBottleColor
    val cans = BomaCansColor
    val pets = BomaPetsColor

    // Company colors
    val cocaCola = BomaCocaColaAccent
    val hero = BomaHeroAccent
    val nbl = BomaNBLAccent
    val guinness = BomaGuinnessAccent
}