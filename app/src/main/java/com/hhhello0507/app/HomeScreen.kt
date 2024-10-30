package com.hhhello0507.app

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.hhhello0507.mydesignsystem.foundation.MyTheme
import com.hhhello0507.mydesignsystem.foundation.iconography.IconType
import com.hhhello0507.mydesignsystem.foundation.iconography.MyIcon
import com.hhhello0507.mydesignsystem.layout.MyTopAppBar

@Composable
fun HomeScreen(navHostController: NavHostController) {
    MyTopAppBar(
        title = "Home"
    ) {
        LazyColumn {
            items(
                Destination::class.nestedClasses
                    .mapNotNull {
                        it.objectInstance as? Destination
                    }
                    .sortedBy { it::class.simpleName }
            ) { destination ->
                Row(
                    modifier = Modifier
                        .clickable {
                            navHostController.navigate(destination)
                        }
                        .fillMaxWidth()
                        .padding(20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(destination::class.simpleName.toString())
                    MyIcon(
                        modifier = Modifier
                            .size(18.dp)
                            .rotate(180f),
                        type = IconType.EXPAND_ARROW,
                        color = MyTheme.colorScheme.labelAssistive
                    )
                }
            }
        }
    }
}