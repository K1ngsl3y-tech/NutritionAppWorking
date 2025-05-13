package com.kingsley.fitnessapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

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
              // WorkoutsScreen
        }
            }



