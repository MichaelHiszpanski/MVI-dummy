package com.example.mvi_dummy.utils

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mvi_dummy.ui.screens.AppContent

@Composable
fun Navigation(navController: NavHostController, scrollState: ScrollState,

               paddingValues: PaddingValues
) {
    NavHost(navController = navController, startDestination ="Login"
        , modifier = Modifier.padding(paddingValues =paddingValues )) {

        composable("AppContent") {
            AppContent()
        }

        composable("Confirmation") {
//            ConfirmationScreen(
//
//                scrollState = scrollState,
//                navController = navController
//            )
        }

    }
}

