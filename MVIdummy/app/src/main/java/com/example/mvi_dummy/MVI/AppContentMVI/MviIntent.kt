package com.example.mvi_dummy.MVI.AppContentMVI

sealed interface MviIntent {
    object LoadUser : MviIntent
}