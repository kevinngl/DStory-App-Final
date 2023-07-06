package com.kevin.dstory.model

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kevin.dstory.response.story.StoryRepository
import com.kevin.dstory.response.user.UserRepository
import com.kevin.dstory.injection.StoryInjection
import com.kevin.dstory.injection.UserInjection
import com.kevin.dstory.viewmodel.AddStoryViewModel
import com.kevin.dstory.viewmodel.MainViewModel
import com.kevin.dstory.viewmodel.MapsViewModel

class AddStoryModelFactory private constructor(private val userRepo: UserRepository, private val storyRepo: StoryRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                MainViewModel(userRepo, storyRepo) as T
            }
            modelClass.isAssignableFrom(AddStoryViewModel::class.java) -> {
                AddStoryViewModel(userRepo, storyRepo) as T
            }
            modelClass.isAssignableFrom(MapsViewModel::class.java) -> {
                MapsViewModel(storyRepo) as T
            }
            else -> {
                throw IllegalArgumentException("Illegal ViewModel class: " + modelClass.name)
            }
        }
    }

    companion object {
        @Volatile
        private var instance: AddStoryModelFactory? = null
        fun getInstance(context: Context): AddStoryModelFactory =
            instance ?: synchronized(this) {
                instance ?: AddStoryModelFactory(UserInjection.provideRepository(context),
                    StoryInjection.provideRepository(context))
            }.also { instance = it }
    }
}