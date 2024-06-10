package com.bestswlkh0310.mydesignsystem.component.button

import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.bestswlkh0310.mydesignsystem.foundation.MyTheme
import com.bestswlkh0310.mydesignsystem.foundation.shadow.ShadowType
import com.bestswlkh0310.mydesignsystem.foundation.shadow.myShadow
import com.bestswlkh0310.mydesignsystem.foundation.util.MyPreviews


@Composable
fun MyToggle(
    modifier: Modifier = Modifier,
    checked: Boolean,
    colors: SwitchColors = SwitchDefaults.colors(
        checkedThumbColor = MyTheme.colorScheme.background,
        checkedTrackColor = MyTheme.colorScheme.buttonPrimary,
        uncheckedThumbColor = MyTheme.colorScheme.background,
        uncheckedTrackColor = MyTheme.colorScheme.buttonTextDisabled,
        uncheckedBorderColor = Color.Transparent
    ),
    onCheckedChange: (Boolean) -> Unit
) {
    Switch(
        checked = checked,
        onCheckedChange = onCheckedChange,
        colors = colors,
        modifier = modifier
            .height(31.dp)
            .width(51.dp),
        thumbContent = {
            Box(
                modifier = Modifier
                    .size(27.dp)
                    .background(
                        color = Color.White,
                        shape = CircleShape,
                    )
                    .myShadow(ShadowType.ElevationBlack1),
            )
        },
    )
}

@Composable
@MyPreviews
private fun Preview() {
    MyTheme {
        Column(
            modifier = Modifier
                .background(MyTheme.colorScheme.background)
                .padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            MyToggle(checked = true) {}
            MyToggle(checked = false) {}
        }
    }
}