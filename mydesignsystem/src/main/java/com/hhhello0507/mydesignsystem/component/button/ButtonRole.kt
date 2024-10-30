package com.hhhello0507.mydesignsystem.component.button

import androidx.compose.material3.ButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.hhhello0507.mydesignsystem.foundation.MyTheme

enum class ButtonRole {
    PRIMARY,
    SECONDARY,
    ASSISTIVE,
    TEXT;

    @Composable
    fun colors(): ButtonColors = when (this) {
        PRIMARY -> ButtonColors(
            containerColor = MyTheme.colorScheme.primaryNormal,
            contentColor = MyTheme.colorScheme.white,
            disabledContainerColor = MyTheme.colorScheme.primaryNormal,
            disabledContentColor = MyTheme.colorScheme.white
        )
        SECONDARY -> ButtonColors(
            containerColor = MyTheme.colorScheme.primaryAssistive,
            contentColor = MyTheme.colorScheme.primaryNormal,
            disabledContainerColor = MyTheme.colorScheme.primaryAssistive,
            disabledContentColor = MyTheme.colorScheme.primaryNormal
        )
        ASSISTIVE -> ButtonColors(
            containerColor = MyTheme.colorScheme.fillNeutral,
            contentColor = MyTheme.colorScheme.labelNeutral,
            disabledContainerColor = MyTheme.colorScheme.fillNeutral,
            disabledContentColor = MyTheme.colorScheme.labelNeutral
        )
        TEXT -> ButtonColors(
            containerColor = MyTheme.colorScheme.clear,
            contentColor = MyTheme.colorScheme.labelNormal,
            disabledContainerColor = MyTheme.colorScheme.clear,
            disabledContentColor = MyTheme.colorScheme.labelNormal
        )
    }

    @Composable
    fun strokeColors(): ButtonStrokeColors = when (this) {
        PRIMARY -> ButtonStrokeColors(
            strokeContentColor = MyTheme.colorScheme.primaryNormal,
            strokeColor = MyTheme.colorScheme.primaryNormal
        )
        SECONDARY -> ButtonStrokeColors(
            strokeContentColor = MyTheme.colorScheme.primaryNormal,
            strokeColor = MyTheme.colorScheme.primaryAssistive,
        )
        ASSISTIVE -> ButtonStrokeColors(
            strokeContentColor = MyTheme.colorScheme.labelNeutral,
            strokeColor = MyTheme.colorScheme.fillNeutral
        )
        TEXT -> ButtonStrokeColors(
            strokeContentColor = MyTheme.colorScheme.labelNormal,
            strokeColor = MyTheme.colorScheme.clear
        )
    }
}

data class ButtonStrokeColors(
    val strokeContentColor: Color,
    val strokeColor: Color
)