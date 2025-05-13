package com.kingsley.fitnessapp.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

data class UserData(val name: String, val goal: String)

class HomeViewModel : ViewModel() {

    val userData = mutableStateOf<UserData?>(UserData("Kingsley", "Lose weight"))

    val mealPlan = mutableStateOf(
        listOf("Oatmeal with fruit", "Grilled chicken salad", "Steamed vegetables", "Protein shake")
    )

    val dailyProgress = mutableStateOf(
        listOf("Workout complete", "Drank 2L water", "Ate 3 meals")
    )

    fun loadMealPlan() {
        // You could fetch this from a database instead
        mealPlan.value = listOf("Avocado Toast", "Tuna Wrap", "Quinoa Bowl", "Smoothie")
    }

    fun loadProgressData() {
        dailyProgress.value = listOf("Workout complete", "Drank 3L water", "Walked 5,000 steps")
    }

    fun setUserGoal(newGoal: String) {
        userData.value = userData.value?.copy(goal = newGoal)
    }
}
