package com.example.lovecolculater.model.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.lovecolculater.model.Love
import dagger.Provides

@Dao
interface LoveDao {
    @Insert
    fun insert(love:Love?)

    @Delete
    fun delete(love: Love)

    @Query("SELECT*FROM love_table ")
    fun getAll():List<Love>

    @Query("SELECT * FROM love_table ORDER BY id DESC")
    fun getAllSort(): List<Love>
}