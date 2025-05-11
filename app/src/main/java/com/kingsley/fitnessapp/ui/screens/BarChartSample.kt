package com.kingsley.fitnessapp.ui.screens



import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BarChartSample(
    data: List<Int> = listOf(10, 30, 20, 50, 35, 40, 25),
    labels: List<String> = listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Weekly Calories",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(16.dp))

        val maxValue = data.maxOrNull() ?: 1
        val barWidth = 30.dp
        val spaceBetween = 16.dp

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            data.forEachIndexed { index, value ->
                Column(
                    verticalArrangement = Arrangement.Bottom,
                    modifier = Modifier.height(150.dp)
                ) {
                    Canvas(modifier = Modifier
                        .width(barWidth)
                        .weight(1f)
                    ) {
                        val barHeight = size.height * (value / maxValue.toFloat())
                        drawRoundRect(
                            color = Color.Red,
                            topLeft = Offset(0f, size.height - barHeight),
                            size = androidx.compose.ui.geometry.Size(size.width, barHeight),
                            cornerRadius = androidx.compose.ui.geometry.CornerRadius(8f, 8f)
                        )
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = labels[index], fontSize = 12.sp, color = Color.White)
                }
            }
        }
    }
}
