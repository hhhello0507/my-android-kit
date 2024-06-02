package com.bestswlkh0310.mydesignsystem.foundation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import com.bestswlkh0310.mydesignsystem.foundation.color.MyColorScheme
import com.bestswlkh0310.mydesignsystem.foundation.color.LocalMyColorScheme
import com.bestswlkh0310.mydesignsystem.foundation.typography.MyTypography
import com.bestswlkh0310.mydesignsystem.foundation.typography.LocalMyTypography

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