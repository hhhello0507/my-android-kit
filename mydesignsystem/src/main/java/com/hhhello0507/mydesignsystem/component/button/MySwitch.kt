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
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hhhello0507.mydesignsystem.foundation.MyTheme
import com.hhhello0507.mydesignsystem.foundation.elevation.Elevation
import com.hhhello0507.mydesignsystem.foundation.elevation.shadow
import com.hhhello0507.mydesignsystem.internal.MyPreviews

@Composable
fun MySwitch(
    modifier: Modifier = Modifier,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    interactionSource: MutableInteractionSource? = null,
) {
    Switch(
        checked = checked,
        onCheckedChange = onCheckedChange,
        colors = SwitchDefaults.colors(
            checkedThumbColor = MyTheme.colorScheme.white,
            checkedTrackColor = MyTheme.colorScheme.primaryNormal,
            uncheckedThumbColor = MyTheme.colorScheme.white,
            uncheckedTrackColor = MyTheme.colorScheme.fillAlternative,
            uncheckedBorderColor = MyTheme.colorScheme.clear
        ),
        modifier = modifier
            .height(31.dp)
            .width(51.dp),
        thumbContent = {
            Box(
                modifier = Modifier
                    .size(27.dp)
                    .background(
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
        }
    }
}