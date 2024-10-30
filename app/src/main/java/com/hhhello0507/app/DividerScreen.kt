package com.hhhello0507.app

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.hhhello0507.mydesignsystem.component.divider.MyHorizontalDivider
import com.hhhello0507.mydesignsystem.layout.MyTopAppBar
import com.hhhello0507.mydesignsystem.layout.TopAppBarType

@Composable
fun DividerScreen(navHostController: NavHostController) {
    MyTopAppBar(
        title = "Divider",
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