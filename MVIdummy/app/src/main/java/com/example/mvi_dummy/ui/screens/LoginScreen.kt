package com.example.mvi_dummy.ui.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.mvi_dummy.Local.LocalAnalyticsHelper
import com.example.mvi_dummy.MVI.LoginMVI.LoginScreenIntent
import com.example.mvi_dummy.MVI.LoginMVI.LoginScreenViewModel
import com.example.mvi_dummy.R
import com.example.mvi_dummy.ui.components.InfoWithIcon
import com.skydoves.landscapist.coil.CoilImage
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun LoginScreen(scrollState: ScrollState, loginViewModel: LoginScreenViewModel = hiltViewModel()) {
    val analyticsHelper = LocalAnalyticsHelper.current
    val state = loginViewModel.state.collectAsState()
    Log.e("LoginScreen", state.toString())
    val loadedImage = state.value.loadedImage
    DisposableEffect(analyticsHelper) {
        analyticsHelper.logScreenTransition("Login Screen", "Home Viewed")

        onDispose { }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState),
    ) {

        Text(text = "Loginl Screen", fontWeight = FontWeight.SemiBold)
        state.value.loadedImage?.let { img ->
            Image(
                bitmap = img,
                contentDescription = "Loaded Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            CoilImage(
                imageModel ="https://cdn.pixabay.com/photo/2017/07/13/19/51/sunset-2501727_960_720.png",
//                bitmapPalette = img,
                contentScale = ContentScale.Crop,
                error = ImageBitmap.imageResource(R.drawable.error),

                placeHolder = ImageBitmap.imageResource(R.drawable.brnews),
                modifier = Modifier.fillMaxWidth().height(200.dp)
            )
        } ?: Text("Image not loaded")

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            InfoWithIcon(Icons.Default.Edit, info = "Not Available")

        }
        Text(text = "Not Available", fontWeight = FontWeight.Bold)
        Text(text = "Not Available", modifier = Modifier.padding(top = 16.dp))
        val context = LocalContext.current
        Button(onClick = { loginViewModel.sendIntent(LoginScreenIntent.LoadImage, context) }) {
            Text("Load Image")
        }
    }
}
