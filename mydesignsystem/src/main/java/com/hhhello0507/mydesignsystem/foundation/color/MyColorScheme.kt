package com.hhhello0507.mydesignsystem.foundation.color

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.runtime.structuralEqualityPolicy
import androidx.compose.ui.graphics.Color

@Stable
class MyColorScheme(
    /*
    Label
     */
    labelNormal: Color,
    labelStrong: Color,
    labelNeutral: Color,
    labelAlternative: Color,
    labelAssistive: Color,
    labelDisable: Color,

    /*
    Line
     */
    lineNormal: Color,
    lineNeutral: Color,
    lineAlternative: Color,

    /*
    Fill
     */
    fillNormal: Color,
    fillNeutral: Color,
    fillAlternative: Color,
    fillAssistive: Color,

    /*
    Background
     */
    backgroundNormal: Color,
    backgroundNeutral: Color,
    backgroundAlternative: Color,

    /*
    Elevation
     */
    elevationBlack1: Color,
    elevationBlack2: Color,
    elevationBlack3: Color,

    /*
    Static
     */
    white: Color,
    black: Color,
    clear: Color,

    /*
    Primary
     */
    primaryNormal: Color,
    primaryAlternative: Color,
    primaryAssistive: Color,

    /*
    Status
     */
    negative: Color,
    cautionary: Color,
    positive: Color
) {
    /*
    Label
     */
    var labelNormal by mutableStateOf(labelNormal, structuralEqualityPolicy())
        internal set
    var labelStrong by mutableStateOf(labelStrong, structuralEqualityPolicy())
        internal set
    var labelNeutral by mutableStateOf(labelAlternative, structuralEqualityPolicy())
        internal set
    var labelAlternative by mutableStateOf(labelAlternative, structuralEqualityPolicy())
        internal set
    var labelAssistive by mutableStateOf(labelAssistive, structuralEqualityPolicy())
        internal set
    var labelDisable by mutableStateOf(labelDisable, structuralEqualityPolicy())
        internal set

    /*
    Line
     */
    var lineNormal by mutableStateOf(lineNormal, structuralEqualityPolicy())
        internal set
    var lineNeutral by mutableStateOf(lineNeutral, structuralEqualityPolicy())
        internal set
    var lineAlternative by mutableStateOf(lineAlternative, structuralEqualityPolicy())
        internal set

    /*
    Fill
     */
    var fillNormal by mutableStateOf(fillNormal, structuralEqualityPolicy())
        internal set
    var fillNeutral by mutableStateOf(fillNeutral, structuralEqualityPolicy())
        internal set
    var fillAlternative by mutableStateOf(fillAlternative, structuralEqualityPolicy())
        internal set
    var fillAssistive by mutableStateOf(fillAssistive, structuralEqualityPolicy())
        internal set

    /*
    Background
     */
    var backgroundNormal by mutableStateOf(backgroundNormal, structuralEqualityPolicy())
        internal set
    var backgroundNeutral by mutableStateOf(backgroundNeutral, structuralEqualityPolicy())
        internal set
    var backgroundAlternative by mutableStateOf(backgroundAlternative, structuralEqualityPolicy())
        internal set

    /*
    Elevation
     */
    var elevationBlack1 by mutableStateOf(elevationBlack1, structuralEqualityPolicy())
        internal set
    var elevationBlack2 by mutableStateOf(elevationBlack2, structuralEqualityPolicy())
        internal set
    var elevationBlack3 by mutableStateOf(elevationBlack3, structuralEqualityPolicy())
        internal set

    /*
    Static
     */
    var white by mutableStateOf(white, structuralEqualityPolicy())
        internal set
    var black by mutableStateOf(black, structuralEqualityPolicy())
        internal set
    var clear by mutableStateOf(clear, structuralEqualityPolicy())
        internal set

    /*
    Primary
     */
    var primaryNormal by mutableStateOf(primaryNormal, structuralEqualityPolicy())
        internal set
    var primaryAlternative by mutableStateOf(primaryAlternative, structuralEqualityPolicy())
        internal set
    var primaryAssistive by mutableStateOf(primaryAssistive, structuralEqualityPolicy())
        internal set

    /*
    Status
     */
    var negative by mutableStateOf(negative, structuralEqualityPolicy())
        internal set
    var cautionary by mutableStateOf(cautionary, structuralEqualityPolicy())
        internal set
    var positive by mutableStateOf(positive, structuralEqualityPolicy())
        internal set
}

internal val LocalMyColorScheme = staticCompositionLocalOf { lightColorScheme() }
