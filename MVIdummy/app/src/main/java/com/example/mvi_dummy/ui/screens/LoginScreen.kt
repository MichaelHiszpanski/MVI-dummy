package com.example.mvi_dummy.ui.screens

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.mvi_dummy.Local.LocalAnalyticsHelper
import com.example.mvi_dummy.Local.LocalLoginModelView
import com.example.mvi_dummy.MVI.LoginMVI.LoginScreenIntent
import com.example.mvi_dummy.MVI.LoginMVI.LoginScreenViewModel
import com.example.mvi_dummy.R
import com.example.mvi_dummy.ui.components.InfoWithIcon
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun LoginScreen(scrollState: ScrollState,loginViewModel: LoginScreenViewModel) {
    val viewModel= LocalLoginModelView.current
    val analyticsHelper = LocalAnalyticsHelper.current
    DisposableEffect(analyticsHelper) {
        analyticsHelper.logScreenTransition("Login Screen", "Home Viewed")

        // No cleanup action is needed here, so just return an empty lambda
        onDispose { }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState),
    ) {

        Text(text = "Loginl Screen", fontWeight = FontWeight.SemiBold)
        CoilImage(
            imageModel = ImageBitmap.imageResource(R.drawable.error),

            contentScale = ContentScale.Crop,
            error = ImageBitmap.imageResource(R.drawable.error),

            placeHolder = ImageBitmap.imageResource(R.drawable.brnews)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            InfoWithIcon(Icons.Default.Edit, info = "Not Available")
            // InfoWithIcon(Icons.Default.DateRange, info =MockData.stringToDate(article.publishedAT?:"Nothing").getTimeAgo() )

        }
        Text(text = "Not Available", fontWeight = FontWeight.Bold)
        Text(text = "Not Available", modifier = Modifier.padding(top = 16.dp))
        val context = LocalContext.current
        Button(onClick = { viewModel.loadImage(context) }) {
            Text("Load Image")
        }
    }
}
