package com.kingsley.fitnessapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.kingsley.fitnessapp.ui.screens.SettingsViewModel

@Composable
fun SettingsScreen(navController: NavController, settingsViewModel: SettingsViewModel = viewModel()) {
    val userProfile by settingsViewModel.userProfile.observeAsState(null)
    val isDarkMode = settingsViewModel.isDarkMode.collectAsState(initial = false)
    val notificationsEnabled = settingsViewModel.notificationsEnabled.collectAsState(initial = true)
    val dailyGoal by settingsViewModel.dailyCalorieGoal.collectAsState(initial = "2500")

    val primaryColor = Color(0xFF4A90E2)
    val backgroundColor = Color(0xFFF5F8FA)
    val textColor = Color(0xFF2C3E50)

    val username = userProfile?.username ?: "John Doe"
    val profilePicture = userProfile?.profilePictureUrl ?: "https://example.com/default-profile.jpg"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(20.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Settings",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = primaryColor
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text("User Profile", fontSize = 22.sp, fontWeight = FontWeight.Bold, color = textColor)
        Spacer(modifier = Modifier.height(8.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = rememberAsyncImagePainter(profilePicture),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = username,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                color = textColor
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text("Theme Settings", fontSize = 22.sp, fontWeight = FontWeight.Bold, color = textColor)
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Dark Mode", fontSize = 18.sp)
            Switch(
                checked = isDarkMode.value,
                onCheckedChange = { settingsViewModel.toggleDarkMode(it) },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = primaryColor,
                    uncheckedThumbColor = Color.Gray
                )
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text("Notifications", fontSize = 22.sp, fontWeight = FontWeight.Bold, color = textColor)
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Enable Notifications", fontSize = 18.sp)
            Switch(
                checked = notificationsEnabled.value,
                onCheckedChange = { settingsViewModel.toggleNotifications(it) },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = primaryColor,
                    uncheckedThumbColor = Color.Gray
                )
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text("Goal Settings", fontSize = 22.sp, fontWeight = FontWeight.Bold, color = textColor)
        Spacer(modifier = Modifier.height(8.dp))
        Text("Set Daily Calorie Goal", fontSize = 18.sp)
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = dailyGoal,
            onValueChange = { settingsViewModel.updateDailyCalorieGoal(it) },
            label = { Text("Calories") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = primaryColor,
                unfocusedBorderColor = Color.Gray,
                cursorColor = primaryColor
            )
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { settingsViewModel.logout() },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = primaryColor),
            shape = MaterialTheme.shapes.medium
        ) {
            Text("Logout", color = Color.White, fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { settingsViewModel.resetAppData() },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
            shape = MaterialTheme.shapes.medium
        ) {
            Text("Reset App Data", color = Color.White, fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(32.dp))
    }
}
