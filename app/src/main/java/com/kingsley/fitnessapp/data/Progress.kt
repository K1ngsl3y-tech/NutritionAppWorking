package com.kingsley.fitnessapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "progress") // This defines the table name as "progress"
data class Progress(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val activity: String,
    val value: String,
    val unit: String,
    val calories: Int,
    val protein: Int,
    val carbs: Int,
    val fats: Int,
    val goalAchieved: Boolean,
    val date: String,
    val duration: String,  // Duration in minutes
    val distance: String   // Distance in kilometers

)

