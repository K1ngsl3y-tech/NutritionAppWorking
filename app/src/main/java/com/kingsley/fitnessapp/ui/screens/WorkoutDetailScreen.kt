package com.kingsley.fitnessapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kingsley.fitnessapp.data.Workout  // Import the Workout class

@Composable
fun WorkoutDetailScreen(workoutId: Int) {
    // Sample list of workouts (this would usually come from a database)
    val sampleWorkouts = listOf(
        Workout(id = 1, name = "Morning Yoga", description = "Start your day fresh with yoga.", duration = 20),
        Workout(id = 2, name = "HIIT", description = "High intensity interval training.", duration = 15),
        Workout(id = 3, name = "Strength Training", description = "Build strength with resistance.", duration = 30)
    )

    // Fetch the workout with the given workoutId (this can be replaced with a real data source)
    val workout = sampleWorkouts.find { it.id == workoutId }

    // If the workout is found, display its details
    workout?.let {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = it.name, style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Duration: ${it.duration} minutes", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Description: ${it.description}", style = MaterialTheme.typography.bodyMedium)
        }
    } ?: run {
        // If the workout is not found, show an error message
        Text(text = "Workout not found!", style = MaterialTheme.typography.headlineMedium)
    }
}

@Preview(showBackground = true)
@Composable
fun WorkoutDetailScreenPreview() {
    // Preview a workout detail screen with a workoutId of 1
    WorkoutDetailScreen(workoutId = 1)
}
