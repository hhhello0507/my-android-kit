package com.hhhello0507.mydesignsystem.component.divider

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.hhhello0507.mydesignsystem.foundation.MyTheme
import com.hhhello0507.mydesignsystem.internal.MyPreviews

sealed class DividerSize(
    val size: Dp
) {
    data object Small: DividerSize(size = 1.dp)
    data object Medium: DividerSize(size = 8.dp)
    data object Large: DividerSize(size = 10.dp)
}

@Composable
fun MyHorizontalDivider(
    modifier: Modifier = Modifier,
    size: DividerSize = DividerSize.Small,
    color: Color = MyTheme.colorScheme.lineNormal
) {
    HorizontalDivider(
        modifier = modifier,
        thickness = size.size,
        color = color
    )
}

@Composable
@MyPreviews
private fun Preview() {
    MyTheme {
        Column(
            modifier = Modifier
                .background(MyTheme.colorScheme.backgroundNormal)
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            MyHorizontalDivider()
            MyHorizontalDivider(size = DividerSize.Medium)
            MyHorizontalDivider(size = DividerSize.Large)
        }
    }
}