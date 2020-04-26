package com.pairdev.twittersearch.core.models

import androidx.room.*

@Entity
data class User(
    @PrimaryKey val idStr: String,
    val screenName: String,
    val profileImageUrlHttps: String
)

