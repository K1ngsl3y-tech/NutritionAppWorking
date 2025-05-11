package com.kingsley.fitnessapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun ProgressScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {
        Text(
            text = "Your Progress",
            style = MaterialTheme.typography.headlineMedium,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Overview Cards
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            ProgressCard(title = "Workouts", value = "12", modifier = Modifier.weight(1f))
            ProgressCard(title = "Calories", value = "6.2k", modifier = Modifier.weight(1f))
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Weekly Chart
        Text("Weekly Activity", color = Color.White, style = MaterialTheme.typography.titleMedium)
        BarChartSample() // Replace with your chart composable

        Spacer(modifier = Modifier.height(24.dp))

        // Goal Tracker
        Text("Goal Tracker", color = Color.White, style = MaterialTheme.typography.titleMedium)
        GoalProgress(current = 4, total = 5)

        Spacer(modifier = Modifier.height(24.dp))

        // Streak Tracker
        StreakSection(streakDays = 7)

        Spacer(modifier = Modifier.height(24.dp))

        // Badges
        Text("Badges Earned", color = Color.White, style = MaterialTheme.typography.titleMedium)
        LazyRow {
            items((1..5).toList()) {
                BadgeItem(icon = Icons.Default.Star, label = "Level $it")
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Summary
        Text(
            "Great job! You're consistently staying on track. Keep pushing for your next milestone!",
            color = Color.White
        )
    }
}

@Composable
fun ProgressCard(title: String, value: String, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .padding(4.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1E1E))
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = title, color = Color.Gray)
            Text(
                text = value,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

@Composable
fun GoalProgress(current: Int, total: Int) {
    Column {
        LinearProgressIndicator(
            progress = current / total.toFloat(),
            color = Color.Red,
            trackColor = Color.Gray,
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
                .clip(RoundedCornerShape(10.dp))
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            "$current out of $total goals completed",
            color = Color.White
        )
    }
}

@Composable
fun StreakSection(streakDays: Int) {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF2C2C2C)),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text("🔥 Current Streak", color = Color.White, fontWeight = FontWeight.Bold)
            Text("$streakDays days in a row!", color = Color.Red, style = MaterialTheme.typography.titleLarge)
        }
    }
}

@Composable
fun BadgeItem(icon: ImageVector, label: String) {
    Column(
        modifier = Modifier
            .padding(end = 12.dp)
            .width(80.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = Color.Yellow,
            modifier = Modifier.size(40.dp)
        )
        Text(label, color = Color.White)
    }
}
