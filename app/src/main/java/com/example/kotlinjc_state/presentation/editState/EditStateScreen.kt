package com.example.kotlinjc_state.presentation.editState

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import kotlinx.serialization.Serializable

@Serializable
object EditState
@Composable
fun EditStateScreen(
    innerPadding: PaddingValues,
    counter: Int,
    onGoBack: () -> Unit,
    onIncrement: () -> Unit,
    onDecrement: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.verticalGradient(
                colors = listOf(
                    Color(255, 192, 65),
                    Color(205, 220, 129, 255)
                )
            ))
            .padding(innerPadding)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp)
        ) {
            Button(onClick = onGoBack) {
                Text("Go back")
            }
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .align(Alignment.Center)
        ) {
            Text("$counter")

            Button(onClick = onIncrement) {
                Text("Increment")
            }
            Button(onClick = onDecrement) {
                Text("Decrement")
            }
        }
    }
}


@PreviewScreenSizes
@Composable
fun EditStateScreenPreview() {
    EditStateScreen(
        innerPadding = PaddingValues(),
        counter = 1,
        onGoBack = {},
        onIncrement = {},
        onDecrement = {}
    )
}
