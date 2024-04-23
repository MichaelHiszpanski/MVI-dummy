package com.example.mvi_dummy.ui.components

import androidx.compose.foundation.ScrollState
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.mvi_dummy.utils.Navigation

@Composable
fun MainContent(onMenuClicked: () -> Unit, navController: NavHostController, scrollState: ScrollState) {
    // Main screen content
    Scaffold(
        topBar = {
            CustomTopAppBar(
                title = "AutoID",
                icon = Icons.Filled.Settings,
                backgroundColor = Color.Transparent,
                borderColor = Color(0xFFFFA500)
            )
        },

        ){
        Navigation(navController =navController , scrollState =scrollState , paddingValues =it )
    }
}