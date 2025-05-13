package com.kingsley.fitnessapp.ui.screens

import ProgressViewModel
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kingsley.fitnessapp.data.Progress
import kotlinx.coroutines.launch

@Composable
fun ProgressScreen(progressViewModel: ProgressViewModel = viewModel()) {
    var activity by remember { mutableStateOf("") }
    var duration by remember { mutableStateOf("") }
    var distance by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    val coroutineScope = rememberCoroutineScope()

    val primaryColor = Color(0xFF3A8DFF)
    val backgroundColor = Color(0xFFF9FAFB)
    val textFieldBgColor = Color.White
    val errorColor = Color(0xFFD32F2F)
    val cardColor = Color(0xFFE3F2FD)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(24.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // HEADER
        Text(
            text = "Track Your Progress",
            color = primaryColor,
            fontSize = 26.sp,
            modifier = Modifier.padding(bottom = 20.dp),
            style = MaterialTheme.typography.headlineMedium
        )

        // INPUT FIELDS
        OutlinedTextField(
            value = activity,
            onValueChange = { activity = it },
            label = { Text("Activity") },
            modifier = Modifier
                .fillMaxWidth()
                .background(textFieldBgColor, RoundedCornerShape(8.dp)),
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = primaryColor,
                unfocusedBorderColor = Color.LightGray,
                cursorColor = primaryColor
            )
        )
        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = duration,
            onValueChange = { duration = it },
            label = { Text("Duration (minutes)") },
            modifier = Modifier
                .fillMaxWidth()
                .background(textFieldBgColor, RoundedCornerShape(8.dp)),
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = primaryColor,
                unfocusedBorderColor = Color.LightGray,
                cursorColor = primaryColor
            )
        )
        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = distance,
            onValueChange = { distance = it },
            label = { Text("Distance (km)") },
            modifier = Modifier
                .fillMaxWidth()
                .background(textFieldBgColor, RoundedCornerShape(8.dp)),
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = primaryColor,
                unfocusedBorderColor = Color.LightGray,
                cursorColor = primaryColor
            )
        )
        Spacer(modifier = Modifier.height(20.dp))

        // SAVE BUTTON
        Button(
            onClick = {
                if (activity.isNotEmpty() && duration.isNotEmpty() && distance.isNotEmpty()) {
                    coroutineScope.launch {
                        val progress = Progress(
                            activity = activity,
                            duration = duration,
                            distance = distance,
                            value = "0",
                            unit = "km",
                            calories = 0,
                            protein = 0,
                            carbs = 0,
                            fats = 0,
                            goalAchieved = false,
                            date = "" // TODO: Add proper date
                        )
                        progressViewModel.addNewProgress(progress)
                        errorMessage = ""
                        activity = ""
                        duration = ""
                        distance = ""
                    }
                } else {
                    errorMessage = "Please fill in all fields"
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = primaryColor),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("Save Progress", color = Color.White, fontSize = 16.sp)
        }

        if (errorMessage.isNotEmpty()) {
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = errorMessage, color = errorColor)
        }

        Spacer(modifier = Modifier.height(24.dp))

        // DAILY SUMMARY CARD
        Card(
            colors = CardDefaults.cardColors(containerColor = cardColor),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Today’s Summary", fontSize = 18.sp, color = primaryColor)
                Spacer(modifier = Modifier.height(12.dp))
                Text("Calories: 500 kcal")
                Text("Steps: 7,000")
                Text("Water Intake: 2.0 L")
                Text("Workout Duration: 45 mins")
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // PROGRESS CHART PLACEHOLDER
        Card(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Text(
                    "Progress Chart (Coming Soon)",
                    color = Color.Gray,
                    textAlign = TextAlign.Center
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // BADGES
        Text(
            text = "Badges Earned",
            color = primaryColor,
            fontSize = 18.sp,
            modifier = Modifier.align(Alignment.Start)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            BadgeItem("🔥", "Consistency")
            BadgeItem("🏅", "Goal Smasher")
            BadgeItem("💧", "Hydration Pro")
        }

        Spacer(modifier = Modifier.height(24.dp))

        // GOAL TRACKER
        Text(
            text = "Goal Tracker",
            color = primaryColor,
            fontSize = 18.sp,
            modifier = Modifier.align(Alignment.Start)
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            GoalTracker("Steps", 7000, 10000)
            GoalTracker("Calories", 500, 700)
            GoalTracker("Water", 2, 3)
        }
    }
}

@Composable
fun BadgeItem(emoji: String, label: String, modifier: Modifier = Modifier) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(12.dp),
        modifier = modifier
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(12.dp)
        ) {
            Text(text = emoji, fontSize = 28.sp)
            Text(text = label, fontSize = 14.sp, color = Color.Gray)
        }
    }
}


@Composable
fun GoalTracker(label: String, current: Int, goal: Int) {
    Column {
        Text("$label: $current / $goal", fontSize = 14.sp)
        LinearProgressIndicator(
            progress = current.toFloat() / goal,
            color = Color(0xFF3A8DFF),
            trackColor = Color.LightGray,
            modifier = Modifier.fillMaxWidth().height(6.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProgressScreen() {
    ProgressScreen()
}
