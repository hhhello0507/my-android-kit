package com.hhhello0507.mydesignsystem.component.button

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import com.hhhello0507.mydesignsystem.extension.ButtonState

@Composable
fun MyTextButton(
    modifier: Modifier = Modifier,
    text: String,
    type: ButtonType,
    enabled: Boolean = true,
    isLoading: Boolean = false,
    @DrawableRes leftIcon: Int? = null,
    @DrawableRes rightIcon: Int? = null,
    shape: Shape? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onClick: () -> Unit,
) {
    val isEnabled = enabled && !isLoading

    var buttonState by remember { mutableStateOf(ButtonState.Idle) }
    val scale by animateFloatAsState(
        targetValue = if (buttonState == ButtonState.Idle) 1f else 0.96f,
        label = "",
    )

    val colors = ButtonDefaults.buttonColors(
        containerColor = Color.Transparent,
        contentColor = com.hhhello0507.mydesignsystem.foundation.MyTheme.colorScheme.buttonPrimary,
        disabledContainerColor = Color.Transparent,
        disabledContentColor = com.hhhello0507.mydesignsystem.foundation.MyTheme.colorScheme.buttonTextDisabled,
    )

    Button(
        onClick = onClick,
        modifier = modifier
            .graphicsLayer {
                scaleX = scale
                scaleY = scale
            }
            .pointerInput(buttonState) {
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
        colors = colors,
        enabled = isEnabled,
        shape = shape ?: type.shape,
        contentPadding = type.contentPadding,
        interactionSource = interactionSource,
    ) {
//            if (isLoading) {
//                RiveAnimation(
//                    resId = R.raw.loading_dots,
//                    contentDescription = "loading gif",
//                    autoplay = true,
//                    animationName = type.animName,
//                )
//            } else {

        Row(
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val textColor = if (enabled) {
                com.hhhello0507.mydesignsystem.foundation.MyTheme.colorScheme.buttonPrimary
            } else {
                com.hhhello0507.mydesignsystem.foundation.MyTheme.colorScheme.buttonTextDisabled
            }
            leftIcon?.let {
                com.hhhello0507.mydesignsystem.foundation.iconography.MyIcon(
                    modifier = Modifier
                        .size(20.dp),
                    id = it,
                    color = textColor
                )
            }
            Text(
                text = text,
                style = com.hhhello0507.mydesignsystem.foundation.MyTheme.typography.bodyBold,
                color = textColor
            )
            rightIcon?.let {
                com.hhhello0507.mydesignsystem.foundation.iconography.MyIcon(
                    modifier = Modifier
                        .size(20.dp),
                    id = it,
                    color = textColor
                )
            }
        }
//            }
    }
}
