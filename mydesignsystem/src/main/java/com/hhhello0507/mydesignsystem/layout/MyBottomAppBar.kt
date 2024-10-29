package com.hhhello0507.mydesignsystem.layout

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import com.hhhello0507.mydesignsystem.foundation.MyTheme
import com.hhhello0507.mydesignsystem.foundation.iconography.IconType
import com.hhhello0507.mydesignsystem.internal.MyPreviews

data class BottomTabItem(
    val iconType: IconType,
    val text: String,
    val content: @Composable () -> Unit
)

@Composable
fun MyBottomAppBar(
    selected: Int,
    onClick: (Int) -> Unit,
    tabs: List<BottomTabItem>
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        tabs.forEachIndexed { index, tab ->
            if (index == selected) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                ) {
                    tab.content()
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MyTheme.colorScheme.backgroundNormal)
                .border(
                    border = BorderStroke(
                        width = 1.dp,
                        color = MyTheme.colorScheme.lineAlternative
                    )
                )
                .padding(vertical = 4.dp)
                .navigationBarsPadding()
        ) {
            tabs.forEachIndexed { index, tab ->
                MyBottomAppBarItem(
                    modifier = Modifier
                        .weight(1f),
                    type = tab,
                    selected = selected == index
                ) {
                    onClick(index)
                }
            }
        }
    }
}

@Composable
@MyPreviews
private fun Preview() {
    var selectedItem by remember { mutableIntStateOf(0) }
    MyTheme {
        MyBottomAppBar(
            selected = selectedItem,
            onClick = { selectedItem = it },
            tabs = listOf(
                BottomTabItem(
                    iconType = IconType.PING,
                    text = "Ping"
                ) {
                    Text(text = "Home")
                },
                BottomTabItem(
                    iconType = IconType.HOME,
                    text = "홈"
                ) {
                    Text(text = "홈")
                }
            )
        )
    }
}
