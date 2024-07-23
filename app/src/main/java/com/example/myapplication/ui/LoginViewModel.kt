package com.example.myapplication.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.domain.usecase.UserLoginUseCase

class LoginViewModel(val loginUseCase: UserLoginUseCase) : ViewModel() {

    private val _state: MutableLiveData<LoginUiState> = MutableLiveData(LoginUiState())
//    val state: LoginUiState = _state.value

    fun doLogin() {
        _state.value?.let {
            preLoginCheck(it.usename, it.password)
            loginUseCase.doLogin(it.usename, it.password)
        }
    }


    /**
     * this function will check that the user and password field are not empty or too short
     * otherwise it will raise an ui error and interrupt the login process
     */
    private fun preLoginCheck(usename: String, password: String) {}
    fun onNewUserName(text: String) {

    }

    fun onNewPassword(text: String) {

    }

    data class LoginUiState(
        val loading: Boolean = false,
        val usename: String = "",
        val password: String = ""
    )

}