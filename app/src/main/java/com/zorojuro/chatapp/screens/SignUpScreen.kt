package com.zorojuro.chatapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.zorojuro.chatapp.ChatViewModel
import com.zorojuro.chatapp.DestinationScreen

@Composable
fun SignUpScreen(navController: NavController, viewModel: ChatViewModel) {
    Column (
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(60.dp))
        Text(text = "This is Signup Screen", modifier = Modifier.background(Color.Green))
        Spacer(modifier = Modifier.height(60.dp))
        Text(text = "Go to Login Page", modifier = Modifier.clickable {
            navController.navigate(DestinationScreen.LogIn.route)
        })
    }
}