package com.kingsley.fitnessapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun NutritionScreen(navController: NavHostController) {
    val backgroundColor = Color(0xFFF8F9FA)
    val titleColor = Color(0xFF2C3E50)
    val cardColor = Color(0xFFE9ECEF)
    val textColor = Color(0xFF343A40)
    val accentColor = Color(0xFF1ABC9C) // Teal

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Text(
                text = "Nutrition Overview",
                fontSize = 28.sp,
                color = accentColor,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }

        item {
            SectionCard(
                title = "Macronutrients",
                contentList = listOf(
                    "Protein: Helps with muscle growth and repair.",
                    "Carbs: Provides energy for workouts.",
                    "Fats: Supports hormone health and energy."
                ),
                cardColor = cardColor,
                titleColor = titleColor,
                textColor = textColor
            )
        }

        item {
            SectionCard(
                title = "Recommended Meals",
                contentList = listOf(
                    "Breakfast: Oatmeal, banana, eggs.",
                    "Lunch: Grilled chicken, brown rice, veggies.",
                    "Snack: Greek yogurt with berries.",
                    "Dinner: Salmon, sweet potatoes, spinach.",
                    "Post Workout: Protein shake and banana."
                ),
                cardColor = cardColor,
                titleColor = titleColor,
                textColor = textColor
            )
        }

        item {
            SectionCard(
                title = "Hydration",
                contentList = listOf(
                    "Drink 2–3L of water daily.",
                    "Hydrate more if you're training.",
                    "Add lemon or cucumber for flavor."
                ),
                cardColor = cardColor,
                titleColor = titleColor,
                textColor = textColor
            )
        }

        item {
            SectionCard(
                title = "Tips",
                contentList = listOf(
                    "Avoid skipping meals.",
                    "Track your calories and macros.",
                    "Eat whole foods, avoid processed junk.",
                    "Plan your meals ahead of time.",
                    "Use a food diary or app to monitor intake.",
                    "Don't fear healthy fats like avocado and nuts.",
                    "Balance your meals with protein, carbs and fats.",
                    "Avoid sugary drinks—choose water or tea instead.",
                    "Cheat meals are okay in moderation.",
                    "Consistency beats perfection."
                ),
                cardColor = cardColor,
                titleColor = titleColor,
                textColor = textColor
            )
        }

        item {
            SectionCard(
                title = "Superfoods to Try",
                contentList = listOf(
                    "Avocados", "Quinoa", "Blueberries", "Chia seeds", "Kale",
                    "Sweet potatoes", "Almonds", "Eggs", "Green tea", "Salmon"
                ),
                cardColor = cardColor,
                titleColor = titleColor,
                textColor = textColor
            )
        }
    }
}

@Composable
fun SectionCard(
    title: String,
    contentList: List<String>,
    cardColor: Color,
    titleColor: Color,
    textColor: Color
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = cardColor),
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = title, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = titleColor)
            Spacer(modifier = Modifier.height(8.dp))
            contentList.forEach {
                Text(text = "• $it", fontSize = 16.sp, color = textColor, modifier = Modifier.padding(bottom = 4.dp))
            }
        }
    }
}
