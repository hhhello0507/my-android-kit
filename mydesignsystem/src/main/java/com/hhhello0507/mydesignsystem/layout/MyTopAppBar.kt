package com.hhhello0507.mydesignsystem.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.hhhello0507.mydesignsystem.foundation.MyTheme
import com.hhhello0507.mydesignsystem.foundation.iconography.IconType
import com.hhhello0507.mydesignsystem.foundation.iconography.MyIcon
import com.hhhello0507.mydesignsystem.internal.MyPreviews
import com.hhhello0507.mydesignsystem.internal.bounceClick

private val paddingValues = PaddingValues(top = 10.dp, start = 15.dp, bottom = 0.dp, end = 15.dp)

enum class TopAppBarType {
    DEFAULT,
    SMALL
}

@Composable
fun MyTopAppBar(
    modifier: Modifier = Modifier,
    title: String,
    type: TopAppBarType = TopAppBarType.DEFAULT,
    backgroundColor: Color = MyTheme.colorScheme.backgroundNeutral,
    onBackPressed: () -> Unit = {},
    trailingContent: @Composable RowScope.() -> Unit = {},
    content: @Composable (PaddingValues) -> Unit
) {
    Column(
        modifier = modifier
            .background(backgroundColor)
            .statusBarsPadding()
    ) {
        // Top app bar
        Row(
            modifier = Modifier
                .height(54.dp)
                .background(backgroundColor)
                .padding(horizontal = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (type == TopAppBarType.SMALL) {
                MyIcon(
                    modifier = Modifier
                        .bounceClick {
                            onBackPressed()
                        }
                        .padding(12.dp)
                        .size(24.dp),
                    type = IconType.EXPAND_ARROW,
                    color = MyTheme.colorScheme.labelNormal
                )
            }
            if (type == TopAppBarType.DEFAULT) {
                Spacer(modifier = Modifier.width(8.dp))
            }
            Text(
                modifier = Modifier,
                text = title,
                style = when (type) {
                    TopAppBarType.DEFAULT -> MyTheme.typography.title1B
                    TopAppBarType.SMALL -> MyTheme.typography.headlineM
                },
                color = MyTheme.colorScheme.labelNormal
            )
            trailingContent()
        }
        Box(
            modifier = Modifier
                .weight(1f)
        ) {
            content(paddingValues)
        }
    }
}

data class TopAppBarButton(
    val icon: IconType,
    val onClick: () -> Unit
)

@Composable
fun MyTopAppBar(
    modifier: Modifier = Modifier,
    title: String,
    type: TopAppBarType = TopAppBarType.DEFAULT,
    backgroundColor: Color = MyTheme.colorScheme.backgroundNeutral,
    onBackPressed: () -> Unit = {},
    buttons: List<TopAppBarButton>,
    content: @Composable (PaddingValues) -> Unit
) {
    MyTopAppBar(
        modifier = modifier,
        title = title,
        type = type,
        backgroundColor = backgroundColor,
        onBackPressed = onBackPressed,
        trailingContent = {
            Spacer(modifier = Modifier.weight(1f))
            buttons.forEach { button ->
                MyIcon(
                    modifier = Modifier
                        .bounceClick(onClick = button.onClick)
                        .padding(12.dp)
                        .size(24.dp)
                        .alpha(0.5f),
                    type = button.icon,
                    color = MyTheme.colorScheme.labelAlternative
                )
            }
        },
        content = content
    )
}

@Composable
@MyPreviews
private fun TopBarPreview() {
    MyTopAppBar(
        title = "히히",
        backgroundColor = MyTheme.colorScheme.backgroundNormal,
        trailingContent = {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "complete")
            }
        }
    ) {
        Text(text = "히히")
    }
}

@Composable
@MyPreviews
private fun TopBarWithBackButtonPreview() {
    MyTopAppBar(
        title = "히히",
        type = TopAppBarType.SMALL,
        backgroundColor = MyTheme.colorScheme.backgroundNormal,
    ) {
        Text(text = "히히")
    }
}