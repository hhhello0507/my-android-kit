package com.hhhello0507.mydesignsystem.extension

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.hhhello0507.mydesignsystem.foundation.shadow.myShadow

@Composable
fun Modifier.applyCardView() = this
    .clip(RoundedCornerShape(12.dp))
    .myShadow(com.hhhello0507.mydesignsystem.foundation.shadow.ShadowType.ElevationBlack1)
    .background(com.hhhello0507.mydesignsystem.foundation.MyTheme.colorScheme.background)
