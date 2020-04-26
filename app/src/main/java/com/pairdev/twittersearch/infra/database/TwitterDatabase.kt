package com.pairdev.twittersearch.infra.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.pairdev.twittersearch.core.models.Tweet
import com.pairdev.twittersearch.core.models.TweetDao
import com.pairdev.twittersearch.core.models.User
import com.pairdev.twittersearch.core.models.UserDao

@Database(entities = [Tweet::class, User::class], version = 1)
abstract class TwitterDatabase : RoomDatabase() {

    abstract fun tweetDao(): TweetDao
    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: TwitterDatabase? = null

        fun getDatabase(context: Context): TwitterDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TwitterDatabase::class.java,
                    "twitter_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance
                return instance
            }
        }
    }
}