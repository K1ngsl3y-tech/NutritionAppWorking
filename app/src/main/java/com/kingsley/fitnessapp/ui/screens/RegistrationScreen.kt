package com.kingsley.fitnessapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun RegisterScreen(navController: NavController) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Register", style = MaterialTheme.typography.headlineLarge)

        Spacer(modifier = Modifier.height(32.dp))

        BasicTextField(value = username, onValueChange = { username = it }, modifier = Modifier.fillMaxWidth(), decorationBox = { innerTextField ->
            Box(Modifier.padding(16.dp)) {
                innerTextField()
            }
        })

        Spacer(modifier = Modifier.height(16.dp))

        BasicTextField(value = password, onValueChange = { password = it }, modifier = Modifier.fillMaxWidth(), decorationBox = { innerTextField ->
            Box(Modifier.padding(16.dp)) {
                innerTextField()
            }
        })

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = { navController.navigate(Route.Login) }) {
            Text("Register")
        }
    }
}
