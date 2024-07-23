package com.example.myapplication.ui.login

/**
 * Ui State for the Login Page
 */
data class LoginUiState(
    val username: String? = null,
    val password: String? = null,
    val processError: String? = null,
    val isDataValid: Boolean = false
)