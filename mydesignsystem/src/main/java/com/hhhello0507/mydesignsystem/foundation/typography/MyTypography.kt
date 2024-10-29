package com.hhhello0507.mydesignsystem.foundation.typography

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import com.hhhello0507.mydesignsystem.foundation.MyTheme
import com.hhhello0507.mydesignsystem.internal.MyPreviews

@Immutable
class MyTypography(
    val display1B: TextStyle = TypographyTokens.Display1B,
    val display1M: TextStyle = TypographyTokens.Display1M,
    val display1R: TextStyle = TypographyTokens.Display1R,
    val display2B: TextStyle = TypographyTokens.Display2B,
    val display2M: TextStyle = TypographyTokens.Display2M,
    val display2R: TextStyle = TypographyTokens.Display2R,
    val title1B: TextStyle = TypographyTokens.Title1B,
    val title1M: TextStyle = TypographyTokens.Title1M,
    val title1R: TextStyle = TypographyTokens.Title1R,
    val title2B: TextStyle = TypographyTokens.Title2B,
    val title2M: TextStyle = TypographyTokens.Title2M,
    val title2R: TextStyle = TypographyTokens.Title2R,
    val heading1B: TextStyle = TypographyTokens.Heading1B,
    val heading1M: TextStyle = TypographyTokens.Heading1M,
    val heading1R: TextStyle = TypographyTokens.Heading1R,
    val heading2B: TextStyle = TypographyTokens.Heading2B,
    val heading2M: TextStyle = TypographyTokens.Heading2M,
    val heading2R: TextStyle = TypographyTokens.Heading2R,
    val headlineB: TextStyle = TypographyTokens.HeadlineB,
    val headlineM: TextStyle = TypographyTokens.HeadlineM,
    val headlineR: TextStyle = TypographyTokens.HeadlineR,
    val bodyBold: TextStyle = TypographyTokens.BodyBold,
    val bodyMedium: TextStyle = TypographyTokens.BodyMedium,
    val bodyRegular: TextStyle = TypographyTokens.BodyRegular,
    val labelBold: TextStyle = TypographyTokens.LabelBold,
    val labelMedium: TextStyle = TypographyTokens.LabelMedium,
    val labelRegular: TextStyle = TypographyTokens.LabelRegular,
    val captionBold: TextStyle = TypographyTokens.CaptionBold,
    val captionMedium: TextStyle = TypographyTokens.CaptionMedium,
    val captionRegular: TextStyle = TypographyTokens.CaptionRegular,
)

internal val LocalMyTypography = staticCompositionLocalOf { MyTypography() }

@Composable
@MyPreviews
private fun Preview() {
    MyTheme {
        Surface(
            color = MyTheme.colorScheme.backgroundNormal
        ) {
            LazyColumn {
                val typography = MyTypography()
                items(
                    listOf(
                        typography.display1B,
                        typography.display1M,
                        typography.display1R,
                        typography.display2B,
                        typography.display2M,
                        typography.display2R,
                        typography.title1B,
                        typography.title1M,
                        typography.title1R,
                        typography.title2B,
                        typography.title2M,
                        typography.title2R,
                        typography.heading1B,
                        typography.heading1M,
                        typography.heading1R,
                        typography.heading2B,
                        typography.heading2M,
                        typography.heading2R,
                        typography.headlineB,
                        typography.headlineM,
                        typography.headlineR,
                        typography.bodyBold,
                        typography.bodyMedium,
                        typography.bodyRegular,
                        typography.labelBold,
                        typography.labelMedium,
                        typography.labelRegular,
                        typography.captionBold,
                        typography.captionMedium,
                        typography.captionRegular,
                    )
                ) { textStyle ->
                    Text(
                        text = "테스트",
                        color = MyTheme.colorScheme.labelNormal,
                        style = textStyle
                    )
                }
            }
        }
    }
}