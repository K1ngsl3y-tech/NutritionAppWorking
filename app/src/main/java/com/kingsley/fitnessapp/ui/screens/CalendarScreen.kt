package com.kingsley.fitnessapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Fireplace
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import java.time.*
import java.time.format.TextStyle
import java.util.*

@Composable
fun CalendarScreen(navController: NavController) {
    val today = remember { LocalDate.now() }
    val currentMonth = remember { YearMonth.now() }
    val daysInMonth = currentMonth.lengthOfMonth()
    val firstDayOfWeek = currentMonth.atDay(1).dayOfWeek.value % 7

    val selectedDate = remember { mutableStateOf(today) }

    val streak = 5  // Example streak
    val quote = "Push yourself, because no one else is going to do it for you."

    val dummyDayInfo = mapOf(
        today to "Workout: Full Body + Nutrition: Balanced Meal",
        today.minusDays(1) to "Rest Day",
        today.minusDays(2) to "Workout: Cardio + Nutrition: High Protein"
    )

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* Add action */ },
                containerColor = Color.Red,
                contentColor = Color.White
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add Activity")
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            Text(
                text = currentMonth.month.getDisplayName(TextStyle.FULL, Locale.getDefault()) + " ${currentMonth.year}",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Weekday headers
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                listOf("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat").forEach {
                    Text(text = it, fontSize = 12.sp, color = Color.Gray)
                }
            }

            Spacer(modifier = Modifier.height(4.dp))

            // Calendar Grid
            LazyVerticalGrid(
                columns = GridCells.Fixed(7),
                userScrollEnabled = false,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(320.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp),
                horizontalArrangement = Arrangement.spacedBy(6.dp),
            ) {
                // Empty cells before 1st day
                items(firstDayOfWeek) {
                    Box(modifier = Modifier.size(36.dp))
                }

                // Days
                items(daysInMonth) { dayIndex ->
                    val date = currentMonth.atDay(dayIndex + 1)
                    val isSelected = selectedDate.value == date

                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(42.dp)
                            .clip(CircleShape)
                            .background(
                                when {
                                    isSelected -> Color.Red
                                    dummyDayInfo.containsKey(date) -> Color.DarkGray
                                    else -> Color.Black
                                }
                            )
                            .clickable { selectedDate.value = date }
                    ) {
                        Text(
                            text = "${dayIndex + 1}",
                            color = Color.White,
                            fontSize = 14.sp
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Summary for selected day
            Text(
                text = "Summary for ${selectedDate.value.dayOfMonth} ${selectedDate.value.month.name.lowercase().replaceFirstChar { it.uppercase() }}:",
                style = MaterialTheme.typography.titleMedium,
                color = Color.White
            )
            Text(
                text = dummyDayInfo[selectedDate.value] ?: "No activity logged.",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.LightGray,
                modifier = Modifier.padding(top = 4.dp, bottom = 12.dp)
            )

            // Streak Tracker
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Fireplace,
                    contentDescription = "Streak",
                    tint = Color.Red
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Current Streak: $streak days",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Motivational Quote
            Text(
                text = "🔥 Motivation",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = Color.Red
            )
            Text(
                text = quote,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}
