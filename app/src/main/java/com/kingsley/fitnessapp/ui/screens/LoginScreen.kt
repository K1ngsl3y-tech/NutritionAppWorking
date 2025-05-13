package com.kingsley.fitnessapp.ui.screens

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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun LoginScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val primaryColor = Color(0xFF4A90E2)        // Soft blue
    val backgroundColor = Color(0xFFF6F9FC)     // Light gray background
    val textColor = Color(0xFF2C3E50)           // Dark slate for text
    val fieldColor = Color.White                // Clean input background

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(24.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome Back",
            color = primaryColor,
            fontSize = 30.sp,
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "Log in to your account to continue",
            color = textColor.copy(alpha = 0.7f),
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 8.dp, bottom = 24.dp)
        )

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier
                .fillMaxWidth()
                .background(fieldColor),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = primaryColor,
                unfocusedBorderColor = Color.Gray,
                cursorColor = primaryColor
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier
                .fillMaxWidth()
                .background(fieldColor),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = primaryColor,
                unfocusedBorderColor = Color.Gray,
                cursorColor = primaryColor
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { navController.navigate(Route.Home) },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = primaryColor),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("Login", color = Color.White, fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(10.dp))

        TextButton(onClick = { /* Forgot password logic */ }) {
            Text("Forgot Password?", color = primaryColor)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Divider(color = Color.LightGray, thickness = 1.dp)

        Spacer(modifier = Modifier.height(16.dp))

        TextButton(onClick = { navController.navigate(Route.Register) }) {
            Text("Don't have an account? Register", color = textColor)
        }
    }
}
