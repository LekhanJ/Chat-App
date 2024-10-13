package com.zorojuro.chatapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.zorojuro.chatapp.screens.LoginScreen
import com.zorojuro.chatapp.screens.SignUpScreen
import com.zorojuro.chatapp.ui.theme.ChatAppTheme

sealed class DestinationScreen(var route : String) {
    object SignUp : DestinationScreen("signup")
    object LogIn : DestinationScreen("login")
    object Profile : DestinationScreen("profile")
    object ChatList : DestinationScreen("chatlist")
    object SingleChat : DestinationScreen("singlechat/{chatId}") {
        fun createRoute(id: String) = "singlechat/$id"
    }
    object StatusList : DestinationScreen("statuslist")
    object SingleStatus : DestinationScreen("singlestatus/{userId}") {
        fun createRoute(userId: String) = "singlestatus/$userId"
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChatAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ChatAppNavigation()
                }
            }
        }
    }

    @Composable
    fun ChatAppNavigation() {
        val navController = rememberNavController()
        val viewModel = hiltViewModel<ChatViewModel>()
        NavHost(navController = navController, startDestination = DestinationScreen.SignUp.route) {
            composable(DestinationScreen.SignUp.route) {
                SignUpScreen(navController, viewModel)
            }

            composable(DestinationScreen.LogIn.route) {
                LoginScreen(navController)
            }
        }
    }
}