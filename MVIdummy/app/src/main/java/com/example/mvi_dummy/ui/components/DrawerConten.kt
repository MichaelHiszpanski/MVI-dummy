package com.example.mvi_dummy.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun DrawerContent(navController:NavController) {

    Column {
        Text(text = "Option 1", modifier = Modifier.padding(16.dp))
        Button(
            onClick = {
                // Navigate to the LoginScreen
                navController.navigate("LoginScreen")
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Go to Login Screen")
        }
        Text(text = "Option 2", modifier = Modifier.padding(16.dp))

    }
}