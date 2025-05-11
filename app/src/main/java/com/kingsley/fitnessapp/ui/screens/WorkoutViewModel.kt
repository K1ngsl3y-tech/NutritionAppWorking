package com.kingsley.fitnessapp.ui.screens

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.kingsley.fitnessapp.data.Workout
import com.kingsley.fitnessapp.data.WorkoutDao
import com.kingsley.fitnessapp.data.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WorkoutViewModel(application: Application) : AndroidViewModel(application) {

    private val workoutDao: WorkoutDao = AppDatabase.getDatabase(application).workoutDao()

    private val _workouts = MutableLiveData<List<Workout>>()
    val workouts: LiveData<List<Workout>> get() = _workouts

    fun insert(workout: Workout) {
        viewModelScope.launch(Dispatchers.IO) {
            workoutDao.insert(workout)
        }
    }

    fun getAllWorkouts() {
        viewModelScope.launch(Dispatchers.IO) {
            val workoutList = workoutDao.getAllWorkouts()
            _workouts.postValue(workoutList)
        }
    }
}
