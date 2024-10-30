package com.hhhello0507.mydesignsystem.component.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.hhhello0507.mydesignsystem.component.button.ButtonRole
import com.hhhello0507.mydesignsystem.component.button.MyButton
import com.hhhello0507.mydesignsystem.foundation.MyTheme
import com.hhhello0507.mydesignsystem.foundation.elevation.Elevation
import com.hhhello0507.mydesignsystem.foundation.elevation.shadow
import com.hhhello0507.mydesignsystem.internal.MyPreviews
import com.hhhello0507.mydesignsystem.internal.bounceClick

@Composable
fun MyDialog(
    title: String,
    content: String? = null,
    dismissText: String = "닫기",
    onDismissRequest: () -> Unit
) {
    Dialog(
        onDismissRequest = onDismissRequest,
    ) {
        Column(
            modifier = Modifier
                .shadow(Elevation.ElevationBlack2)
                .background(
                    color = MyTheme.colorScheme.backgroundNormal,
                    shape = RoundedCornerShape(20.dp),
                )
                .padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            Column(
                modifier = Modifier.padding(6.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = title,
                    color = MyTheme.colorScheme.labelStrong,
                    style = MyTheme.typography.heading1B,
                )
                if (content != null) {
                    Text(
                        text = content,
                        color = MyTheme.colorScheme.labelAlternative,
                        style = MyTheme.typography.bodyMedium,
                    )
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    modifier = Modifier
                        .padding(vertical = 10.dp, horizontal = 16.dp)
                        .bounceClick(onClick = onDismissRequest),
                    text = dismissText,
                    style = MyTheme.typography.labelMedium,
                    color = MyTheme.colorScheme.primaryNormal
                )
            }
        }
    }
}

@Composable
fun MyDialog(
    title: String,
    content: String? = null,
    cancelText: String = "닫기",
    successText: String = "확인",
    onSuccessRequest: () -> Unit,
    onCancelRequest: () -> Unit,
    onDismissRequest: () -> Unit
) {
    Dialog(
        onDismissRequest = onDismissRequest,
    ) {
        Column(
            modifier = Modifier
                .shadow(Elevation.ElevationBlack2)
                .background(
                    color = MyTheme.colorScheme.backgroundNormal,
                    shape = RoundedCornerShape(20.dp),
                )
                .padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            Column(
                modifier = Modifier.padding(6.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = title,
                    color = MyTheme.colorScheme.labelStrong,
                    style = MyTheme.typography.heading1B,
                )
                if (content != null) {
                    Text(
                        text = content,
                        color = MyTheme.colorScheme.labelAlternative,
                        style = MyTheme.typography.bodyMedium,
                    )
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                MyButton(
                    modifier = Modifier
                        .weight(1f),
                    text = cancelText,
                    onClick = onCancelRequest,
                    role = ButtonRole.ASSISTIVE
                )
                MyButton(
                    modifier = Modifier
                        .weight(1f),
                    text = successText,
                    onClick = onSuccessRequest,
                )
            }
        }
    }
}

@Composable
@MyPreviews
private fun Preview() {
    var showDialog1 by remember { mutableStateOf(false) }
    var showDialog2 by remember { mutableStateOf(false) }

    MyTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MyTheme.colorScheme.backgroundNormal
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                Button(
                    onClick = {
                        showDialog1 = true
                    }
                ) {
                    Text("Show dialog 1")
                }
                Button(
                    onClick = {
                        showDialog1 = true
                    }
                ) {
                    Text("Show dialog 2")
                }
            }

            if (showDialog1) {
                MyDialog(
                    title = "Title",
                    content = "Content"
                ) {
                    showDialog1 = false
                }
            }

            if (showDialog2) {
                MyDialog(
                    title = "Title",
                    content = "Content",
                    onSuccessRequest = {
                        showDialog2 = false
                    },
                    onCancelRequest = {
                        showDialog2 = false
                    },
                    onDismissRequest = {
                        showDialog2 = false
                    }
                )
            }
        }
    }
}