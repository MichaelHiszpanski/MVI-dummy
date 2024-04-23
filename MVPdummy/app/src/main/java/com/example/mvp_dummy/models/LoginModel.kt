package com.example.mvp_dummy.models

class LoginModel {
    fun validateUser(username: String, password: String): Boolean {
        return username == "admin" && password == "admin"
    }
}