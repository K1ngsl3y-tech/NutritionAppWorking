package com.kingsley.fitnessapp.ui.screens

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CalendarScreen(navController: NavController) {
    val currentMonth = remember { mutableStateOf(LocalDate.now().month) }
    val currentYear = remember { mutableStateOf(LocalDate.now().year) }

    val daysInMonth = remember { mutableStateOf(getDaysInMonth(currentMonth.value, currentYear.value)) }
    val daySelected = remember { mutableStateOf<TextFieldValue>(TextFieldValue("")) }

    val primaryColor = Color(0xFF4A90E2) // Light Blue for primary color
    val backgroundColor = Color(0xFFF5F8FA) // Light gray background for softness
    val textColor = Color(0xFF2C3E50) // Dark gray text color for readability

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp)
    ) {
        // Header with navigation to the previous and next month
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(onClick = {
                currentMonth.value = currentMonth.value.minus(1)
                daysInMonth.value = getDaysInMonth(currentMonth.value, currentYear.value)
            }) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Previous Month", tint = primaryColor)
            }
            Text(
                text = "${currentMonth.value.name} ${currentYear.value}",
                style = MaterialTheme.typography.headlineMedium.copy(color = textColor) // Typography with color
            )
            IconButton(onClick = {
                currentMonth.value = currentMonth.value.plus(1)
                daysInMonth.value = getDaysInMonth(currentMonth.value, currentYear.value)
            }) {
                Icon(Icons.Default.ArrowForward, contentDescription = "Next Month", tint = primaryColor)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Days of the week header
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            listOf("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat").forEach {
                Text(text = it, style = MaterialTheme.typography.bodyMedium.copy(color = textColor)) // Correct typography
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Calendar Grid for days
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            for (week in daysInMonth.value.chunked(7)) {
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    week.forEach { day ->
                        DayBox(day = day, daySelected = daySelected, primaryColor = primaryColor)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Notes Section
        Text("Add your notes for the selected day:", style = MaterialTheme.typography.bodyMedium.copy(color = textColor)) // Typography with color
        BasicTextField(
            value = daySelected.value,
            onValueChange = { daySelected.value = it },
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            textStyle = MaterialTheme.typography.bodyMedium.copy(color = textColor) // Correct typography
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Buttons to navigate to other parts of the app
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = {
                    navController.navigate("Nutrition")
                },
                colors = ButtonDefaults.buttonColors(containerColor = primaryColor)
            ) {
                Text("View Nutrition Plan", color = Color.White)
            }

            Button(
                onClick = {
                    navController.navigate("Progress")
                },
                colors = ButtonDefaults.buttonColors(containerColor = primaryColor)
            ) {
                Text("Track Progress", color = Color.White)
            }
        }
    }
}

@Composable
fun DayBox(day: String?, daySelected: MutableState<TextFieldValue>, primaryColor: Color) {
    Box(
        modifier = Modifier
            .size(40.dp)
            .padding(4.dp)
            .background(
                color = Color.Gray.copy(alpha = 0.2f),
                shape = MaterialTheme.shapes.small
            )
            .clickable {
                day?.let {
                    daySelected.value = TextFieldValue("Notes for $it")
                }
            },
        contentAlignment = Alignment.Center
    ) {
        if (day != null) {
            Text(text = day, style = MaterialTheme.typography.bodyMedium.copy(color = primaryColor)) // Day text styled with primary color
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun getDaysInMonth(month: java.time.Month, year: Int): List<String> {
    val startOfMonth = LocalDate.of(year, month, 1)
    val endOfMonth = startOfMonth.withDayOfMonth(startOfMonth.lengthOfMonth())
    val daysInMonth = mutableListOf<String>()
    for (day in startOfMonth.dayOfWeek.value..endOfMonth.dayOfWeek.value) {
        daysInMonth.add(day.toString())
    }
    return daysInMonth
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun PreviewCalendarScreen() {
    CalendarScreen(navController = rememberNavController())
}
