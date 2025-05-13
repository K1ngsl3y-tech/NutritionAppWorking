package com.kingsley.fitnessapp.data



import com.kingsley.fitnessapp.data.UserData

class UserRepository {

    // Example function to get user data
    fun getUserData(): UserData {
        // Return mock data or fetch from database
        return UserData(name = "John Doe", goal = "Lose 5 kg")
    }
}
