package com.pairdev.twittersearch.core.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//@Entity(tableName = "table_user")
data class User(
    @PrimaryKey val idStr: String,
    val screenName: String,
    val profileImageUrlHttps: String
)
