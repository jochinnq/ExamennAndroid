package com.example.examenandroidactivity.pokeDao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.examenandroidactivity.adapter.UserEntity

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserEntity)

    @Query("SELECT * FROM user_table WHERE id = :userId")
    fun getUser(userId: Int): UserEntity
}