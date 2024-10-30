package com.hhhello0507.app

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.hhhello0507.mydesignsystem.foundation.MyTheme

@Composable
fun Headline(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = MyTheme.typography.headlineM,
    contentPadding: PaddingValues = PaddingValues(top = 16.dp, bottom = 8.dp, start = 4.dp)
) {
    Row(
        modifier = modifier
            .padding(contentPadding)
    ) {
        Text(
            text = text,
            style = style
        )
        Spacer(Modifier.weight(1f))
    }
}