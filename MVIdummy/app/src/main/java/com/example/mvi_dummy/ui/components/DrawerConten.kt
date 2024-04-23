package com.example.mvi_dummy.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DrawerContent() {

    Column {
        Text(text = "Option 1", modifier = Modifier.padding(16.dp))
        Text(text = "Option 2", modifier = Modifier.padding(16.dp))

    }
}