package com.hhhello0507.app

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.hhhello0507.mydesignsystem.component.divider.MyHorizontalDivider
import com.hhhello0507.mydesignsystem.layout.MyTopAppBar
import com.hhhello0507.mydesignsystem.layout.TopAppBarType

@Composable
fun TextFieldScreen(navHostController: NavHostController) {
    MyTopAppBar(
        title = "TextField",
        type = TopAppBarType.SMALL,
        onBackPressed = {
            navHostController.popBackStack()
        }
    ) {
        Column {
           MyHorizontalDivider()
        }
    }
}