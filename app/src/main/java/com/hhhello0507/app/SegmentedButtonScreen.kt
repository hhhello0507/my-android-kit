package com.hhhello0507.app

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.hhhello0507.mydesignsystem.component.button.MySegmentedButton
import com.hhhello0507.mydesignsystem.layout.MyTopAppBar
import com.hhhello0507.mydesignsystem.layout.TopAppBarType

@Composable
fun SegmentedButtonScreen(navHostController: NavHostController) {
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    MyTopAppBar(
        title = "SegmentedButton",
        type = TopAppBarType.SMALL,
        onBackPressed = {
            navHostController.safePopBackStack()
        }
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .padding(top = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MySegmentedButton(
                selected = selectedTabIndex,
                onChange = {
                    selectedTabIndex = it
                },
                buttons = listOf("선생님", "학생")
            )
        }
    }
}