package com.example.ecomadmin.viewmodels

import androidx.lifecycle.ViewModel
import com.example.ecomadmin.repos.UserRepository

class UserViewModel : ViewModel() {
    val userRepository = UserRepository()

    fun getUser(userId: String) = userRepository.getUser(userId)
    fun getAllUser() = userRepository.getAllUser()

}