package com.kingsley.fitnessapp.ui.screens

import android.os.Handler
import android.os.Looper
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.ui.res.painterResource
import com.kingsley.fitnessapp.R

@Composable
fun SplashScreen(navController: NavController) {
    var animateLogo by remember { mutableStateOf(false) }

    val scale = remember { Animatable(0f) }

    LaunchedEffect(animateLogo) {
        scale.animateTo(
            targetValue = 1f,
            animationSpec = tween(durationMillis = 1000, easing = FastOutSlowInEasing)
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_logo), // Replace with actual logo
            contentDescription = "Logo",
            modifier = Modifier.size(200.dp).scale(scale.value)
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = { navController.navigate(Route.Login) }) {
            Text("Get Started")
        }
    }

    // Simulate a splash screen timer before moving to the next screen
    Handler(Looper.getMainLooper()).postDelayed({
        navController.navigate(Route.Login)
    }, 3000)
}
