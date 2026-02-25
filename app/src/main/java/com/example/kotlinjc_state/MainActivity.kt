package com.example.kotlinjc_state

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.kotlinjc_state.presentation.editState.EditState
import com.example.kotlinjc_state.presentation.editState.EditStateScreen
import com.example.kotlinjc_state.presentation.route.Route
import com.example.kotlinjc_state.presentation.route.RouteScreen
import com.example.kotlinjc_state.presentation.state.StateScreen
import com.example.kotlinjc_state.presentation.state.State
import com.example.kotlinjc_state.presentation.state.StateViewModel
import com.example.kotlinjc_state.ui.theme.KotlinJCStateTheme
import kotlinx.serialization.Serializable

@Serializable
object StateFlow
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinJCStateTheme {
                val navController = rememberNavController()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = Route
                    ) {
                        composable<Route> { 
                            RouteScreen(
                                onNavigateToStateFlow = { navController.navigate(StateFlow) },
                                innerPadding = innerPadding
                            )
                        }

                        navigation<StateFlow>(startDestination = State) {
                            composable<State> { backStackEntry ->
                                val parentEntry = remember(backStackEntry) {
                                    navController.getBackStackEntry(StateFlow)
                                }
                                val vm: StateViewModel = viewModel(parentEntry)

                                StateScreen(
                                    counter = vm.state,
                                    onGoBack = { navController.popBackStack() },
                                    onEdit = { navController.navigate(EditState) },
                                    innerPadding = innerPadding
                                )
                            }

                            composable<EditState> { backStackEntry ->
                                val parentEntry = remember(backStackEntry) {
                                    navController.getBackStackEntry(StateFlow)
                                }
                                val vm: StateViewModel = viewModel(parentEntry)

                                EditStateScreen(
                                    innerPadding = innerPadding,
                                    counter = vm.state,
                                    onGoBack = { navController.popBackStack() },
                                    onIncrement = { vm.increment() },
                                    onDecrement = { vm.decrement() }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
