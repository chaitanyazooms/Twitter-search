package com.pairdev.twittersearch.core.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_tweet")
data class Tweet(
    @PrimaryKey val idStr: String,
    val text: String,
    @Embedded(prefix = "user_") val user: User
)
