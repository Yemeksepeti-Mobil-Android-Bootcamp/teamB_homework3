package com.example.teambhomework3.data

import com.example.teambhomework3.data.entity.login.LoginRequest
import com.example.teambhomework3.data.entity.register.RegisterRequest
import com.example.teambhomework3.data.local.LocalDataSource
import com.example.teambhomework3.data.remote.RemoteDataSource
import com.example.teambhomework3.utils.performAuthTokenNetworkOperation
import com.example.teambhomework3.utils.performNetworkOperation
import javax.inject.Inject

class ApiRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) {

    fun register(registerRequest: RegisterRequest)= performNetworkOperation {
        remoteDataSource.postRegister(registerRequest)
    }

    fun login(loginRequest: LoginRequest)= performAuthTokenNetworkOperation(
        call = {
            remoteDataSource.postLogin(loginRequest)},
        saveToken = {
            localDataSource.saveToken(it)
        }
    )
    fun checkToken():String?{
        val token= localDataSource.getToken()
        return token
    }
}