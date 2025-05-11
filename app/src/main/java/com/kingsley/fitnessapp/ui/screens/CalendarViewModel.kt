package com.kingsley.fitnessapp.ui.screens



import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.*

data class ScheduledWorkout(
    val date: String, // "2025-05-10"
    val workout: String
)

class CalendarViewModel : ViewModel() {
    val scheduledWorkouts = mutableStateListOf<ScheduledWorkout>()

    fun addWorkout(date: String, workout: String) {
        scheduledWorkouts.add(ScheduledWorkout(date, workout))
    }

    fun getWorkoutsForDate(date: String): List<ScheduledWorkout> {
        return scheduledWorkouts.filter { it.date == date }
    }

    fun getAllDates(): List<String> {
        return scheduledWorkouts.map { it.date }.distinct()
    }
}
