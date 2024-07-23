package com.example.myapplication.data

import com.example.myapplication.data.model.UserModel
import java.io.IOException
import java.util.UUID

/**
 * This class aims to be the actual API implementation
 */
class LoginDataSource {

    fun login(username: String, password: String): Result<UserModel> {
        try {
            val fakeUserModel = UserModel(UUID.fromString(username).toString(), username)
            return Result.Success(fakeUserModel)
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() = Unit
}