package com.hhhello0507.app

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

sealed interface Destination {
    @Serializable
    data object Home : Destination

    @Serializable
    data object Avatar : Destination

    @Serializable
    data object Button : Destination

    @Serializable
    data object Dialog : Destination

    @Serializable
    data object Divider : Destination

    @Serializable
    data object TextField : Destination
}

@Composable
fun NavigationGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = Destination.Home
    ) {
        composable<Destination.Home> { HomeScreen(navHostController) }
        composable<Destination.Avatar> { AvatarScreen(navHostController) }
        composable<Destination.Button> { ButtonScreen(navHostController) }
        composable<Destination.Dialog> { DialogScreen(navHostController) }
        composable<Destination.Divider> { DividerScreen(navHostController) }
        composable<Destination.TextField> { TextFieldScreen(navHostController) }
    }
}