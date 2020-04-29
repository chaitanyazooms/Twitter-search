package com.pairdev.twittersearch.infra.di

import com.pairdev.twittersearch.infra.database.TweetDao
import com.pairdev.twittersearch.infra.database.TwitterDatabase
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule {

    @Provides
    fun provideTweetDao(database: TwitterDatabase): TweetDao {
        return database.tweetDao()
    }
}