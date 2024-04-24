package com.example.mvi_dummy.MVI.LoginMVI

import android.content.Context

sealed interface LoginScreenIntent {



        object LoadScreen : LoginScreenIntent
//        object Refresh :LoginScreenIntent
//        data class SubmitForm(val formData: String) :LoginScreenIntent
        object LoadImage : LoginScreenIntent

}