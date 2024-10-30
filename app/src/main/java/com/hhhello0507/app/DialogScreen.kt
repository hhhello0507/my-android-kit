package com.hhhello0507.app

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.hhhello0507.mydesignsystem.component.dialog.MyDialog
import com.hhhello0507.mydesignsystem.layout.MyTopAppBar
import com.hhhello0507.mydesignsystem.layout.TopAppBarType

@Composable
fun DialogScreen(navHostController: NavHostController) {
    var showDialog1 by remember { mutableStateOf(false) }
    var showDialog2 by remember { mutableStateOf(false) }

    MyTopAppBar(
        title = "Dialog",
        type = TopAppBarType.SMALL,
        onBackPressed = {
            navHostController.popBackStack()
        }
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
                    showDialog2 = true
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