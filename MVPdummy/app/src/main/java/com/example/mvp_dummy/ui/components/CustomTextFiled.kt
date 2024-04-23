package com.example.mvp_dummy.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.text.style.TextAlign

@Composable
fun CustomTextField() {
    val userEmail = remember { mutableStateOf(TextFieldValue("")) }
    val userEmailError = remember { mutableStateOf<String?>(null) }
    val interactions = remember { MutableInteractionSource() }
    val isFocused by interactions.collectIsFocusedAsState()

    BasicTextField(
        value = userEmail.value,
        onValueChange = {
            userEmail.value = it
            userEmailError.value = null  // Reset error on user input
        },
        singleLine = true,
        textStyle = TextStyle(color = LocalContentColor.current, textAlign = TextAlign.Center),
        cursorBrush = SolidColor(Color.Black),
        keyboardOptions = KeyboardOptions(autoCorrect = false),
        keyboardActions = KeyboardActions.Default,
        interactionSource = interactions,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp)  // Padding adjusted for initial centering
            .bottomBorderOnlyTextField(
                isFocused = isFocused || userEmail.value.text.isNotEmpty(),
                isError = userEmailError.value != null,
                focusedColor = Color(0xFFFFA500),  // Custom orange color
                defaultColor = Color.Gray,
                errorColor = Color.Red
            ),
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 12.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center  // Ensure the placeholder and text are centered
            ) {
                if (userEmail.value.text.isEmpty() && !isFocused) {
                    Text("email adres", style = TextStyle(color = Color.Gray, textAlign = TextAlign.Center))
                }
                innerTextField()
            }
        }
    )
}

@Composable
fun Modifier.bottomBorderOnlyTextField(
    isFocused: Boolean,
    isError: Boolean,
    focusedColor: Color,
    defaultColor: Color,
    errorColor: Color
): Modifier {
    return this.then(
        Modifier.drawBehind {
            val color = when {
                isError -> errorColor
                isFocused -> focusedColor
                else -> defaultColor
            }
            val strokeWidth = (if (isFocused) 2 else 1).dp.toPx()
            drawLine(
                color,
                start = Offset(x = 0f, y = size.height),
                end = Offset(x = size.width, y = size.height),
                strokeWidth = strokeWidth
            )
        }
    )
}