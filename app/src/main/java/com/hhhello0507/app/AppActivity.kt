package com.hhhello0507.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.hhhello0507.mydesignsystem.foundation.MyTheme

class AppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val navHostController = rememberNavController()
            MyTheme {
                NavigationGraph(navHostController = navHostController)
            }
        }
    }
}