package com.hhhello0507.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.hhhello0507.mydesignsystem.component.avatar.AvatarSize
import com.hhhello0507.mydesignsystem.component.avatar.MyAvatar
import com.hhhello0507.mydesignsystem.foundation.MyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val sampleUrl =
            "https://letsenhance.io/static/8f5e523ee6b2479e26ecc91b9c25261e/1015f/MainAfter.jpg"

        setContent {
            MyTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MyTheme.colorScheme.backgroundNormal,
                ) {
                    MyAvatar(
                        imageUrl = sampleUrl,
                        size = AvatarSize.Larger
                    )
                }
            }
        }
    }
}