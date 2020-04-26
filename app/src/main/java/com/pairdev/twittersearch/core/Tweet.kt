package com.pairdev.twittersearch.core

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Query

//@Entity
data class Tweet(
//    @PrimaryKey val idStr: String,
    val text: String,
    val user: User
)

//@Dao
interface TweetDao {

//    @Query("SELECT * FROM ")
    fun getAllTweets(): List<Tweet>
}