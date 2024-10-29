package com.hhhello0507.mydesignsystem.component.button

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.hhhello0507.mydesignsystem.foundation.MyTheme
import com.hhhello0507.mydesignsystem.foundation.iconography.IconType
import com.hhhello0507.mydesignsystem.foundation.iconography.MyIcon
import com.hhhello0507.mydesignsystem.internal.ButtonState
import com.hhhello0507.mydesignsystem.internal.MyPreviews

@Composable
fun MyButton(
    modifier: Modifier = Modifier,
    text: String,
    size: ButtonSize,
    role: ButtonRole = ButtonRole.PRIMARY,
    textStyle: TextStyle? = null,
    shape: Shape? = null,
    contentPadding: PaddingValues? = null,
    startIcon: IconType? = null,
    endIcon: IconType? = null,
    isEnabled: Boolean = true,
    isLoading: Boolean = false,
    isRounded: Boolean = false,
    expanded: Boolean = false,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onClick: () -> Unit,
) {
    val mergedEnabled = isEnabled && !isLoading

    var buttonState by remember { mutableStateOf(ButtonState.Idle) }

    val scale by animateFloatAsState(
        targetValue = if (buttonState == ButtonState.Idle) 1f else 0.96f,
        label = "",
    )
    val colors = MyButtonColors.colors(role)

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
            .graphicsLayer {
                scaleX = scale
                scaleY = scale
            }
            .pointerInput(buttonState) {
                if (!mergedEnabled) return@pointerInput
                awaitPointerEventScope {
                    buttonState = if (buttonState == ButtonState.Hold) {
                        waitForUpOrCancellation()
                        ButtonState.Idle
                    } else {
                        awaitFirstDown(false)
                        ButtonState.Hold
                    }
                }
            },
        colors = ButtonColors(
            containerColor = colors.containerColor,
            contentColor = colors.contentColor,
            disabledContainerColor = colors.containerColor,
            disabledContentColor = colors.contentColor
        ),
        enabled = mergedEnabled,
        shape = shape ?: if (isRounded) RoundedCornerShape(size.height / 2) else RoundedCornerShape(
            size.cornerRadius
        ),
        contentPadding = contentPadding ?: size.contentPadding,
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
                if (startIcon != null) {
                    MyIcon(
                        modifier = Modifier
                            .size(size.iconSize),
                        type = startIcon
                    )
                }
                Text(
                    text = text,
                    style = textStyle ?: size.textStyle
                )
                if (endIcon != null) {
                    MyIcon(
                        modifier = Modifier
                            .size(size.iconSize),
                        type = endIcon
                    )
                }
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
            LazyColumn(
                modifier = Modifier.padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                items(
                    listOf(
                        ButtonRole.PRIMARY,
                        ButtonRole.SECONDARY,
                        ButtonRole.ASSISTIVE,
                        ButtonRole.TEXT
                    )
                ) { role ->
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(
                            listOf(
                                ButtonSize.Larger,
                                ButtonSize.Large,
                                ButtonSize.Medium,
                                ButtonSize.Small
                            )
                        ) { size ->

                            Column(
                                verticalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                MyButton(
                                    text = "button",
                                    role = role,
                                    size = size,
                                    startIcon = IconType.ADD_LINE,
                                    endIcon = IconType.ADD_LINE
                                ) { }

                                MyButton(
                                    text = "button",
                                    role = role,
                                    size = size,
                                    startIcon = IconType.ADD_LINE,
                                    endIcon = IconType.ADD_LINE,
                                    isRounded = true
                                ) { }

                                MyButton(
                                    text = "button",
                                    role = role,
                                    size = size,
                                    startIcon = IconType.ADD_LINE,
                                    endIcon = IconType.ADD_LINE,
                                    isEnabled = false
                                ) { }

                                MyButton(
                                    text = "button",
                                    role = role,
                                    size = size,
                                    startIcon = IconType.ADD_LINE,
                                    endIcon = IconType.ADD_LINE,
                                    isLoading = true
                                ) { }
                            }
                        }
                    }
                }
            }
        }
    }
}