package com.pairdev.twittersearch.core.models

import androidx.lifecycle.LiveData
import androidx.room.*

@Entity
data class Tweet(
    @PrimaryKey val idStr: String,
    val text: String,
    val user: User
)

@Dao
interface TweetDao {

    @Query("SELECT * FROM Tweet")
    fun getAllTweets(): LiveData<List<Tweet>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(tweet: Tweet)

    @Query("DELETE FROM Tweet")
    suspend fun deleteAll()
}