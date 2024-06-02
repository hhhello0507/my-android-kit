package com.bestswlkh0310.mydesignsystem.extension

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.bestswlkh0310.mydesignsystem.foundation.shadow.growShadow

@Composable
fun Modifier.applyCardView() = this
    .clip(RoundedCornerShape(12.dp))
    .growShadow(com.bestswlkh0310.mydesignsystem.foundation.shadow.ShadowType.ElevationBlack1)
    .background(com.bestswlkh0310.mydesignsystem.foundation.GrowTheme.colorScheme.background)
