package com.kevin.dstory.injection

import android.content.Context
import com.kevin.dstory.api.ApiConfig
import com.kevin.dstory.response.story.StoryRepository
import com.kevin.dstory.database.StoryDatabase

object StoryInjection {
    fun provideRepository(context: Context): StoryRepository {
        val apiService = ApiConfig.getApiService()
        val database = StoryDatabase.getDatabase(context)
        return StoryRepository(apiService, database)
    }
}