package com.pairdev.twittersearch.infra.di

import android.content.Context
import com.pairdev.twittersearch.infra.database.TwitterDatabase
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule constructor(val applicationContext: Context) {

    @Provides
    fun provideApplicationContext(): Context {
        return applicationContext
    }

    @Provides
    fun provideTwitterDatabase(): TwitterDatabase {
        return TwitterDatabase.getDatabase(applicationContext)
    }
}
