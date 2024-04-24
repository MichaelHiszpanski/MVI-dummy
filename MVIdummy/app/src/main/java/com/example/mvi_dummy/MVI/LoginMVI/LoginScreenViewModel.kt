package com.example.mvi_dummy.MVI.LoginMVI

import android.content.Context
import android.util.Log
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.core.graphics.drawable.toBitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvi_dummy.MVI.AppContentMVI.MviIntent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import coil.ImageLoader
import coil.request.ImageRequest
import coil.request.SuccessResult
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginScreenViewModel @Inject constructor(): ViewModel() {
    private val _intents = Channel<LoginScreenIntent>(Channel.UNLIMITED)
    private val _state = MutableStateFlow(LoginScreenState())
    val state: StateFlow<LoginScreenState> = _state.asStateFlow()
    private lateinit var context: Context

    init {
        viewModelScope.launch {
            _intents.consumeAsFlow().collect { intent ->
                when (intent) {
                    is LoginScreenIntent.LoadImage -> loadImage(context)
                    is LoginScreenIntent.LoadScreen -> loadUser()

                    // Handle other intents
                }
            }
        }
    }

    fun sendIntent(intent: LoginScreenIntent, context: Context? = null) {
        when (intent) {
            is LoginScreenIntent.LoadImage -> {
                if (context != null) {
                    loadImage(context)
                } else {
                    Log.e("LoginScreenViewModel", "Context not provided for LoadImage")
                }
            }
            else -> _intents.trySend(intent)
        }
    }
    private fun loadUser() {
        // TODO later
    }
    fun loadImage(context: Context) {
        val imageRequest = ImageRequest.Builder(context)
            .data("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTAOxglmJbrVRHbcbUuxsgxM2Z8I14h-4igjQ&s")
            .target(
                onSuccess = { result ->

                    _state.value = _state.value.copy(
                        loadedImage = result.toBitmap().asImageBitmap()
                    )
                },
                onError = { _ ->
                    _state.value = _state.value.copy(error = "Failed to load image")
                }
            )
            .build()

        ImageLoader(context).enqueue(imageRequest)
    }

}