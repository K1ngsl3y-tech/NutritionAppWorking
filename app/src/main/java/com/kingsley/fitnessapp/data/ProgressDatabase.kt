package com.kingsley.fitnessapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Progress::class], version = 1, exportSchema = false)
abstract class ProgressDatabase : RoomDatabase() {
    abstract fun progressDao(): ProgressDao



    companion object {
        @Volatile
        private var INSTANCE: ProgressDatabase? = null

        fun getDatabase(context: Context): ProgressDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProgressDatabase::class.java, // Ensure it's ProgressDatabase here
                    "progress_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}object DatabaseInstance {
    private var db: ProgressDatabase? = null

    fun getInstance(context: Context): ProgressDatabase {
        if (db == null) {
            db = Room.databaseBuilder(
                context.applicationContext,
                ProgressDatabase::class.java,
                "fitness_app_db"
            ).fallbackToDestructiveMigration() // This will destroy the old schema and recreate the database
                .build()
        }
        return db!!
    }
}

