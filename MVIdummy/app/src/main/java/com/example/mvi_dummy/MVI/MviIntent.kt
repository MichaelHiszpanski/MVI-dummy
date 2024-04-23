package com.example.mvi_dummy.MVI

sealed interface MviIntent {
    object LoadUser : MviIntent
}