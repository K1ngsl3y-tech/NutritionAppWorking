package com.kingsley.fitnessapp.ui.screens



import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SettingsViewModel : ViewModel() {
    private val _userProfile = MutableLiveData<UserProfile>()
    val userProfile: LiveData<UserProfile> = _userProfile

    private val _isDarkMode = MutableStateFlow(false)
    val isDarkMode: StateFlow<Boolean> = _isDarkMode

    private val _notificationsEnabled = MutableStateFlow(true)
    val notificationsEnabled: StateFlow<Boolean> = _notificationsEnabled

    private val _dailyCalorieGoal = MutableStateFlow("2500")
    val dailyCalorieGoal: StateFlow<String> = _dailyCalorieGoal

    init {
        // Load settings from database or shared preferences
        loadUserSettings()
    }

    private fun loadUserSettings() {
        // Simulate loading user settings from the database
        _userProfile.value = UserProfile("John Doe", "https://example.com/profile.jpg")
        _isDarkMode.value = false
        _notificationsEnabled.value = true
        _dailyCalorieGoal.value = "2500"
    }

    fun toggleDarkMode(isEnabled: Boolean) {
        _isDarkMode.value = isEnabled
        // Save to shared preferences or database
    }

    fun toggleNotifications(isEnabled: Boolean) {
        _notificationsEnabled.value = isEnabled
        // Save to shared preferences or database
    }

    fun updateDailyCalorieGoal(goal: String) {
        _dailyCalorieGoal.value = goal
        // Save to database
    }

    fun logout() {
        // Handle logout logic
    }

    fun resetAppData() {
        // Reset user data logic (e.g., delete progress, reset settings)
    }
}

data class UserProfile(val username: String, val profilePictureUrl: String)

