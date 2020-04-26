package com.pairdev.twittersearch.infra.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pairdev.twittersearch.core.models.User

@Dao
interface UserDao {

    @Query("SELECT * FROM User")
    fun getAllUsers(): LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)

    @Query("DELETE FROM User")
    suspend fun deleteAll()
}