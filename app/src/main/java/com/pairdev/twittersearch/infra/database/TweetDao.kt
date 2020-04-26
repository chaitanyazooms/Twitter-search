package com.pairdev.twittersearch.infra.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pairdev.twittersearch.core.models.Tweet

@Dao
interface TweetDao {

    @Query("SELECT * FROM table_tweet")
    fun getAllTweets(): LiveData<List<Tweet>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(tweet: Tweet)

    @Query("DELETE FROM table_tweet")
    suspend fun deleteAll()
}
