package com.example.teambhomework3.ui.fragments.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.teambhomework3.data.ApiRepository
import com.example.teambhomework3.data.entity.register.RegisterRequest
import com.example.teambhomework3.data.entity.register.RegisterResponse
import com.example.teambhomework3.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val apiRepository: ApiRepository
) : ViewModel() {
    fun register(email: String, userName: String, password: String) : LiveData<Resource<RegisterResponse>> {
        val request= RegisterRequest(email,userName,password)
        return apiRepository.register(request)
    }
}