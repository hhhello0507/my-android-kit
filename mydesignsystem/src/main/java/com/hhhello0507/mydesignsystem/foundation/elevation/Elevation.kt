package com.hhhello0507.mydesignsystem.foundation.elevation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.hhhello0507.mydesignsystem.internal.shadow
import com.hhhello0507.mydesignsystem.foundation.MyTheme
import com.hhhello0507.mydesignsystem.internal.MyPreviews

sealed class Elevation(
    val y: Int,
    val blur: Int,
    val alpha: Float,
    val defaultColor: @Composable () -> Color
) {
    data object ElevationBlack1 : Elevation(y = 3, blur = 10, alpha = 0.02f, defaultColor = { MyTheme.colorScheme.elevationBlack1 })
    data object ElevationBlack2 : Elevation(y = 4, blur = 12, alpha = 0.04f, defaultColor = { MyTheme.colorScheme.elevationBlack2 })
    data object ElevationBlack3 : Elevation(y = 6, blur = 18, alpha = 0.06f, defaultColor = { MyTheme.colorScheme.elevationBlack3 })
}

@Composable
fun Modifier.shadow(type: Elevation): Modifier =
    this.shadow(
        offsetY = type.y.dp,
        color = type.defaultColor(),
        blur = type.blur.dp,
        alpha = type.alpha
    )


@Composable
@MyPreviews
private fun Preview() {
    MyTheme {
        Surface(
            color = MyTheme.colorScheme.backgroundNormal
        ) {
            Row(
                modifier = Modifier.padding(30.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .shadow(type = Elevation.ElevationBlack1)
                        .clip(RoundedCornerShape(12.dp))
                        .background(MyTheme.colorScheme.backgroundNormal)
                )
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .shadow(type = Elevation.ElevationBlack2)
                        .clip(RoundedCornerShape(12.dp))
                        .background(MyTheme.colorScheme.backgroundNormal)
                )
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .shadow(type = Elevation.ElevationBlack3)
                        .clip(RoundedCornerShape(12.dp))
                        .background(MyTheme.colorScheme.backgroundNormal)
                )
            }
        }
    }
}