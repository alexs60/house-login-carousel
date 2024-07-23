package com.example.myapplication.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Patterns
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.Result
import com.example.myapplication.data.UserLocalRepository
import kotlinx.coroutines.launch


class LoginViewModel(private val userRepository: UserLocalRepository) : ViewModel() {

    private val _loginForm = MutableLiveData<LoginUiState>()
    val loginFormState: LiveData<LoginUiState> = _loginForm

    fun login(username: String, password: String) {

        viewModelScope.launch {
            val result = userRepository.login(username, password)

            if (result is Result.Success) {
                _loginForm.value = _loginForm.value?.copy(processError = null)
            } else {
                _loginForm.value = _loginForm.value?.copy(processError = "Login Error")
            }
        }
    }

    fun loginDataChanged(username: String, password: String) {
        if (!isUserNameValid(username)) {
            _loginForm.value = LoginUiState(processError = "Invalid username")
        } else if (!isPasswordValid(password)) {
            _loginForm.value = LoginUiState(processError = "Invalid Password")
        } else {
            _loginForm.value = LoginUiState(isDataValid = true)
        }
    }

    /**
     * username must be an email
     */
    private fun isUserNameValid(username: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(username).matches()
    }

    /**
     * password must be > 5
     */
    private fun isPasswordValid(password: String): Boolean {
        return password.length > 5
    }
}