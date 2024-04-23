package com.example.mvi_dummy.MVI.LoginMVI

sealed interface LoginScreenIntent {

        object LoadScreen : LoginScreenIntent
        object Refresh :LoginScreenIntent
        data class SubmitForm(val formData: String) :LoginScreenIntent

}