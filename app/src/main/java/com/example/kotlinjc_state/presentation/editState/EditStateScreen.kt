package com.example.kotlinjc_state.presentation.editState

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
import androidx.compose.ui.tooling.preview.PreviewScreenSizes

@Composable
fun EditStateScreen(
    innerPadding: PaddingValues,
    counter: Int,
    onIncrement: () -> Unit,
    onDecrement: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
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


@PreviewScreenSizes
@Composable
fun EditStateScreenPreview() {
    EditStateScreen(
        innerPadding = PaddingValues(),
        counter = 1,
        onIncrement = {},
        onDecrement = {}
    )
}