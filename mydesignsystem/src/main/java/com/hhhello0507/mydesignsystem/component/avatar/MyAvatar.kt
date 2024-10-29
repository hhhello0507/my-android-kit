package com.hhhello0507.mydesignsystem.component.avatar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.compose.AsyncImagePainter
import com.hhhello0507.mydesignsystem.foundation.MyTheme
import com.hhhello0507.mydesignsystem.foundation.iconography.MyIcon
import com.hhhello0507.mydesignsystem.internal.MyPreviews
import com.hhhello0507.mydesignsystem.foundation.iconography.IconType

sealed class AvatarSize(
    val size: Dp
) {
    data object Smaller : AvatarSize(size = 20.dp)
    data object Small : AvatarSize(size = 28.dp)
    data object Medium : AvatarSize(size = 32.dp)
    data object Large : AvatarSize(size = 42.dp)
    data object Larger : AvatarSize(size = 64.dp)
}

@Composable
fun MyAvatar(
    modifier: Modifier = Modifier,
    imageUrl: String? = null,
    size: AvatarSize
) {
    val mergedModifier = modifier.wrapContentSize()
    var showEmptyImage by remember { mutableStateOf(false) }

    if (imageUrl == null || showEmptyImage) {
        Box(
            modifier = mergedModifier
                .size(size.size)
                .clip(CircleShape)
                .background(MyTheme.colorScheme.fillAlternative),
            contentAlignment = Alignment.Center,
        ) {
            MyIcon(
                modifier = Modifier
                    .size(size.size)
                    .offset(y = size.size / 6),
                type = IconType.PERSON,
                color = MyTheme.colorScheme.fillAssistive
            )
        }
    } else {
        AsyncImage(
            modifier = mergedModifier
                .size(size.size)
                .clip(CircleShape),
            model = imageUrl,
            contentDescription = "",
            contentScale = ContentScale.Crop,
            onState = { state ->
                when (state) {
                    AsyncImagePainter.State.Empty -> showEmptyImage = true
                    is AsyncImagePainter.State.Error -> showEmptyImage = true
                    else -> {}
                }
            }
        )
    }
}

@Composable
@MyPreviews
private fun Preview() {
    val sizeList = listOf(
        AvatarSize.Larger,
        AvatarSize.Large,
        AvatarSize.Medium,
        AvatarSize.Small,
        AvatarSize.Smaller
    )

    MyTheme {
        Surface(
            color = MyTheme.colorScheme.backgroundNormal
        ) {
            Column {
                sizeList.forEach { size ->
                    MyAvatar(size = size)
                }
            }
        }
    }
}