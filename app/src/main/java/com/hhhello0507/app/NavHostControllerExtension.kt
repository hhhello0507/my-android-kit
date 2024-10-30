package com.hhhello0507.app

import androidx.navigation.NavHostController

fun NavHostController.safePopBackStack() {
    if (previousBackStackEntry != null) {
        popBackStack()
    }
}