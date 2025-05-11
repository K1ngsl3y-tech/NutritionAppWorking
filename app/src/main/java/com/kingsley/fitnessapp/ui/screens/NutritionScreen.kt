package com.kingsley.fitnessapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun NutritionScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Text(
            text = "Your Daily Nutrition",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Meal Plan Section
        Text("Meal Plan", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
        MealCard("Breakfast", "Oatmeal, Banana, Coffee")
        MealCard("Lunch", "Grilled Chicken, Rice, Salad")
        MealCard("Dinner", "Steamed Fish, Veggies")
        MealCard("Snacks", "Nuts, Greek Yogurt")

        Spacer(modifier = Modifier.height(24.dp))

        // Calorie Tracker
        Text("Calorie Tracker", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
        LinearProgressIndicator(
            progress = 0.65f,
            color = Color.Red,
            trackColor = Color.Gray,
            modifier = Modifier.fillMaxWidth().height(10.dp).padding(vertical = 8.dp)
        )
        Text("1300 / 2000 kcal", color = Color.White)
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { /* TODO: Add calorie */ }, modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Icon(Icons.Default.Add, contentDescription = null)
            Spacer(modifier = Modifier.width(4.dp))
            Text("Add Calories")
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Macronutrient Breakdown
        Text("Macronutrient Breakdown", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
        MacroBar("Carbs", 0.7f, Color.Red)
        MacroBar("Proteins", 0.5f, Color.Green)
        MacroBar("Fats", 0.4f, Color.Blue)

        Spacer(modifier = Modifier.height(24.dp))

        // Water Tracker
        Text("Water Tracker", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
        Text("6 / 8 Glasses", color = Color.White)
        Button(onClick = { /* TODO: Add water */ }, modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Icon(Icons.Default.Add, contentDescription = null)
            Spacer(modifier = Modifier.width(4.dp))
            Text("Add Glass")
        }

        Spacer(modifier = Modifier.height(32.dp))
    }
}

@Composable
fun MealCard(title: String, items: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.DarkGray)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(title, fontSize = 18.sp, color = Color.White, fontWeight = FontWeight.Bold)
            Text(items, color = Color.White)
        }
    }
}

@Composable
fun MacroBar(name: String, progress: Float, color: Color) {
    Text(name, color = Color.White)
    LinearProgressIndicator(
        progress = progress,
        color = color,
        trackColor = Color.Gray,
        modifier = Modifier.fillMaxWidth().height(8.dp).padding(bottom = 12.dp)
    )
}
