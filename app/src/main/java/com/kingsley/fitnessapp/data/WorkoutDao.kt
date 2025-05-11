package com.kingsley.fitnessapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface WorkoutDao {

    @Insert
    suspend fun insert(workout: Workout)

    @Query("SELECT * FROM workout")
    suspend fun getAllWorkouts(): List<Workout>
}
