package com.hhhello0507.app

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.hhhello0507.mydesignsystem.component.button.ButtonRole
import com.hhhello0507.mydesignsystem.component.button.ButtonSize
import com.hhhello0507.mydesignsystem.component.button.MyButton
import com.hhhello0507.mydesignsystem.component.button.MySegmentedButton
import com.hhhello0507.mydesignsystem.component.button.MySwitch
import com.hhhello0507.mydesignsystem.foundation.MyTheme
import com.hhhello0507.mydesignsystem.layout.MyTopAppBar
import com.hhhello0507.mydesignsystem.layout.TopAppBarType

@Composable
fun ButtonScreen(navHostController: NavHostController) {
    val context = LocalContext.current

    var selectedRole by remember { mutableIntStateOf(0) }
    val roles = ButtonRole.entries
    var selectedSize by remember { mutableStateOf(0) }
    val sizes = ButtonSize::class.nestedClasses
        .mapNotNull { it.objectInstance as? ButtonSize }
        .sortedByDescending { it.height }
    var isEnabled by remember { mutableStateOf(true) }
    var isLoading by remember { mutableStateOf(false) }
    var isRounded by remember { mutableStateOf(false) }
    var isStroke by remember { mutableStateOf(false) }
    var expanded by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()

    MyTopAppBar(
        title = "Button",
        type = TopAppBarType.SMALL,
        onBackPressed = {
            navHostController.safePopBackStack()
        }
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .padding(horizontal = 20.dp)
                .padding(top = 20.dp)
        ) {
            Box(
                modifier = Modifier
                    .height(100.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                MyButton(
                    text = "버튼",
                    size = sizes[selectedSize],
                    role = roles[selectedRole],
                    isEnabled = isEnabled,
                    isLoading = isLoading,
                    isRounded = isRounded,
                    isStroke = isStroke,
                    expanded = expanded
                ) {
                    Toast.makeText(context, "Toast", Toast.LENGTH_SHORT).show()
                }
            }
            Headline("Role")
            MySegmentedButton(
                selected = selectedRole,
                buttons = roles.map { it.name },
                textStyle = MyTheme.typography.captionMedium,
                onChange = {
                    selectedRole = it
                }
            )
            Headline("Size")
            MySegmentedButton(
                selected = selectedSize,
                buttons = sizes.map { it::class.simpleName.toString() },
                onChange = {
                    selectedSize = it
                }
            )
            Headline("isEnabled")
            MySwitch(checked = isEnabled, onCheckedChange = { isEnabled = it })
            Headline("isLoading")
            MySwitch(checked = isLoading, onCheckedChange = { isLoading = it })
            Headline("isRounded")
            MySwitch(checked = isRounded, onCheckedChange = { isRounded = it })
            Headline("isStroke")
            MySwitch(checked = isStroke, onCheckedChange = { isStroke = it })
            Headline("expanded")
            MySwitch(checked = expanded, onCheckedChange = { expanded = it })
        }
    }
}