package com.hhhello0507.app

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.hhhello0507.mydesignsystem.component.divider.DividerSize
import com.hhhello0507.mydesignsystem.component.divider.MyHorizontalDivider
import com.hhhello0507.mydesignsystem.component.divider.MyVerticalDivider
import com.hhhello0507.mydesignsystem.layout.MyTopAppBar
import com.hhhello0507.mydesignsystem.layout.TopAppBarType

@Composable
fun DividerScreen(navHostController: NavHostController) {
    MyTopAppBar(
        title = "Divider",
        type = TopAppBarType.SMALL,
        onBackPressed = {
            navHostController.safePopBackStack()
        }
    ) {
        Column(
            modifier = Modifier
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text("Horizontal divider")
            MyHorizontalDivider()
            MyHorizontalDivider(size = DividerSize.Medium)
            MyHorizontalDivider(size = DividerSize.Large)

            Text("Verical divider")
            Row(
                modifier = Modifier.height(300.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                MyVerticalDivider()
                MyVerticalDivider(size = DividerSize.Medium)
                MyVerticalDivider(size = DividerSize.Large)
            }
        }
    }
}