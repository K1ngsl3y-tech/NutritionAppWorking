package com.kingsley.fitnessapp.ui.screens


import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.*

data class WorkoutLog(
    val title: String,
    val timestamp: String
)

class ProgressViewModel : ViewModel() {
    val workoutLogs = mutableStateListOf<WorkoutLog>()

    fun addLog(workoutTitle: String) {
        val timestamp = SimpleDateFormat("dd MMM yyyy - HH:mm", Locale.getDefault()).format(Date())
        workoutLogs.add(WorkoutLog(workoutTitle, timestamp))
    }
}
