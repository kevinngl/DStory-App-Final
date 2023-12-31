package com.kevin.dstory.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.kevin.dstory.response.story.StoryRepository
import com.kevin.dstory.response.user.UserRepository
import kotlinx.coroutines.launch

class MainViewModel(private val userRepo: UserRepository, private val storyRepo: StoryRepository) : ViewModel() {

    fun getToken() : LiveData<String> {
        return userRepo.getToken().asLiveData()
    }

    fun isLogin() : LiveData<Boolean> {
        return userRepo.isLogin().asLiveData()
    }

    fun logout() {
        viewModelScope.launch {
            userRepo.logout()
        }
    }

    fun getStories(token: String) = storyRepo.getStory(token)
}