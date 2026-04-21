package eu.tutorials.supabaseproject.model

import kotlinx.serialization.Serializable

@Serializable
data class Todo(
    val id: Int? = null,
    val title: String,
    val description: String? = null,
    val created_at: String? = null
)