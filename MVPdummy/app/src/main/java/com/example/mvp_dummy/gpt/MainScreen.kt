package com.example.mvp_dummy.gpt

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mvp_dummy.R
import com.example.mvp_dummy.analiticsHelper.AnalyticsHelper
import com.example.mvp_dummy.ui.Navigation
import kotlinx.coroutines.launch

@Composable
fun MainScreen() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()
    val scrollState:ScrollState= rememberScrollState()
    // ModalDrawer that can be opened by swipe gesture
    ModalDrawer(
        drawerState = drawerState,
        gesturesEnabled = true, // Enable swipe gesture
        drawerContent = {
            // Drawer content goes here
            DrawerContent()
        },
        content = {
            // Main content goes here
            MainContent( {
                // Open the drawer when the user requests it
                scope.launch {
                    drawerState.open()
                }
            },navController,scrollState)
        }
    )
}

@Composable
fun DrawerContent() {
    // Populate the drawer with list items
    Column {
        Text(text = "Option 1", modifier = Modifier.padding(16.dp))
        Text(text = "Option 2", modifier = Modifier.padding(16.dp))
        // Add more items here
    }
}

@Composable
fun MainContent( onMenuClicked: () -> Unit, navController: NavHostController, scrollState: ScrollState) {
    // Main screen content
    Scaffold(
        topBar = {
            CustomTopAppBar(
                title = "AutoID",
                icon = Icons.Filled.Settings,
                backgroundColor = Color.Transparent,  // Set to Color.White for a white background
                borderColor = Color(0xFFFFA500)  // Orange color for the border
            )
        },

    ){
        Navigation(navController =navController , scrollState =scrollState , paddingValues =it )
    }
}
@Composable
fun CustomTopAppBar(title: String, icon: ImageVector, backgroundColor: Color, borderColor: Color) {
    TopAppBar(
        title = { InfoWithIcon(icon = icon, info = title) },
        modifier = Modifier.drawBehind {
            val strokeWidth = 1.dp.toPx() // Define the stroke width
            val y = size.height - strokeWidth / 2
            drawLine(
                SolidColor(borderColor),
                start = Offset(0f, y),
                end = Offset(size.width, y),
                strokeWidth = strokeWidth
            )
        },
     backgroundColor= Color.Transparent,
        elevation = 0.dp

    )
}
@Composable
fun InfoWithIcon(icon: ImageVector, info:String) {
    Row() {
        Icon(
            icon, contentDescription = "Author", modifier = Modifier.padding(end = 8.dp),
            colorResource(id = R.color.black)
        )
        Text(text = info, style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp, color =  Color(0xFFFFA500) ))
    }
}
