package com.bestswlkh0310.mydesignsystem.foundation.typography

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle

@Immutable
class MyTypography(
    val title1B: TextStyle = MyTypographyTokens.Title1B,
    val title1M: TextStyle = MyTypographyTokens.Title1M,
    val title1R: TextStyle = MyTypographyTokens.Title1R,
    val title2B: TextStyle = MyTypographyTokens.Title2B,
    val title2M: TextStyle = MyTypographyTokens.Title2M,
    val title2R: TextStyle = MyTypographyTokens.Title2R,
    val headline1B: TextStyle = MyTypographyTokens.Headline1B,
    val headline1M: TextStyle = MyTypographyTokens.Headline1M,
    val headline1R: TextStyle = MyTypographyTokens.Headline1R,
    val headline2B: TextStyle = MyTypographyTokens.Headline2B,
    val headline2M: TextStyle = MyTypographyTokens.Headline2M,
    val headline2R: TextStyle = MyTypographyTokens.Headline2R,
    val bodyBold: TextStyle = MyTypographyTokens.BodyBold,
    val bodyMedium: TextStyle = MyTypographyTokens.BodyMedium,
    val bodyRegular: TextStyle = MyTypographyTokens.BodyRegular,
    val labelBold: TextStyle = MyTypographyTokens.LabelBold,
    val labelMedium: TextStyle = MyTypographyTokens.LabelMedium,
    val labelRegular: TextStyle = MyTypographyTokens.LabelRegular,
    val captionBold: TextStyle = MyTypographyTokens.CaptionBold,
    val captionMedium: TextStyle = MyTypographyTokens.CaptionMedium,
    val captionRegular: TextStyle = MyTypographyTokens.CaptionRegular,
)

internal val LocalMyTypography = staticCompositionLocalOf { MyTypography() }
