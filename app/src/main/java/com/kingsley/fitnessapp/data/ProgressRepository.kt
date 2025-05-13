package com.kingsley.fitnessapp.data

import androidx.lifecycle.LiveData

class ProgressRepository(private val progressDao: ProgressDao) {

    // Directly use the 'getAllProgress' method from the DAO
    fun getAllProgress(): LiveData<List<Progress>> {
        return progressDao.getAllProgress()
    }

    // Add new progress entry
    suspend fun addNewProgress(progress: Progress) {
        // This should be executed in a background thread, using coroutines.
        progressDao.insert(progress)
    }
}
