package com.zorojuro.chatapp.screens

import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.zorojuro.chatapp.DestinationScreen

@Composable
fun LoginScreen(navController: NavController) {
    Column (
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(60.dp))
        Text("This is login screen", modifier = Modifier.background(Color.Blue))
        Spacer(modifier = Modifier.height(60.dp))
        Text(text = "Go to Signup Page", modifier = Modifier.clickable {
            navController.navigate(DestinationScreen.SignUp.route)
        })
    }
}