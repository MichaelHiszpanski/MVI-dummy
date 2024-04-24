package com.example.mvi_dummy.utils

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mvi_dummy.MVI.LoginMVI.LoginScreenViewModel
import com.example.mvi_dummy.ui.screens.AppContent
import com.example.mvi_dummy.ui.screens.LoginScreen
import com.example.mvi_dummy.ui.screens.MainScreen

@Composable
fun Navigation(
    navController: NavHostController,
    scrollState: ScrollState,
    paddingValues: PaddingValues,
    loginViewModel: LoginScreenViewModel
) {

    NavHost(
        navController = navController,
        startDestination = "AppContent",
        modifier = Modifier.padding(paddingValues = paddingValues)
    ) {

        composable("AppContent") {
            AppContent()
        }

        composable("LoginScreen") {
            LoginScreen(scrollState = scrollState, loginViewModel)
        }

    }
}

