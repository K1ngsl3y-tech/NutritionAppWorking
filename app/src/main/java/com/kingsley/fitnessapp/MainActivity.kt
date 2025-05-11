package com.kingsley.fitnessapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kingsley.fitnessapp.ui.screens.*
import com.kingsley.fitnessapp.ui.theme.FitnessAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            setContent {
                FitnessApp()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}

@Composable
fun FitnessApp() {
    val navController = rememberNavController()

    FitnessAppTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            NavHost(navController = navController, startDestination = Route.Splash) {
                composable(Route.Splash) { SplashScreen(navController) }
                composable(Route.Login) { LoginScreen(navController) }
                composable(Route.Register) { RegisterScreen(navController) }
                composable(Route.Home) { HomeScreen(navController) }
                composable(Route.Progress) { ProgressScreen() } // 👈 Fixed
                composable(Route.Settings) { SettingsScreen() }
                composable(Route.Nutrition) { NutritionScreen(navController) }
                composable(Route.Calendar) { CalendarScreen(navController) }
            }

        }
    }
}
