package com.example.myapplication.domain

import com.example.myapplication.data.Result
import com.example.myapplication.data.model.UserModel

interface UserRepository {

    fun login(username: String, password: String): Result<UserModel>
    fun logout()

}