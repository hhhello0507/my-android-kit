package com.bestswlkh0310.mydesignsystem.component.avatar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bestswlkh0310.mydesignsystem.foundation.MyTheme
import com.bestswlkh0310.mydesignsystem.foundation.shimmer.shimmerEffect

@Composable
fun MyAvatarShimmer(
    modifier: Modifier = Modifier,
    type: AvatarType
) {
    Box(
        modifier = modifier
            .size(type.size)
            .background(shimmerEffect(), CircleShape)
    )
}

@Composable
@com.bestswlkh0310.mydesignsystem.foundation.util.MyPreviews
private fun Preview() {
    MyTheme {
        Column(
            modifier = Modifier
                .padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            MyAvatarShimmer(type = AvatarType.Large)
            MyAvatarShimmer(type = AvatarType.Medium)
            MyAvatarShimmer(type = AvatarType.Small)
        }
    }
}