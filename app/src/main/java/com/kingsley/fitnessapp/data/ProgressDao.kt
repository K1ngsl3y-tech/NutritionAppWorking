package com.kingsley.fitnessapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProgressDao {

    @Insert
    suspend fun insert(progress: Progress)

    @Query("SELECT * FROM progress")
    fun getAllProgress(): LiveData<List<Progress>>  // Returns all progress data
}
