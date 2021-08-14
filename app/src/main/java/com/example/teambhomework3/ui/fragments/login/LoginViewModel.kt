package com.example.teambhomework3.ui.fragments.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.teambhomework3.data.ApiRepository
import com.example.teambhomework3.data.entity.login.LoginRequest
import com.example.teambhomework3.data.entity.login.LoginResponse
import com.example.teambhomework3.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    var apiRepository: ApiRepository
): ViewModel() {
    private val loginService= MutableLiveData<Resource<LoginResponse>>()
    fun observeNavigationLiveData(): LiveData<Resource<LoginResponse>> =loginService

    fun login(mail: String, password: String) : LiveData<Resource<LoginResponse>> {
        val request= LoginRequest(mail,password)
        return apiRepository.login(request)
    }

}