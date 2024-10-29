package com.hhhello0507.mydesignsystem.layout

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hhhello0507.mydesignsystem.foundation.MyTheme
import com.hhhello0507.mydesignsystem.foundation.iconography.MyIcon
import com.hhhello0507.mydesignsystem.internal.bounceClick

@Composable
fun MyBottomAppBarItem(
    modifier: Modifier = Modifier,
    type: BottomTabItem,
    selected: Boolean,
    onClick: () -> Unit
) {
    val animColor by animateColorAsState(
        targetValue = if (selected) {
            MyTheme.colorScheme.primaryNormal
        } else {
            MyTheme.colorScheme.labelAssistive
        },
        label = "",
    )

    Column(
        modifier = modifier
            .alpha(if (selected) 1f else 0.5f)
            .padding(vertical = 4.dp)
            .bounceClick(onClick = onClick),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyIcon(
            modifier = Modifier
                .size(30.dp),
            id = type.iconType.icon,
            color = animColor
        )
        Text(
            text = type.text,
            style = MyTheme.typography.labelRegular.copy(fontSize = 10.sp),
            color = animColor,
        )
    }
}