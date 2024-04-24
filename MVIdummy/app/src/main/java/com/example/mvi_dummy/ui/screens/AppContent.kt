package com.example.mvi_dummy.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mvi_dummy.Local.LocalAnalyticsHelper
import com.example.mvi_dummy.MVI.AppContentMVI.MviIntent
import com.example.mvi_dummy.MVI.AppContentMVI.UserViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppContent(userViewModel: UserViewModel = hiltViewModel()) {
    val state by userViewModel.state.collectAsState()
    val analyticsHelper = LocalAnalyticsHelper.current
    DisposableEffect(analyticsHelper) {
        analyticsHelper.loginHomeScreen("AppContent","First start application")

        onDispose { }
    }
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("MVI Example") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if (state.isLoading) {
                CircularProgressIndicator()
            } else {
                Text(text = state.userName ?: "No user loaded")
            }
            Button(
                onClick = {
                    userViewModel.processIntent(MviIntent.LoadUser)
                    analyticsHelper.appContentButtonClicked("AppContent","Loading button is clicked ")

                          },
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text("Load User")
            }
            state.error?.let {
                Text(text = it, color = MaterialTheme.colorScheme.error)
            }
        }
    }
}