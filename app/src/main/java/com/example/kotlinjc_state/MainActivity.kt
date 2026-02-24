package com.example.kotlinjc_state

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kotlinjc_state.presentation.editState.EditStateScreen
import com.example.kotlinjc_state.presentation.state.StateScreen
import com.example.kotlinjc_state.ui.theme.KotlinJCStateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinJCStateTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "home") {
                    composable("editState") {
                    }
                }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    StateScreen(innerPadding)
                }
            }
        }
    }
}