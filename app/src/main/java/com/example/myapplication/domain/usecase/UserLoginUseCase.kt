package com.example.myapplication.domain.usecase

import com.example.myapplication.domain.UserRepository

/**
This Use case has the purpose of handle the business logic of the login
This will actually execute the network call for verifying a valid login
 */
class UserLoginUseCase(val userRepository: UserRepository) {

    fun doLogin(username: String, password: String) {

    }

}