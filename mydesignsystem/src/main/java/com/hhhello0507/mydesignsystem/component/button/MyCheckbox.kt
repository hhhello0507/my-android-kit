package com.hhhello0507.mydesignsystem.component.button

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.hhhello0507.mydesignsystem.foundation.MyTheme
import com.hhhello0507.mydesignsystem.internal.MyPreviews

@Composable
fun MyCheckbox(
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit)?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: CheckboxColors = CheckboxDefaults.colors(
        checkedColor = MyTheme.colorScheme.primaryNormal,
        uncheckedColor = MyTheme.colorScheme.lineNormal,
        checkmarkColor = MyTheme.colorScheme.white,
        disabledCheckedColor = MyTheme.colorScheme.primaryNormal.copy(alpha = 0.5f),
        disabledUncheckedColor = MyTheme.colorScheme.lineNormal.copy(alpha = 0.5f),
        disabledIndeterminateColor = MyTheme.colorScheme.white.copy(alpha = 0.5f),
    ),
    interactionSource: MutableInteractionSource? = null
) {
    Checkbox(
        checked = checked,
        onCheckedChange = onCheckedChange,
        modifier = modifier,
        enabled = enabled,
        colors = colors,
        interactionSource = interactionSource
    )
}

@MyPreviews
@Composable
private fun Preview() {
    MyTheme {
        Surface(
            color = MyTheme.colorScheme.backgroundNormal
        ) {
            Column {
                MyCheckbox(checked = true, onCheckedChange = {})
                MyCheckbox(checked = false, onCheckedChange = {})
                MyCheckbox(checked = true, onCheckedChange = {}, enabled = false)
                MyCheckbox(checked = false, onCheckedChange = {}, enabled = false)
            }
        }
    }
}