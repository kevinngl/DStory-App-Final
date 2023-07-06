package com.kevin.dstory.viewmodel

import androidx.lifecycle.ViewModel
import com.kevin.dstory.response.story.StoryRepository

class MapsViewModel(private val storyRepo: StoryRepository) : ViewModel() {
    fun getStories(token: String) = storyRepo.getStoryLocation(token)
}