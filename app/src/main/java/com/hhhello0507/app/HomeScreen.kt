package com.hhhello0507.app

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.hhhello0507.mydesignsystem.layout.MyTopAppBar

@Composable
fun HomeScreen(navHostController: NavHostController) {
    MyTopAppBar(
        title = "Home"
    ) {
        LazyColumn {
            items(
                listOf(
                    Destination.Avatar,
                    Destination.Button,
                    Destination.Dialog,
                    Destination.Divider,
                    Destination.TextField
                )
            ) { destination ->
                Button(
                    onClick = {
                        navHostController.navigate(destination)
                    }
                ) {
                    Text(destination::class.simpleName.toString())
                }
            }
        }
    }
}