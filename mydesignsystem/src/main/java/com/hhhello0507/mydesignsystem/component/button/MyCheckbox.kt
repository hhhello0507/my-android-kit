package com.hhhello0507.mydesignsystem.component.button

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.hhhello0507.mydesignsystem.foundation.MyTheme
import com.hhhello0507.mydesignsystem.internal.MyPreviews

@Composable
fun MyCheckbox(
    modifier: Modifier = Modifier,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    interactionSource: MutableInteractionSource? = null
) {
    Checkbox(
        modifier = modifier,
        checked = checked,
        onCheckedChange = onCheckedChange,
        colors = CheckboxDefaults.colors(
            checkedColor = MyTheme.colorScheme.primaryNormal,
            uncheckedColor = MyTheme.colorScheme.lineNormal,
            checkmarkColor = MyTheme.colorScheme.white,
            disabledCheckedColor = MyTheme.colorScheme.clear,
            disabledUncheckedColor = MyTheme.colorScheme.clear,
            disabledIndeterminateColor = MyTheme.colorScheme.clear,
        ),
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
            }
        }
    }
}