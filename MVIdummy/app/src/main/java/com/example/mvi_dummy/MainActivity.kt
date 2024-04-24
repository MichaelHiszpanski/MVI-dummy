package com.example.mvi_dummy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mvi_dummy.Local.LocalAnalyticsHelper
import com.example.mvi_dummy.Local.LocalLoginModelView
import com.example.mvi_dummy.MVI.LoginMVI.LoginScreenViewModel
import com.example.mvi_dummy.analytics_helper.AnalyticsHelper
import com.example.mvi_dummy.ui.screens.AppContent
import com.example.mvi_dummy.ui.screens.MainScreen
import com.example.mvi_dummy.ui.theme.MVIdummyTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    @Inject
    lateinit var analyticsHelper: AnalyticsHelper



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MVIdummyTheme {
                CompositionLocalProvider(
                    LocalAnalyticsHelper provides analyticsHelper,
                ) {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        MainScreen()
                    }
                }
            }
        }
    }
}


//@Preview(showBackground = true)
//@Composable
