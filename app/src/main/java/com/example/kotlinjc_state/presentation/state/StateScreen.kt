package com.example.kotlinjc_state.presentation.state

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import kotlinx.serialization.Serializable

@Serializable
object State

@Composable
fun StateScreen(
    counter: Int,
    onGoBack: () -> Unit,
    onEdit: () -> Unit,
    innerPadding: PaddingValues
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.horizontalGradient(
                colors = listOf(
                    Color(red = 255, green = 202, blue = 40, alpha = 255),
                    Color(red = 106, green = 96, blue = 21, alpha = 255)
                )
            ))
            .padding(innerPadding)
            .padding(30.dp)
    ) {
        Button(
            onClick = { onGoBack() },
            modifier = Modifier
                .align(Alignment.TopStart)
        ) {
            Text("Go back")
        }

        Button(
            onClick = { onEdit() },
            modifier = Modifier
                .align(Alignment.TopEnd)
        ) {
            Text("Edit")
        }

        Text(
            text = "Counter: $counter",
            modifier = Modifier.align(Alignment.Center) // Centered the counter
        )
    }
}

@PreviewScreenSizes
@Composable
fun StateScreenPreview() {
    StateScreen(
        counter = 1,
        onGoBack = {},
        onEdit = {},
        innerPadding = PaddingValues()
    )
}
