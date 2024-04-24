package com.example.mvi_dummy.MVI.LoginMVI

import androidx.compose.ui.graphics.ImageBitmap

data class LoginScreenState(
    val isLoading: Boolean = false,
    val userName: String? = null,
    val error: String? = null,
    val description: String? = null,
    val loadedImage: ImageBitmap? = null
)
