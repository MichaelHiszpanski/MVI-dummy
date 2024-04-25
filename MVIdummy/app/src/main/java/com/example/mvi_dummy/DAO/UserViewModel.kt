package com.example.mvi_dummy.DAO

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModelDAO  @Inject constructor(private val dao: UserDao) : ViewModel() {


    // LiveData to observe users
    val users = mutableStateOf(listOf<User>())

    init {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                users.value = dao.getAllUsers()
            } catch (e: Exception) {
                Log.e("UserViewModel", "Error fetching users", e)
            }
        }
    }

    fun addUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.insertAll(user)
            users.value += user//dao.getAllUsers()
        }
    }

    fun deleteUsers() {
        viewModelScope.launch {
            dao.deleteAll()
            users.value = listOf()
        }
    }
}
