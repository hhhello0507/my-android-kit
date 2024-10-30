package com.hhhello0507.app

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEach
import androidx.navigation.NavHostController
import com.hhhello0507.mydesignsystem.component.button.ButtonRole
import com.hhhello0507.mydesignsystem.component.button.ButtonSize
import com.hhhello0507.mydesignsystem.component.button.MyButton
import com.hhhello0507.mydesignsystem.layout.MyTopAppBar
import com.hhhello0507.mydesignsystem.layout.TopAppBarType

@Composable
fun ButtonScreen(navHostController: NavHostController) {
    val context = LocalContext.current

    var buttonRole by remember { mutableStateOf(ButtonRole.PRIMARY) }
    var buttonSize by remember { mutableStateOf<ButtonSize>(ButtonSize.Larger) }
    var isEnabled by remember { mutableStateOf(true) }
    var isLoading by remember { mutableStateOf(false) }
    var isRounded by remember { mutableStateOf(false) }
    var isStroke by remember { mutableStateOf(false) }
    var expanded by remember { mutableStateOf(false) }

    MyTopAppBar(
        title = "Button",
        type = TopAppBarType.SMALL,
        onBackPressed = {
            navHostController.safePopBackStack()
        }
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .padding(top = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .height(100.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                MyButton(
                    text = "버튼",
                    size = buttonSize,
                    role = buttonRole,
                    isEnabled = isEnabled,
                    isLoading = isLoading,
                    isRounded = isRounded,
                    isStroke = isStroke,
                    expanded = expanded
                ) {
                    Toast.makeText(context, "Toast", Toast.LENGTH_SHORT).show()
                }
            }
            Text("Role")
            Row(verticalAlignment = Alignment.CenterVertically) {
                ButtonRole.entries.fastForEach {
                    Text(
                        text = it.name,
                        modifier = Modifier
                            .clickable {
                                buttonRole = it
                            }
                            .padding(horizontal = 4.dp, vertical = 12.dp)
                            .weight(1f),
                        textAlign = TextAlign.Center
                    )
                }
            }
            Spacer(Modifier.height(40.dp))
            Text("Size")
            Row(verticalAlignment = Alignment.CenterVertically) {
                ButtonSize::class.nestedClasses
                    .mapNotNull { it.objectInstance as? ButtonSize }
                    .sortedByDescending { it.height }
                    .fastForEach { size ->
                        Text(
                            text = size::class.simpleName.toString(),
                            modifier = Modifier
                                .clickable {
                                    buttonSize = size
                                }
                                .padding(horizontal = 4.dp, vertical = 12.dp)
                                .weight(1f),
                            textAlign = TextAlign.Center
                        )
                    }
            }
        }
    }
}