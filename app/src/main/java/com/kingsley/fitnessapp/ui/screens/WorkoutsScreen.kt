package com.kingsley.fitnessapp.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

data class Workout(
    val id: Int,
    val name: String,
    val description: String,
    val duration: Int // make sure this field exists
)

@Composable
fun WorkoutsScreen(navController: NavController) {
    val sampleWorkouts = listOf(
        Workout(id = 1, name = "Morning Yoga", description = "Start your day fresh with yoga.", duration = 20),
        Workout(id = 2, name = "HIIT", description = "High intensity interval training.", duration = 15),
        Workout(id = 3, name = "Strength Training", description = "Build strength with resistance.", duration = 30)
    )

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Workouts", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        sampleWorkouts.forEach { workout ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .clickable {
                        navController.navigate("workout_detail/${workout.id}")
                    }
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = workout.name, style = MaterialTheme.typography.titleLarge)
                    Text(text = workout.description, style = MaterialTheme.typography.bodyMedium)
                    Text(text = "Duration: ${workout.duration} minutes", style = MaterialTheme.typography.bodySmall)
                }
            }
        }
    }
}
