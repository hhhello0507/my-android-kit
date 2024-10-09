package com.hhhello0507.mydesignsystem.component.topappbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.hhhello0507.mydesignsystem.R
import com.hhhello0507.mydesignsystem.extension.bounceClick
import com.hhhello0507.mydesignsystem.foundation.MyTheme
import com.hhhello0507.mydesignsystem.foundation.iconography.MyIcon
import com.hhhello0507.mydesignsystem.foundation.util.MyPreviews

@Composable
fun MyTopAppBar(
    modifier: Modifier = Modifier,
    text: String,
    backgroundColor: Color = MyTheme.colorScheme.background,
    onClickBackButton: (() -> Unit)? = null,
    trailingContent: (@Composable () -> Unit)? = null,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = modifier
            .background(backgroundColor)
            .safeDrawingPadding()
    ) {
        Row(
            modifier = Modifier
                .height(54.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier
                    .padding(start = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                onClickBackButton?.let {
                    MyIcon(
                        modifier = Modifier
                            .size(28.dp)
                            .padding(2.dp)
                            .bounceClick(onClick = it),
                        id = R.drawable.ic_expand_left,
                        color = MyTheme.colorScheme.textNormal
                    )
                }
                val textStyle =
                    if (onClickBackButton == null) MyTheme.typography.title2B
                    else MyTheme.typography.headline2M
                Text(
                    modifier = Modifier
                        .padding(start = 8.dp),
                    text = text,
                    style = textStyle,
                    color = MyTheme.colorScheme.textNormal
                )
            }

            Spacer(modifier = Modifier.weight(1f))
            Box(
                modifier = Modifier
                    .padding(end = 4.dp)
            ) {
                trailingContent?.let { content ->
                    content()
                }
            }
        }
        content()
    }
}

@Composable
@MyPreviews
private fun TopBarPreview() {
    MyTopAppBar(
        text = "히히",
        backgroundColor = MyTheme.colorScheme.backgroundAlt,
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
        text = "히히",
        backgroundColor = MyTheme.colorScheme.backgroundAlt,
        onClickBackButton = {

        },
    ) {
        Text(text = "히히")
    }
}