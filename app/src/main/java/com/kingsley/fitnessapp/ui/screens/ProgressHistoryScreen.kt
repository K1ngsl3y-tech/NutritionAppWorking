package com.kingsley.fitnessapp.ui.screens

import android.os.Bundle
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun ProgressHistoryScreen(navController: NavController) {
    var weight by remember { mutableStateOf("") }
    var progressHistory = remember { mutableStateListOf<String>() }

    // Function to save the progress to history
    val saveProgress = {
        if (weight.isNotEmpty()) {
            progressHistory.add("Weight: $weight kg")
            weight = "" // Clear the input field after saving
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Title of the Progress Screen
        Text("Track Your Progress", style = MaterialTheme.typography.headlineLarge)

        Spacer(modifier = Modifier.height(32.dp))

        // BasicTextField for weight input
        BasicTextField(
            value = weight,
            onValueChange = { weight = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            decorationBox = { innerTextField ->
                Box(Modifier.padding(16.dp)) {
                    innerTextField()
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Button to save progress
        Button(onClick = saveProgress) {
            Text("Save Progress")
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Display the progress history
        Text("Progress History:")

        // Display each entry in the progress history list
        progressHistory.forEach {
            Text(it)
        }
    }
}

@Preview
@Composable
fun ProgressHistoryScreenPreview() {
    // Create a dummy NavController using rememberNavController for Preview purposes
    val navController = rememberNavController()
    ProgressHistoryScreen(navController = navController)
}
