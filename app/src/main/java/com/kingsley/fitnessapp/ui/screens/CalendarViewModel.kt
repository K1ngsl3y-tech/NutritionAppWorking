package com.kingsley.fitnessapp.ui.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import java.time.LocalDate

class CalendarViewModel : ViewModel() {
    // Mutable state to hold the selected date (current month by default)
    @RequiresApi(Build.VERSION_CODES.O)
    private val _selectedDate = mutableStateOf(LocalDate.now())
    @RequiresApi(Build.VERSION_CODES.O)
    val selectedDate: State<LocalDate> = _selectedDate

    // Function to change the selected month (increment or decrement)
    @RequiresApi(Build.VERSION_CODES.O)
    fun changeMonth(increment: Int) {
        _selectedDate.value = _selectedDate.value.plusMonths(increment.toLong())
    }

    // Function to reset the selected month to the current month
    @RequiresApi(Build.VERSION_CODES.O)
    fun setCurrentMonth() {
        _selectedDate.value = LocalDate.now()
    }
}
