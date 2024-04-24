package com.example.mvi_dummy.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import com.example.mvi_dummy.ui.theme.Shapes
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun DrawerContent(navController:NavController) {

    Column {

        Button(
            onClick = {
                // Navigate to the LoginScreen
                navController.navigate("LoginScreen")
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Go to Login Screen")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                // Navigate to the LoginScreen
                navController.navigate("AppContent")
            },
            modifier = Modifier.padding(top = 16.dp),
            shape = Shapes.large
        ) {
            Text("Go to Home Screen")
        }
    }
}