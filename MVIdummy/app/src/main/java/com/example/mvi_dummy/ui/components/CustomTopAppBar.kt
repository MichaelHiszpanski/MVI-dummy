package com.example.mvi_dummy.ui.components

import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun CustomTopAppBar(title: String, icon: ImageVector, backgroundColor: Color, borderColor: Color) {
    TopAppBar(
        title = { InfoWithIcon(icon = icon, info = title) },
        modifier = Modifier.drawBehind {
            val strokeWidth = 1.dp.toPx() // Define the stroke width
            val y = size.height - strokeWidth / 2
            drawLine(
                SolidColor(borderColor),
                start = Offset(0f, y),
                end = Offset(size.width, y),
                strokeWidth = strokeWidth
            )
        },
        backgroundColor = Color.Transparent,
        elevation = 0.dp

    )
}