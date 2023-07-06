package com.kevin.dstory.viewmodel

import androidx.lifecycle.ViewModel
import com.kevin.dstory.response.user.UserRepository

class RegisterViewModel (private val repo: UserRepository) : ViewModel() {

    fun register(name: String, email: String, password: String) = repo.register(name, email, password)
}