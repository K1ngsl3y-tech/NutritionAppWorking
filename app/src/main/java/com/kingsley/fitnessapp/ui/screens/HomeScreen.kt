package com.kingsley.fitnessapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.kingsley.fitnessapp.ui.viewmodel.HomeViewModel

@Composable
fun HomeScreen(navController: NavController) {
    val homeViewModel: HomeViewModel = viewModel()
    val user = homeViewModel.userData.value
    val mealPlan = homeViewModel.mealPlan.value
    val progress = homeViewModel.dailyProgress.value

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(
                text = "Welcome, ${user?.name ?: "User"}",
                fontSize = 26.sp,
                color = Color.Red,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
            )
            Text(
                text = "Your goal: ${user?.goal ?: "Not set"}",
                fontSize = 18.sp,
                color = Color.LightGray
            )
        }

        item {
            OutlinedButton(
                onClick = { homeViewModel.setUserGoal("Gain Muscle") },
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White)
            ) {
                Text("Update Goal")
            }
        }

        item {
            SectionCard(title = "Today's Meal Plan") {
                mealPlan.forEach { meal ->
                    Text(
                        text = "• $meal",
                        fontSize = 16.sp,
                        color = Color.White,
                        modifier = Modifier.padding(bottom = 6.dp)
                    )
                }
                Button(
                    onClick = { homeViewModel.loadMealPlan() },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.padding(top = 12.dp)
                ) {
                    Text("Refresh Meal Plan", color = Color.White)
                }
            }
        }

        item {
            SectionCard(title = "Your Progress Today") {
                progress.forEach { item ->
                    Text(
                        text = "• $item",
                        fontSize = 16.sp,
                        color = Color.White,
                        modifier = Modifier.padding(bottom = 6.dp)
                    )
                }
                Button(
                    onClick = { homeViewModel.loadProgressData() },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.padding(top = 12.dp)
                ) {
                    Text("Refresh Progress", color = Color.White)
                }
            }
        }

        item {
            Text(
                text = "Explore More",
                fontSize = 20.sp,
                color = Color.Red,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
            )
        }

        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                NavigationButton("Progress", Icons.Default.FitnessCenter) {
                    navController.navigate("progress")
                }
                NavigationButton("Nutrition", Icons.Default.Restaurant) {
                    navController.navigate("nutrition")
                }
                NavigationButton("Calendar", Icons.Default.CalendarToday) {
                    navController.navigate("calendar")
                }
            }
        }

        item {
            Button(
                onClick = { navController.navigate("settings") },
                colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text("Go to Settings", color = Color.White)
            }
        }
    }
}

@Composable
fun SectionCard(title: String, content: @Composable ColumnScope.() -> Unit) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1C1C1C)),
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = title,
                fontSize = 20.sp,
                color = Color.Red,
                fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            content()
        }
    }
}

@Composable
fun NavigationButton(label: String, icon: androidx.compose.ui.graphics.vector.ImageVector, onClick: () -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        IconButton(
            onClick = onClick,
            modifier = Modifier
                .size(60.dp)
                .background(Color.DarkGray, RoundedCornerShape(12.dp))
        ) {
            Icon(icon, contentDescription = label, tint = Color.White)
        }
        Text(text = label, color = Color.White, fontSize = 14.sp)
    }
}
