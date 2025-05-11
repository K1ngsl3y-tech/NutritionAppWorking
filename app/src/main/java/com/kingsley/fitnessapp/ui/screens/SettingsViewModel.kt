package com.kingsley.fitnessapp.ui.screens



import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SettingsViewModel : ViewModel() {
    val isDarkMode = mutableStateOf(true)
    val notificationsEnabled = mutableStateOf(true)

    fun toggleDarkMode() {
        isDarkMode.value = !isDarkMode.value
    }

    fun toggleNotifications() {
        notificationsEnabled.value = !notificationsEnabled.value
    }
}
