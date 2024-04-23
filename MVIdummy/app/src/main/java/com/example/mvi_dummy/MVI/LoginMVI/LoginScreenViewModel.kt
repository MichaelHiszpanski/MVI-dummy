package com.example.mvi_dummy.MVI.LoginMVI

import androidx.lifecycle.ViewModel
import com.example.mvi_dummy.MVI.AppContentMVI.MviIntent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class LoginScreenViewModel : ViewModel() {
    private val _intents = Channel<MviIntent>(Channel.UNLIMITED)
    private val _state = MutableStateFlow(LoginScreenState())
    val state: StateFlow<LoginScreenState> = _state.asStateFlow()

}