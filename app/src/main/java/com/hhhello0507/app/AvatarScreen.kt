package com.hhhello0507.app

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.hhhello0507.mydesignsystem.component.avatar.AvatarSize
import com.hhhello0507.mydesignsystem.component.avatar.MyAvatar
import com.hhhello0507.mydesignsystem.layout.MyTopAppBar
import com.hhhello0507.mydesignsystem.layout.TopAppBarType

@Composable
fun AvatarScreen(navHostController: NavHostController) {
    val sampleUrl =
        "https://letsenhance.io/static/8f5e523ee6b2479e26ecc91b9c25261e/1015f/MainAfter.jpg"

    MyTopAppBar(
        title = "와우",
        type = TopAppBarType.SMALL,
        onBackPressed = {
            navHostController.popBackStack()
        }
    ) {
        LazyColumn {
            items(100) {
                MyAvatar(
                    imageUrl = sampleUrl,
                    size = AvatarSize.Larger
                )
            }
        }
    }
}