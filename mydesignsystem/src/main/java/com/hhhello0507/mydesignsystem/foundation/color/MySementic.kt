package com.hhhello0507.mydesignsystem.foundation.color

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.hhhello0507.mydesignsystem.foundation.MyTheme
import com.hhhello0507.mydesignsystem.internal.MyPreviews

fun lightColorScheme() = MyColorScheme(
    labelNormal = Palette.Neutral5,
    labelStrong = Palette.Common100,
    labelNeutral = Palette.Neutral25,
    labelAlternative = Palette.Neutral40,
    labelAssistive = Palette.Neutral50,
    labelDisable = Palette.Neutral97,
    lineNormal = Palette.Neutral90,
    lineNeutral = Palette.Neutral95,
    lineAlternative = Palette.Neutral97,
    fillNormal = Palette.Neutral97,
    fillNeutral = Palette.Neutral95,
    fillAlternative = Palette.Neutral90,
    fillAssistive = Palette.Common00,
    backgroundNormal = Palette.Common00,
    backgroundNeutral = Palette.Neutral99,
    backgroundAlternative = Palette.Neutral97,
    elevationBlack1 = Palette.Common100.copy(alpha = 0.02f),
    elevationBlack2 = Palette.Common100.copy(alpha = 0.04f),
    elevationBlack3 = Palette.Common100.copy(alpha = 0.06f),
    white = Palette.Common00,
    black = Palette.Common100,
    clear = Palette.Transparent,
    primaryNormal = Palette.Blue50,
    primaryAlternative = Palette.Blue50.copy(alpha = 0.65f),
    primaryAssistive = Palette.Blue50.copy(alpha = 0.2f),
    negative = Palette.Red50,
    cautionary = Palette.Yellow50,
    positive = Palette.Green50,
)

fun darkColorScheme() = MyColorScheme(
    labelNormal = Palette.Neutral99,
    labelStrong = Palette.Common00,
    labelNeutral = Palette.Neutral95,
    labelAlternative = Palette.Neutral90,
    labelAssistive = Palette.Neutral70,
    labelDisable = Palette.Neutral30,
    lineNormal = Palette.Neutral50,
    lineNeutral = Palette.Neutral30,
    lineAlternative = Palette.Neutral25,
    fillNormal = Palette.Neutral20,
    fillNeutral = Palette.Neutral25,
    fillAlternative = Palette.Neutral30,
    fillAssistive = Palette.Neutral60,
    backgroundNormal = Palette.Neutral15,
    backgroundNeutral = Palette.Neutral10,
    backgroundAlternative = Palette.Neutral7,
    elevationBlack1 = Color(0xFFCCCCD6).copy(alpha = 0.02f),
    elevationBlack2 = Color(0xFFCCCCD6).copy(alpha = 0.04f),
    elevationBlack3 = Color(0xFFCCCCD6).copy(alpha = 0.06f),
    white = Palette.Common00,
    black = Palette.Common100,
    clear = Palette.Transparent,
    primaryNormal = Palette.Blue50,
    primaryAlternative = Palette.Blue50.copy(alpha = 0.65f),
    primaryAssistive = Palette.Blue50.copy(alpha = 0.2f),
    negative = Palette.Red50,
    cautionary = Palette.Yellow50,
    positive = Palette.Green50
)

@MyPreviews
@Composable
private fun Preview() {
    MyTheme {
        val colorScheme = MyTheme.colorScheme
        LazyColumn {
            items(
                listOf(
                    colorScheme.labelNormal,
                    colorScheme.labelNormal,
                    colorScheme.labelStrong,
                    colorScheme.labelNeutral,
                    colorScheme.labelAlternative,
                    colorScheme.labelAssistive,
                    colorScheme.labelDisable,
                    colorScheme.lineNormal,
                    colorScheme.lineNeutral,
                    colorScheme.lineAlternative,
                    colorScheme.fillNormal,
                    colorScheme.fillNeutral,
                    colorScheme.fillAlternative,
                    colorScheme.fillAssistive,
                    colorScheme.backgroundNormal,
                    colorScheme.backgroundNeutral,
                    colorScheme.backgroundAlternative,
                    colorScheme.elevationBlack1,
                    colorScheme.elevationBlack2,
                    colorScheme.elevationBlack3,
                    colorScheme.white,
                    colorScheme.black,
                    colorScheme.clear,
                    colorScheme.primaryNormal,
                    colorScheme.primaryAlternative,
                    colorScheme.primaryAssistive,
                    colorScheme.negative,
                    colorScheme.cautionary,
                    colorScheme.positive,
                )
            ) { color ->
                Box(
                    modifier = Modifier
                        .background(color)
                        .fillMaxWidth()
                        .height(30.dp)
                )
            }
        }
    }
}