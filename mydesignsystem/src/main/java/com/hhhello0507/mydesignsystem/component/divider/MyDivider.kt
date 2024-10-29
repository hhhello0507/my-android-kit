package com.hhhello0507.mydesignsystem.component.divider

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.hhhello0507.mydesignsystem.foundation.MyTheme
import com.hhhello0507.mydesignsystem.internal.MyPreviews

sealed class DividerType(val size: Dp) {
    data object Thin: DividerType(size = 1.dp)
    data object Thick: DividerType(size = 8.dp)
}

@Composable
fun MyDivider(
    modifier: Modifier = Modifier,
    thickness: DividerType = DividerType.Thin,
    color: Color = MyTheme.colorScheme.lineNormal
) {
    Box(
        modifier = modifier
            .background(color)
            .fillMaxWidth()
            .height(thickness.size),
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
            MyDivider()
            MyDivider(thickness = DividerType.Thick)
        }
    }
}