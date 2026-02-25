package com.example.kotlinjc_state.presentation.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class StateViewModel: ViewModel() {
    var state by mutableIntStateOf(0)
        private set

    fun increment() {
        state++
    }

    fun decrement() {
        state--
    }
}