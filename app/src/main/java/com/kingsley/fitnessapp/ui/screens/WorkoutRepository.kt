package com.kingsley.fitnessapp.ui.screens

import android.app.Application
import com.kingsley.fitnessapp.data.Workout
import com.kingsley.fitnessapp.data.WorkoutDao
import com.kingsley.fitnessapp.data.AppDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WorkoutRepository(application: Application) {

    private val workoutDao: WorkoutDao = AppDatabase.getDatabase(application).workoutDao()

    fun insert(workout: Workout) {
        CoroutineScope(Dispatchers.IO).launch {
            workoutDao.insert(workout)
        }
    }

    fun getAllWorkouts() {
        CoroutineScope(Dispatchers.IO).launch {
            val workoutList = workoutDao.getAllWorkouts()
            // Do something with the list, e.g., update UI, etc.
        }
    }
}
