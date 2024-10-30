package com.hhhello0507.mydesignsystem.component.button

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp
import com.hhhello0507.mydesignsystem.foundation.MyTheme
import com.hhhello0507.mydesignsystem.foundation.elevation.Elevation
import com.hhhello0507.mydesignsystem.foundation.elevation.shadow
import com.hhhello0507.mydesignsystem.internal.MyPreviews

@Composable
fun MySwitch(
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit)?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: SwitchColors = SwitchColors(
        checkedThumbColor = MyTheme.colorScheme.white,
        checkedTrackColor = MyTheme.colorScheme.primaryNormal,
        checkedBorderColor = MyTheme.colorScheme.clear,
        checkedIconColor = MyTheme.colorScheme.clear,
        uncheckedThumbColor = MyTheme.colorScheme.white,
        uncheckedTrackColor = MyTheme.colorScheme.fillAlternative,
        uncheckedBorderColor = MyTheme.colorScheme.clear,
        uncheckedIconColor = MyTheme.colorScheme.clear,
        disabledCheckedThumbColor = MyTheme.colorScheme.white.copy(alpha = 0.5f),
        disabledCheckedTrackColor = MyTheme.colorScheme.primaryNormal.copy(alpha = 0.5f),
        disabledCheckedBorderColor = MyTheme.colorScheme.clear,
        disabledCheckedIconColor = MyTheme.colorScheme.clear,
        disabledUncheckedThumbColor = MyTheme.colorScheme.white.copy(alpha = 0.5f),
        disabledUncheckedTrackColor = MyTheme.colorScheme.fillAlternative.copy(alpha = 0.5f),
        disabledUncheckedBorderColor = MyTheme.colorScheme.clear,
        disabledUncheckedIconColor = MyTheme.colorScheme.clear
    ),
    interactionSource: MutableInteractionSource? = null,
) {
    Switch(
        checked = checked,
        onCheckedChange = onCheckedChange,
        modifier = modifier,
        enabled = enabled,
        colors = colors,
        thumbContent = {
            Box(
                modifier = Modifier
                    .size(27.dp)
                    .scale(1.15f)
                    .background(
                        // white 고정
                        color = MyTheme.colorScheme.white,
                        shape = CircleShape,
                    )
                    .shadow(Elevation.ElevationBlack1),
            )
        },
        interactionSource = interactionSource
    )
}

@Composable
@MyPreviews
private fun Preview() {
    MyTheme {
        Column(
            modifier = Modifier
                .background(MyTheme.colorScheme.backgroundNormal)
                .padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            MySwitch(checked = true, onCheckedChange = {})
            MySwitch(checked = false, onCheckedChange = {})
            MySwitch(checked = true, onCheckedChange = {}, enabled = false)
            MySwitch(checked = false, onCheckedChange = {}, enabled = false)
        }
    }
}