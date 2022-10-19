package com.example.kotlinnotes.data.model

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
data class LoggedInUser(
    val userId: String,
    val password: String,
    val displayName: String
)