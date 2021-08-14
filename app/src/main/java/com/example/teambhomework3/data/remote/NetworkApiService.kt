package com.fatihhernn.mmvm.data.remote

import com.example.teambhomework3.data.entity.login.LoginRequest
import com.example.teambhomework3.data.entity.login.LoginResponse
import com.example.teambhomework3.data.entity.register.RegisterRequest
import com.example.teambhomework3.data.entity.register.RegisterResponse
import retrofit2.Response
import retrofit2.http.*

interface NetworkApiService {

    @POST("auth/register")
    suspend fun register(@Body request: RegisterRequest):Response<RegisterResponse>

    @POST("auth/login")
    suspend fun login(@Body request: LoginRequest):Response<LoginResponse>
}

