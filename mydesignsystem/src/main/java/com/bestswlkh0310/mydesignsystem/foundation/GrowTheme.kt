package com.bestswlkh0310.mydesignsystem.foundation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import com.bestswlkh0310.mydesignsystem.foundation.color.GrowColorScheme
import com.bestswlkh0310.mydesignsystem.foundation.color.LocalGrowColorScheme
import com.bestswlkh0310.mydesignsystem.foundation.typography.GrowTypography
import com.bestswlkh0310.mydesignsystem.foundation.typography.LocalGrowTypography

object GrowTheme {
    val colorScheme: GrowColorScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalGrowColorScheme.current

    val typography: GrowTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalGrowTypography.current
}