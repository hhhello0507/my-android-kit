package com.hhhello0507.mydesignsystem.foundation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import com.hhhello0507.mydesignsystem.foundation.color.MyColorScheme
import com.hhhello0507.mydesignsystem.foundation.color.LocalMyColorScheme
import com.hhhello0507.mydesignsystem.foundation.typography.MyTypography
import com.hhhello0507.mydesignsystem.foundation.typography.LocalMyTypography

object MyTheme {
    val colorScheme: MyColorScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalMyColorScheme.current

    val typography: MyTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalMyTypography.current
}