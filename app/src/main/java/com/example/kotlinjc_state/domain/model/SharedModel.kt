package com.example.kotlinjc_state.domain.model

import java.util.UUID

data class SharedModel (
    val id: UUID,
    val name: String,
    val version: Int,
    val subVersion: Int,
    val inUse: Boolean
)