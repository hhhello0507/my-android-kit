package com.hhhello0507.mydesignsystem.foundation.typography

import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

object MyTypographyTokens {

    /*
    Display1
     */
    val Display1B = DefaultTextStyle.copy(
        fontWeight = FontWeight.Bold,
        fontSize = 36.sp,
    )
    val Display1M = Display1B.copy(fontWeight = FontWeight.Medium)
    val Display1R = Display1B.copy(fontWeight = FontWeight.Normal)

    /*
    Display2
     */
    val Display2B = DefaultTextStyle.copy(
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
    )
    val Display2M = Display2B.copy(fontWeight = FontWeight.Medium)
    val Display2R = Display2B.copy(fontWeight = FontWeight.Normal)

    /*
    Title1
     */
    val Title1B = DefaultTextStyle.copy(
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
    )
    val Title1M = Title1B.copy(fontWeight = FontWeight.Medium)
    val Title1R = Title1B.copy(fontWeight = FontWeight.Normal)

    /*
    Title2
     */
    val Title2B = DefaultTextStyle.copy(
        fontWeight = FontWeight.Bold,
        fontSize = 26.sp,
    )
    val Title2M = Title2B.copy(fontWeight = FontWeight.Medium)
    val Title2R = Title2B.copy(fontWeight = FontWeight.Normal)

    /*
    Title3
     */
    val Title3B = DefaultTextStyle.copy(
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
    )
    val Title3M = Title3B.copy(fontWeight = FontWeight.Medium)
    val Title3R = Title3B.copy(fontWeight = FontWeight.Normal)

    /*
    Heading1
     */
    val Heading1B = DefaultTextStyle.copy(
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
    )
    val Heading1M = Heading1B.copy(fontWeight = FontWeight.Medium)
    val Heading1R = Heading1B.copy(fontWeight = FontWeight.Normal)

    /*
    Heading2
     */
    val Heading2B = DefaultTextStyle.copy(
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
    )
    val Heading2M = Heading2B.copy(fontWeight = FontWeight.Medium)
    val Heading2R = Heading2B.copy(fontWeight = FontWeight.Normal)

    /*
    Headline
     */
    val HeadlineB = DefaultTextStyle.copy(
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    )
    val HeadlineM = HeadlineB.copy(fontWeight = FontWeight.Medium)
    val HeadlineR = HeadlineB.copy(fontWeight = FontWeight.Normal)

    /*
    Body
     */
    val BodyBold = DefaultTextStyle.copy(
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
    )
    val BodyMedium = BodyBold.copy(fontWeight = FontWeight.Medium)
    val BodyRegular = BodyBold.copy(fontWeight = FontWeight.Normal)

    /*
    Label
     */
    val LabelBold = DefaultTextStyle.copy(
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
    )
    val LabelMedium = LabelBold.copy(fontWeight = FontWeight.Medium)
    val LabelRegular = LabelBold.copy(fontWeight = FontWeight.Normal)

    /*
    Caption
     */
    val CaptionBold = DefaultTextStyle.copy(
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
    )
    val CaptionMedium = CaptionBold.copy(fontWeight = FontWeight.Medium)
    val CaptionRegular = CaptionBold.copy(fontWeight = FontWeight.Normal)
}

val DefaultTextStyle = TextStyle.Default.copy(
    fontFamily = FontFamily.SansSerif,
    platformStyle = PlatformTextStyle(includeFontPadding = false),
    lineHeight = 1.3.em
)