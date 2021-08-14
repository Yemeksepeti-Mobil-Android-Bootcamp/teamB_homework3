package com.example.teambhomework3.data.remote

import com.example.teambhomework3.data.entity.login.LoginRequest
import com.example.teambhomework3.data.entity.register.RegisterRequest
import com.example.teambhomework3.utils.BaseDataSource
import com.fatihhernn.mmvm.data.remote.NetworkApiService
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val apiService: NetworkApiService,
    ) : BaseDataSource() {


    suspend fun postRegister(request: RegisterRequest)=getResult { apiService.register(request) }

    suspend fun postLogin(request: LoginRequest)=getResult { apiService.login(request) }
}