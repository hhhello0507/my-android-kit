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
import com.hhhello0507.mydesignsystem.internal.MyPreviews

object Palette {
    /*
    Neutral
     */
    val Neutral99 = Color(0xFFFCFCFD)
    val Neutral97 = Color(0xFFF6F6F7)
    val Neutral95 = Color(0xFFF2F2F3)
    val Neutral90 = Color(0xFFE4E4E5)
    val Neutral80 = Color(0xFFC8C8CC)
    val Neutral70 = Color(0xFFACACB2)
    val Neutral60 = Color(0xFF919199)
    val Neutral50 = Color(0xFF767680)
    val Neutral40 = Color(0xFF5E5E66)
    val Neutral30 = Color(0xFF47474D)
    val Neutral25 = Color(0xFF3B3B40)
    val Neutral20 = Color(0xFF2F2F33)
    val Neutral15 = Color(0xFF252528)
    val Neutral10 = Color(0xFF19191B)
    val Neutral7 = Color(0xFF111113)
    val Neutral5 = Color(0xFF0C0C0D)

    /*
    Red
     */
    val Red00 = Color(0xFFFFFAFA)
    val Red10 = Color(0xFFFEECEC)
    val Red20 = Color(0xFFFED5D5)
    val Red30 = Color(0xFFFFB5B5)
    val Red40 = Color(0xFFFF8C8C)
    val Red50 = Color(0xFFFF6363)
    val Red60 = Color(0xFFFF4242)
    val Red70 = Color(0xFFE52222)
    val Red80 = Color(0xFFB20C0C)
    val Red90 = Color(0xFF750404)
    val Red100 = Color(0xFF3B0101)

    /*
    Yellow
     */
    val Yellow99 = Color(0xFFFFFEFA)
    val Yellow95 = Color(0xFFFFFAE5)
    val Yellow90 = Color(0xFFFFF5CC)
    val Yellow80 = Color(0xFFFFEB99)
    val Yellow70 = Color(0xFFFFE066)
    val Yellow60 = Color(0xFFFFD633)
    val Yellow50 = Color(0xFFFFCC00)
    val Yellow40 = Color(0xFFCCA300)
    val Yellow30 = Color(0xFF997A00)
    val Yellow20 = Color(0xFF665200)
    val Yellow10 = Color(0xFF332900)

    /*
    Orange
     */
    val Orange99 = Color(0xFFFFFDFA)
    val Orange95 = Color(0xFFFEF5E6)
    val Orange90 = Color(0xFFFEEACD)
    val Orange80 = Color(0xFFFCD69C)
    val Orange70 = Color(0xFFFBC16A)
    val Orange60 = Color(0xFFFAAC38)
    val Orange50 = Color(0xFFF99806)
    val Orange40 = Color(0xFFC77905)
    val Orange30 = Color(0xFF955B04)
    val Orange20 = Color(0xFF633D03)
    val Orange10 = Color(0xFF321E01)

    /*
    Green
     */
    val Green99 = Color(0xFFFBFEFB)
    val Green95 = Color(0xFFE8FCEA)
    val Green90 = Color(0xFFD2F9D6)
    val Green80 = Color(0xFFA6F2AD)
    val Green70 = Color(0xFF79EC85)
    val Green60 = Color(0xFF4DE55C)
    val Green50 = Color(0xFF20DF33)
    val Green40 = Color(0xFF0FBD21)
    val Green30 = Color(0xFF0B8E18)
    val Green20 = Color(0xFF085E10)
    val Green10 = Color(0xFF042F08)

    /*
    Blue
     */
    val Blue99 = Color(0xFFFAFDFF)
    val Blue95 = Color(0xFFE5F3FF)
    val Blue90 = Color(0xFFCCE8FF)
    val Blue80 = Color(0xFF99D1FF)
    val Blue70 = Color(0xFF66B9FF)
    val Blue60 = Color(0xFF33A2FF)
    val Blue50 = Color(0xFF008BFF)
    val Blue40 = Color(0xFF006FCC)
    val Blue30 = Color(0xFF005399)
    val Blue20 = Color(0xFF003866)
    val Blue10 = Color(0xFF001C33)

    /*
    Purple
     */
    val Purple99 = Color(0xFFFCFAFF)
    val Purple95 = Color(0xFFF1E6FE)
    val Purple90 = Color(0xFFE3CDFE)
    val Purple80 = Color(0xFFC79CFC)
    val Purple70 = Color(0xFFAB6AFB)
    val Purple60 = Color(0xFF8F38FA)
    val Purple50 = Color(0xFF7306F9)
    val Purple40 = Color(0xFF5C05C7)
    val Purple30 = Color(0xFF450495)
    val Purple20 = Color(0xFF2E0363)
    val Purple10 = Color(0xFF170132)

    /*
    Common
     */
    val Common00 = Color(0xFFFFFFFF)
    val Common100 = Color(0xFF000000)
    val Transparent = Color(0x00FFFFFF)
}

@Composable
@MyPreviews
private fun Preview() {
    LazyColumn {
        items(
            listOf(
                Palette.Neutral99,
                Palette.Neutral97,
                Palette.Neutral95,
                Palette.Neutral90,
                Palette.Neutral80,
                Palette.Neutral70,
                Palette.Neutral60,
                Palette.Neutral50,
                Palette.Neutral40,
                Palette.Neutral30,
                Palette.Neutral25,
                Palette.Neutral20,
                Palette.Neutral15,
                Palette.Neutral10,
                Palette.Neutral7,
                Palette.Neutral5,

                Palette.Red00,
                Palette.Red10,
                Palette.Red20,
                Palette.Red30,
                Palette.Red40,
                Palette.Red50,
                Palette.Red60,
                Palette.Red70,
                Palette.Red80,
                Palette.Red90,
                Palette.Red100,

                Palette.Yellow99,
                Palette.Yellow95,
                Palette.Yellow90,
                Palette.Yellow80,
                Palette.Yellow70,
                Palette.Yellow60,
                Palette.Yellow50,
                Palette.Yellow40,
                Palette.Yellow30,
                Palette.Yellow20,
                Palette.Yellow10,

                Palette.Orange99,
                Palette.Orange95,
                Palette.Orange90,
                Palette.Orange80,
                Palette.Orange70,
                Palette.Orange60,
                Palette.Orange50,
                Palette.Orange40,
                Palette.Orange30,
                Palette.Orange20,
                Palette.Orange10,

                Palette.Green99,
                Palette.Green95,
                Palette.Green90,
                Palette.Green80,
                Palette.Green70,
                Palette.Green60,
                Palette.Green50,
                Palette.Green40,
                Palette.Green30,
                Palette.Green20,
                Palette.Green10,

                Palette.Blue99,
                Palette.Blue95,
                Palette.Blue90,
                Palette.Blue80,
                Palette.Blue70,
                Palette.Blue60,
                Palette.Blue50,
                Palette.Blue40,
                Palette.Blue30,
                Palette.Blue20,
                Palette.Blue10,

                Palette.Purple99,
                Palette.Purple95,
                Palette.Purple90,
                Palette.Purple80,
                Palette.Purple70,
                Palette.Purple60,
                Palette.Purple50,
                Palette.Purple40,
                Palette.Purple30,
                Palette.Purple20,
                Palette.Purple10,

                Palette.Common00,
                Palette.Common100,
                Palette.Transparent,
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