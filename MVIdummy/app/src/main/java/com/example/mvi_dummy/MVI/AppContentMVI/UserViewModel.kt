package com.example.mvi_dummy.MVI.AppContentMVI

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {
    private val _intents = Channel<MviIntent>(Channel.UNLIMITED)
    private val _state = MutableStateFlow(UserViewState())
    val state: StateFlow<UserViewState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _intents.consumeAsFlow().collect { intent ->
                when (intent) {
                    is MviIntent.LoadUser -> loadUser()
                }
            }
        }
    }

    private fun loadUser() {
        viewModelScope.launch {
            _state.value = UserViewState(isLoading = true)
            try {
                delay(2000)  // Simulate network delay
                _state.value = UserViewState(userName = "John Doe")
            } catch (e: Exception) {
                _state.value = UserViewState(error = "Failed to load user")
            }
        }
    }

    fun processIntent(intent: MviIntent) {
        _intents.trySend(intent)
    }
}
