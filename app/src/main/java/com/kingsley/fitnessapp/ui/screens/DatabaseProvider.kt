package com.kingsley.fitnessapp.data

import android.content.Context

import androidx.room.Room

object DatabaseProvider {
    @Volatile
    private var INSTANCE: ProgressDatabase? = null

    fun getDatabase(context: Context): ProgressDatabase {
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                ProgressDatabase::class.java,
                "fitness_database"
            ).build()
            INSTANCE = instance
            instance
        }
    }
}
