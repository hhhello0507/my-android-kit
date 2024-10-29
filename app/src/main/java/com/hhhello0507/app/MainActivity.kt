package com.hhhello0507.app

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hhhello0507.mydesignsystem.component.avatar.AvatarSize
import com.hhhello0507.mydesignsystem.component.avatar.MyAvatar
import com.hhhello0507.mydesignsystem.component.button.ButtonRole
import com.hhhello0507.mydesignsystem.component.button.ButtonSize
import com.hhhello0507.mydesignsystem.component.button.MyButton
import com.hhhello0507.mydesignsystem.foundation.MyTheme
import com.hhhello0507.mydesignsystem.foundation.iconography.IconType
import com.hhhello0507.mydesignsystem.layout.BottomTabItem
import com.hhhello0507.mydesignsystem.layout.MyBottomAppBar
import com.hhhello0507.mydesignsystem.layout.MyTopAppBar
import com.hhhello0507.mydesignsystem.layout.TopAppBarButton
import com.hhhello0507.mydesignsystem.layout.TopAppBarType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

@Composable
fun HomeScreen() {
    MyTopAppBar(
        title = "와우"
    ) {
        LazyColumn(
            modifier = Modifier.padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            item {
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    MyButton(
                        text = "button",
                        role = ButtonRole.PRIMARY,
                        size = ButtonSize.Larger,
                        startIcon = IconType.ADD_LINE,
                        endIcon = IconType.ADD_LINE,
                        expanded = true
                    ) { }

                    MyButton(
                        text = "button",
                        role = ButtonRole.PRIMARY,
                        size = ButtonSize.Larger,
                        startIcon = IconType.ADD_LINE,
                        endIcon = IconType.ADD_LINE,
                        isRounded = true,
                        expanded = true
                    ) { }

                    MyButton(
                        text = "button",
                        role = ButtonRole.PRIMARY,
                        size = ButtonSize.Larger,
                        startIcon = IconType.ADD_LINE,
                        endIcon = IconType.ADD_LINE,
                        isEnabled = false,
                        expanded = true
                    ) { }

                    MyButton(
                        text = "button",
                        role = ButtonRole.PRIMARY,
                        size = ButtonSize.Larger,
                        startIcon = IconType.ADD_LINE,
                        endIcon = IconType.ADD_LINE,
                        isLoading = true,
                        expanded = true
                    ) { }
                }
            }
            items(
                listOf(
                    ButtonRole.PRIMARY,
                    ButtonRole.SECONDARY,
                    ButtonRole.ASSISTIVE,
                    ButtonRole.TEXT
                )
            ) { role ->
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(
                        listOf(
                            ButtonSize.Larger,
                            ButtonSize.Large,
                            ButtonSize.Medium,
                            ButtonSize.Small
                        )
                    ) { size ->

                        Column(
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            MyButton(
                                text = "button",
                                role = role,
                                size = size,
                                startIcon = IconType.ADD_LINE,
                                endIcon = IconType.ADD_LINE
                            ) { }

                            MyButton(
                                text = "button",
                                role = role,
                                size = size,
                                startIcon = IconType.ADD_LINE,
                                endIcon = IconType.ADD_LINE,
                                isRounded = true
                            ) { }

                            MyButton(
                                text = "button",
                                role = role,
                                size = size,
                                startIcon = IconType.ADD_LINE,
                                endIcon = IconType.ADD_LINE,
                                isEnabled = false
                            ) { }

                            MyButton(
                                text = "button",
                                role = role,
                                size = size,
                                startIcon = IconType.ADD_LINE,
                                endIcon = IconType.ADD_LINE,
                                isLoading = true
                            ) { }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ProfileScreen() {
    val sampleUrl =
        "https://letsenhance.io/static/8f5e523ee6b2479e26ecc91b9c25261e/1015f/MainAfter.jpg"
    val context = LocalContext.current

    MyTopAppBar(
        title = "와우",
        type = TopAppBarType.SMALL,
        buttons = listOf(
            TopAppBarButton(
                icon = IconType.SEARCH,
            ) {
                Toast.makeText(context, "search", Toast.LENGTH_SHORT).show()
            },
            TopAppBarButton(
                icon = IconType.SEARCH,
            ) {
                Toast.makeText(context, "search", Toast.LENGTH_SHORT).show()
            }
        )
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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            var selectedTab by remember { mutableIntStateOf(0) }

            MyTheme {
                MyBottomAppBar(
                    selected = selectedTab,
                    onClick = { selectedTab = it },
                    tabs = listOf(
                        BottomTabItem(
                            iconType = IconType.HOME,
                            text = "홈"
                        ) {
                            ProfileScreen()
                        },
                        BottomTabItem(
                            iconType = IconType.PERSON,
                            text = "프로필"
                        ) {
                            HomeScreen()
                        }
                    )
                )
            }
        }
    }
}