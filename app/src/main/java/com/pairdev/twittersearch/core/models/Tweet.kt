package com.pairdev.twittersearch.core.models

import androidx.room.*

@Entity
data class Tweet(
    @PrimaryKey val idStr: String,
    val text: String,
    val user: User
)

