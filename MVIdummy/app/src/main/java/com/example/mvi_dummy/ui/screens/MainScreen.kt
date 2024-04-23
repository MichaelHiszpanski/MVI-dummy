package com.example.mvi_dummy.ui.screens

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mvi_dummy.ui.components.CustomTopAppBar
import com.example.mvi_dummy.ui.components.DrawerContent
import com.example.mvi_dummy.ui.components.InfoWithIcon
import com.example.mvi_dummy.ui.components.MainContent
import com.example.mvi_dummy.ui.theme.PurpleGrey40
import com.example.mvi_dummy.utils.Navigation
import kotlinx.coroutines.launch

@Composable
fun MainScreen() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()
    val scrollState:ScrollState= rememberScrollState()

    ModalDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {

            DrawerContent()
        },
        content = {

            MainContent( {
                scope.launch {
                    drawerState.open()
                }
            },navController,scrollState)
        }
    )
}






