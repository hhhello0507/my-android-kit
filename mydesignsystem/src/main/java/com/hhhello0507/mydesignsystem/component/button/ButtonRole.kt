package com.hhhello0507.mydesignsystem.component.button

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.hhhello0507.mydesignsystem.foundation.MyTheme

enum class ButtonRole {
    PRIMARY,
    SECONDARY,
    ASSISTIVE,
    TEXT;
}

data class MyButtonColors(
    val contentColor: Color,
    val containerColor: Color,
    val strokeContentColor: Color,
    val strokeColor: Color
) {
    companion object {
        @Composable
        fun colors(role: ButtonRole) = when (role) {
            ButtonRole.PRIMARY -> MyButtonColors(
                contentColor = MyTheme.colorScheme.white,
                containerColor = MyTheme.colorScheme.primaryNormal,
                strokeContentColor = MyTheme.colorScheme.primaryNormal,
                strokeColor = MyTheme.colorScheme.primaryNormal
            )
            ButtonRole.SECONDARY -> MyButtonColors(
                contentColor = MyTheme.colorScheme.primaryNormal,
                containerColor = MyTheme.colorScheme.primaryAssistive,
                strokeContentColor = MyTheme.colorScheme.primaryNormal,
                strokeColor = MyTheme.colorScheme.primaryAssistive,
            )
            ButtonRole.ASSISTIVE -> MyButtonColors(
                contentColor = MyTheme.colorScheme.labelNeutral,
                containerColor = MyTheme.colorScheme.fillNeutral,
                strokeContentColor = MyTheme.colorScheme.labelNeutral,
                strokeColor = MyTheme.colorScheme.fillNeutral
            )
            ButtonRole.TEXT -> MyButtonColors(
                contentColor = MyTheme.colorScheme.labelNormal,
                containerColor = MyTheme.colorScheme.clear,
                strokeContentColor = MyTheme.colorScheme.clear,
                strokeColor = MyTheme.colorScheme.clear
            )
        }
    }
}