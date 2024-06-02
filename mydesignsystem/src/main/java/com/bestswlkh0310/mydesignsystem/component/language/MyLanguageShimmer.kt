package com.bestswlkh0310.mydesignsystem.component.language

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.bestswlkh0310.mydesignsystem.foundation.MyTheme
import com.bestswlkh0310.mydesignsystem.foundation.shimmer.shimmerEffect
import com.bestswlkh0310.mydesignsystem.foundation.util.MyPreviews

@Composable
fun MyLanguageShimmer(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .height(34.dp)
            .width(60.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(shimmerEffect(), RoundedCornerShape(17.dp)),
    )
}

@Composable
@MyPreviews
private fun Preview() {
    MyTheme {
        Column(
            modifier = Modifier
                .background(MyTheme.colorScheme.background)
                .padding(10.dp)
        ) {
            MyLanguage(text = "Swift")
            MyLanguage(text = "Mojo")
            MyLanguageShimmer()
        }
    }
}