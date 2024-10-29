package com.hhhello0507.mydesignsystem.component.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.hhhello0507.mydesignsystem.foundation.MyTheme

sealed class ButtonSize(
    val spacing: Dp,
    val height: Dp,
    val cornerRadius: Dp,
    val iconSize: Dp,
    val contentPadding: PaddingValues
) {
    data object Larger: ButtonSize(
        spacing = 6.dp,
        height = 56.dp,
        cornerRadius = 12.dp,
        iconSize = 22.dp,
        contentPadding = PaddingValues(
            horizontal = 24.dp
        )
    )

    data object Large: ButtonSize(
        spacing = 6.dp,
        height = 48.dp,
        cornerRadius = 10.dp,
        iconSize = 20.dp,
        contentPadding = PaddingValues(
            horizontal = 20.dp
        )
    )

    data object Medium: ButtonSize(
        spacing = 5.dp,
        height = 38.dp,
        cornerRadius = 8.dp,
        iconSize = 18.dp,
        contentPadding = PaddingValues(
            horizontal = 16.dp
        )
    )

    data object Small: ButtonSize(
        spacing = 4.dp,
        height = 32.dp,
        cornerRadius = 6.dp,
        iconSize = 16.dp,
        contentPadding = PaddingValues(
            horizontal = 12.dp
        )
    )

    val textStyle: TextStyle
        @Composable get() = when(this) {
            Larger -> MyTheme.typography.bodyBold
            Large -> MyTheme.typography.bodyMedium
            Medium -> MyTheme.typography.labelMedium
            Small -> MyTheme.typography.captionMedium
        }
}