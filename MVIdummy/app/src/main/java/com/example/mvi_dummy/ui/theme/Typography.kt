package com.example.mvi_dummy.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.mvi_dummy.R


//val abrilFatface = FontFamily(Font(R.font.abril_fatface))
//val montserrat =
//    FontFamily(Font(R.font.montserrat_regular), Font(R.font.montserrat_bold, FontWeight.Bold))

val AppTypography = Typography(
    displayLarge = TextStyle(
      //  fontFamily = abrilFatface,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp
    ),
    displayMedium = TextStyle(
       // fontFamily = montserrat,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    labelSmall = TextStyle(
       // fontFamily = montserrat,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    ),
    bodyLarge = TextStyle(
       // fontFamily = montserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    )
)
