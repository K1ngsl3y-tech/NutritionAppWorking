package com.kingsley.fitnessapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kingsley.fitnessapp.R

@Composable
fun SettingsScreen() {
    var isDarkTheme by remember { mutableStateOf(false) }
    var workoutNotifs by remember { mutableStateOf(true) }
    var nutritionNotifs by remember { mutableStateOf(true) }
    var reminders by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.Black)
    ) {
        // Profile Header
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Profile Image",
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text("Kingsley Solomon", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text("xxxsoloxxxgamer@gmail.com", color = Color.Gray, fontSize = 14.sp)
            }
        }

        Divider(color = Color.Gray)

        // Theme
        SettingToggleItem("Dark Mode", isDarkTheme) { isDarkTheme = it }

        // Notifications
        SettingToggleItem("Workout Notifications", workoutNotifs) { workoutNotifs = it }
        SettingToggleItem("Nutrition Notifications", nutritionNotifs) { nutritionNotifs = it }
        SettingToggleItem("Reminder Alerts", reminders) { reminders = it }

        // Preferences
        SettingItem("Units: Kilograms") {}
        SettingItem("Language: English") {}

        // Account & Feedback
        SettingItem("Change Password") {}
        SettingItem("Privacy Settings") {}
        SettingItem("Rate the App") {}
        SettingItem("Send Feedback") {}

        // About
        SettingItem("App Version: 1.0.0") {}
        SettingItem("About Developer") {}

        Spacer(modifier = Modifier.height(20.dp))

        // Logout Button
        Button(
            onClick = { /* Log out logic */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD32F2F)),
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("Logout", color = Color.White)
        }
    }
}

@Composable
fun SettingToggleItem(title: String, value: Boolean, onToggle: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(title, color = Color.White, fontSize = 16.sp)
        Switch(checked = value, onCheckedChange = onToggle)
    }
}

@Composable
fun SettingItem(title: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(title, color = Color.White, fontSize = 16.sp)
    }
}
