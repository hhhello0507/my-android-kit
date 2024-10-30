package com.hhhello0507.app

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.hhhello0507.mydesignsystem.layout.MyTopAppBar
import com.hhhello0507.mydesignsystem.layout.TopAppBarType

@Composable
fun ButtonScreen(navHostController: NavHostController) {
    MyTopAppBar(
        title = "Button",
        type = TopAppBarType.SMALL,
        onBackPressed = {
            navHostController.popBackStack()
        }
    ) {

    }
}