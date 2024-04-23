package com.example.mvi_dummy.MVI

data class UserViewState(
    val isLoading: Boolean = false,
    val userName: String? = null,
    val error: String? = null
)
