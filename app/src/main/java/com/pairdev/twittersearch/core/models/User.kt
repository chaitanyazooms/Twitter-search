package com.pairdev.twittersearch.core.models

import androidx.lifecycle.LiveData
import androidx.room.*

@Entity
data class User(
    @PrimaryKey val idStr: String,
    val screenName: String,
    val profileImageUrlHttps: String
)

@Dao
interface UserDao {

    @Query("SELECT * FROM User")
    fun getAllUsers(): LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)

    @Query("DELETE FROM User")
    suspend fun deleteAll()
}