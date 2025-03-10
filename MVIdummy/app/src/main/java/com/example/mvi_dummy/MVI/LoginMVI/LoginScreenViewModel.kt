package com.example.mvi_dummy.MVI.LoginMVI

import android.content.Context
import android.util.Log
import androidx.compose.ui.graphics.asImageBitmap
import androidx.core.graphics.drawable.toBitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import coil.ImageLoader
import coil.request.ImageRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginScreenViewModel @Inject constructor() : ViewModel() {
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

    fun processIntent(intent: LoginScreenIntent) {
        _intents.trySend(intent)
    }

    private fun loadUser() {
        // TODO later
    }

    fun loadImage(context: Context) {
        Log.d("LoginScreenViewModel 1==>", "Start")
        val imageRequest = ImageRequest.Builder(context)
            .data("https://cdn.pixabay.com/photo/2017/07/13/19/51/sunset-2501727_960_720.png")
            .target(
                onSuccess = { result ->

                    _state.value = _state.value.copy(
                        loadedImage = result.toBitmap().asImageBitmap()
                    )
                    Log.d("LoginScreenViewModel 2==>", "Start 2" + _state.value.toString())
                },
                onError = { _ ->
                    _state.value = _state.value.copy(error = "Failed to load image")
                }
            )
            .build()

        ImageLoader(context).enqueue(imageRequest)
    }

}
