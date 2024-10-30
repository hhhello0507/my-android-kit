package com.hhhello0507.mydesignsystem.component.button

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.hhhello0507.mydesignsystem.R
import com.hhhello0507.mydesignsystem.foundation.MyTheme
import com.hhhello0507.mydesignsystem.internal.MyPreviews
import com.hhhello0507.mydesignsystem.internal.bounceAnimation

@Composable
fun GoogleSignInButton(
    text: String = "Google로 계속하기",
    textStyle: TextStyle? = null,
    size: ButtonSize = ButtonSize.Larger,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    isLoading: Boolean = false,
    isRounded: Boolean = false,
    expanded: Boolean = false,
    shape: Shape? = null,
    colors: ButtonColors? = null,
    contentPadding: PaddingValues? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onClick: () -> Unit,
) {
    val mergedEnabled = isEnabled && !isLoading
    val mergedColors = colors ?: ButtonColors(
        containerColor = MyTheme.colorScheme.white,
        contentColor = MyTheme.colorScheme.black,
        disabledContainerColor = MyTheme.colorScheme.white,
        disabledContentColor = MyTheme.colorScheme.black
    )
    val mergedShape =
        shape ?: RoundedCornerShape(if (isRounded) size.height / 2 else size.cornerRadius)
    val mergedContentSize = contentPadding ?: size.contentPadding
    val mergedTextStyle = (textStyle ?: size.textStyle)
        .copy(fontWeight = FontWeight.Medium)

    Button(
        onClick = {
            if (mergedEnabled) {
                onClick()
            }
        },
        modifier = modifier
            .then(if (expanded) Modifier.fillMaxWidth() else Modifier)
            .alpha(if (mergedEnabled) 1f else 0.5f)
            .height(size.height)
            .border(1.5.dp, color = Color(0xFFE6E6E6), shape = mergedShape)
            .bounceAnimation(enabled = mergedEnabled),
        colors = mergedColors,
        enabled = mergedEnabled,
        shape = mergedShape,
        contentPadding = mergedContentSize,
        interactionSource = interactionSource,
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier
                    .alpha(if (isLoading) 0f else 1f),
                horizontalArrangement = Arrangement.spacedBy(size.spacing),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .size(20.dp),
                    painter = painterResource(R.drawable.ic_google_logo),
                    contentDescription = null
                )
                Text(
                    text = text,
                    style = mergedTextStyle
                )
            }
            if (isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.size(18.dp),
                    strokeWidth = 1.5.dp,
                    color = LocalContentColor.current
                )
            }
        }
    }
}

@Composable
@MyPreviews
private fun Preview() {
    MyTheme {
        Surface(
            color = MyTheme.colorScheme.backgroundNormal
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                GoogleSignInButton { }
                GoogleSignInButton(
                    isEnabled = false
                ) { }
                GoogleSignInButton(
                    isRounded = true
                ) { }
                GoogleSignInButton(
                    isLoading = true
                ) { }
                GoogleSignInButton(
                    expanded = true
                ) { }
            }
        }
    }
}