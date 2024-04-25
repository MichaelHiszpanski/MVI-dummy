package com.example.mvi_dummy.ui.screens

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.ModalDrawer
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.rememberNavController
import androidx.compose.material.DrawerValue
import androidx.compose.material.rememberDrawerState
import com.example.mvi_dummy.ui.components.DrawerContent
import com.example.mvi_dummy.ui.components.MainContent
import kotlinx.coroutines.launch


@Composable
fun MainScreen() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()
    val scrollState: ScrollState = rememberScrollState()

    ModalDrawer(
        drawerState = drawerState,

        gesturesEnabled = true,
        drawerContent = {

            DrawerContent(navController,drawerState,scope)
        },
        content = {

            MainContent({
                scope.launch {
                    drawerState.open()
                }
            }, navController, scrollState)
        }
    )
}






