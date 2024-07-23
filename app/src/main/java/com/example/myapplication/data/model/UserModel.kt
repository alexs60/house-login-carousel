package com.example.myapplication.data.model

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
data class UserModel(
    val userId: String,
    val displayName: String
)