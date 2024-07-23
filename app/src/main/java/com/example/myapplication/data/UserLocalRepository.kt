package com.example.myapplication.data

import com.example.myapplication.data.model.UserModel
import com.example.myapplication.domain.UserRepository

/**
 * This class aims to fake the login process allowing all
 */
class UserLocalRepository(val source: LoginDataSource) : UserRepository {

    var userModel: UserModel? = null
        private set
    val isLoggedIn: Boolean
        get() = userModel != null

    override fun logout() {
        userModel = null
        source.logout()
    }

    override fun login(username: String, password: String): Result<UserModel> {

        val result = source.login(username, password)

        when (result) {
            is Result.Success -> {

            }

            is Result.Error -> {

            }
        }

        return result
    }
}