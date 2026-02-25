package com.example.kotlinjc_state.presentation.route

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import kotlinx.serialization.Serializable

@Serializable
object Route

@Composable
fun RouteScreen(
    onNavigateToStateFlow: () -> Unit,
    innerPadding: PaddingValues
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.horizontalGradient(
                colors = listOf(
                    Color(255, 192, 65),
                    Color(250, 152, 65),
                    Color(250, 152, 65),
                    Color(red = 255, green = 255, blue = 255)
                )
            ))
            .padding(innerPadding)
    ) {
        Button(
            onClick = { onNavigateToStateFlow() }
        ) { Text("State") }
    }
}

@PreviewScreenSizes
@Composable
fun RoutePreview() {
    val paddingValues = PaddingValues()
    RouteScreen({}, paddingValues)
}