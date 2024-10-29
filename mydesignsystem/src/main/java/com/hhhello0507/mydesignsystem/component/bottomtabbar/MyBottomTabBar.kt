package com.hhhello0507.mydesignsystem.component.bottomtabbar

import androidx.annotation.DrawableRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hhhello0507.mydesignsystem.R
import com.hhhello0507.mydesignsystem.internal.bounceClick
import com.hhhello0507.mydesignsystem.foundation.MyTheme
import com.hhhello0507.mydesignsystem.foundation.iconography.MyIcon
import com.hhhello0507.mydesignsystem.internal.MyPreviews

abstract class BottomTabItem(
    @DrawableRes val resId: Int,
    val text: String
)

@Composable
fun MyBottomTabBar(
    modifier: Modifier = Modifier,
    bottomTabList: List<BottomTabItem>,
    selected: BottomTabItem,
    onClick: (BottomTabItem) -> Unit
) {
    val shape = RoundedCornerShape(
        topStart = 16.dp,
        topEnd = 16.dp,
    )
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = MyTheme.colorScheme.backgroundNormal,
                shape = shape,
            )
            .border(
                border = BorderStroke(
                    width = 1.dp,
                    color = MyTheme.colorScheme.lineAlternative
                ),
                shape = shape
            )
            .padding(8.dp)
            .navigationBarsPadding()
    ) {
        bottomTabList.forEach {
            MyBottomTabItem(
                modifier = Modifier
                    .weight(1f),
                type = it,
                selected = selected == it
            ) {
                onClick(it)
            }
        }
    }
}

@Composable
private fun MyBottomTabItem(
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
            .padding(vertical = 4.dp)
            .bounceClick(onClick = onClick),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        MyIcon(
            modifier = Modifier
                .size(26.dp),
            id = type.resId,
            color = animColor
        )
        Text(
            text = type.text,
            style = MyTheme.typography.labelRegular.copy(fontSize = 10.sp),
            color = animColor,
        )
    }
}

private data object Home: BottomTabItem(R.drawable.ic_home, "홈")
private data object Github: BottomTabItem(R.drawable.ic_home, "Github")
private data object Profile: BottomTabItem(R.drawable.ic_home, "프로필")

private val items = listOf(Home, Github, Profile)

@Composable
@MyPreviews
private fun Preview() {
    var selectedItem: BottomTabItem by remember { mutableStateOf(Home) }
    MyTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MyTheme.colorScheme.backgroundNormal),
        ) {
            Spacer(modifier = Modifier.weight(1f))
            MyBottomTabBar(
                modifier = Modifier,
                bottomTabList = items,
                selected = selectedItem,
                onClick = {
                    selectedItem = it
                },
            )
        }
    }
}