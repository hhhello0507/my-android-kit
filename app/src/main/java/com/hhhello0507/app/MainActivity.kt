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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.hhhello0507.mydesignsystem.component.avatar.AvatarSize
import com.hhhello0507.mydesignsystem.component.avatar.MyAvatar
import com.hhhello0507.mydesignsystem.component.button.ButtonRole
import com.hhhello0507.mydesignsystem.component.button.ButtonSize
import com.hhhello0507.mydesignsystem.component.button.MyButton
import com.hhhello0507.mydesignsystem.component.dialog.MyDialog
import com.hhhello0507.mydesignsystem.foundation.MyTheme
import com.hhhello0507.mydesignsystem.foundation.iconography.IconType
import com.hhhello0507.mydesignsystem.layout.BottomTabItem
import com.hhhello0507.mydesignsystem.layout.MyBottomAppBar
import com.hhhello0507.mydesignsystem.layout.MyTopAppBar
import com.hhhello0507.mydesignsystem.layout.TopAppBarButton
import com.hhhello0507.mydesignsystem.layout.TopAppBarType

@Composable
fun ButtonDemo() {
    MyTopAppBar(
        title = "Button test"
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
                    MyButton(
                        text = "button",
                        role = ButtonRole.PRIMARY,
                        size = ButtonSize.Larger,
                        startIcon = IconType.ADD_LINE,
                        endIcon = IconType.ADD_LINE,
                        isStroke = true,
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
                            MyButton(
                                text = "button",
                                role = role,
                                size = size,
                                startIcon = IconType.ADD_LINE,
                                endIcon = IconType.ADD_LINE,
                                isStroke = true
                            ) { }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun AvatarDemo() {
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

@Composable
fun DialogDemo() {
    var showDialog1 by remember { mutableStateOf(false) }
    var showDialog2 by remember { mutableStateOf(false) }

    MyTopAppBar(
        title = "Dialog demo"
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
            Button(
                onClick = {
                    showDialog1 = true
                }
            ) {
                Text("Show dialog 1")
            }
            Button(
                onClick = {
                    showDialog2 = true
                }
            ) {
                Text("Show dialog 2")
            }
        }

        if (showDialog1) {
            MyDialog(
                title = "Title",
                content = "Content"
            ) {
                showDialog1 = false
            }
        }

        if (showDialog2) {
            MyDialog(
                title = "Title",
                content = "Content",
                onSuccessRequest = {
                    showDialog2 = false
                },
                onCancelRequest = {
                    showDialog2 = false
                },
                onDismissRequest = {
                    showDialog2 = false
                }
            )
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
                            text = "a"
                        ) {
                            AvatarDemo()
                        },
                        BottomTabItem(
                            iconType = IconType.PERSON,
                            text = "b"
                        ) {
                            ButtonDemo()
                        },
                        BottomTabItem(
                            iconType = IconType.PERSON,
                            text = "c"
                        ) {
                            DialogDemo()
                        }
                    )
                )
            }
        }
    }
}