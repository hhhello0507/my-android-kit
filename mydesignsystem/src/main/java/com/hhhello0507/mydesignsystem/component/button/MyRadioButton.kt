package com.hhhello0507.mydesignsystem.component.button

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.hhhello0507.mydesignsystem.foundation.MyTheme
import com.hhhello0507.mydesignsystem.internal.MyPreviews

@Composable
fun MyRadioButton(
    selected: Boolean,
    onClick: (() -> Unit)?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: RadioButtonColors = RadioButtonColors(
        selectedColor = MyTheme.colorScheme.primaryNormal,
        unselectedColor = MyTheme.colorScheme.lineNormal,
        disabledSelectedColor = MyTheme.colorScheme.primaryNormal.copy(alpha = 0.5f),
        disabledUnselectedColor = MyTheme.colorScheme.lineNormal.copy(alpha = 0.5f)
    ),
    interactionSource: MutableInteractionSource? = null
) {
    RadioButton(
        selected = selected,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = colors,
        interactionSource = interactionSource
    )
}

@Composable
@MyPreviews
private fun Preview() {
    MyTheme {
        Surface(
            color = MyTheme.colorScheme.backgroundNormal
        ) {
            Column {
                MyRadioButton(
                    selected = true,
                    onClick = {}
                )
                MyRadioButton(
                    selected = false,
                    onClick = {}
                )
                MyRadioButton(
                    selected = true,
                    enabled = false,
                    onClick = {}
                )
                MyRadioButton(
                    selected = false,
                    enabled = false,
                    onClick = {}
                )
            }
        }
    }
}