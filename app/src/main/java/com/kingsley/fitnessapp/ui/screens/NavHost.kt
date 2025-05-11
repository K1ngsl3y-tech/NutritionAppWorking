package com.kingsley.fitnessapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kingsley.fitnessapp.ui.screens.*

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "splash"
    ) {
        composable("splash") {
            SplashScreen(navController)  // SplashScreen
        }
        composable("home") {
            HomeScreen(navController)  // HomeScreen
        }
        composable("workouts") {
            WorkoutsScreen(navController)  // WorkoutsScreen
        }
        composable("workout_detail/{workoutId}") { backStackEntry ->
            val workoutId = backStackEntry.arguments?.getString("workoutId")?.toIntOrNull()  // Safe conversion
            workoutId?.let {
                WorkoutDetailScreen(workoutId = it)  // Pass workoutId to WorkoutDetailScreen
            }
        }
    }
}
