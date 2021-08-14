package com.example.teambhomework3.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.teambhomework3.data.entity.login.LoginResponse
import kotlinx.coroutines.Dispatchers
import retrofit2.Response

fun<T> performNetworkOperation(call : suspend ()-> Resource<T>) :LiveData<Resource<T>>{
    return liveData(Dispatchers.IO) {
        emit(Resource.loading())
        val networkCall=call.invoke()
        if (networkCall.status==Resource.Status.SUCCESS){
            val data=networkCall.data!!
            emit(Resource.success(data))
        }else if(networkCall.status==Resource.Status.ERROR){
            emit(Resource.error("Error ${networkCall.message}"))
        }
    }
}

fun<T> performAuthTokenNetworkOperation(
    call : suspend ()-> Resource<T>,
    saveToken: (token:String) -> Unit
    ) :LiveData<Resource<T>>{
    return liveData(Dispatchers.IO) {
        emit(Resource.loading())
        val networkCall=call.invoke()
        if (networkCall.status==Resource.Status.SUCCESS){
            val data=networkCall.data!!
            if (data is LoginResponse){
                saveToken(data.token)
            }
            emit(Resource.success(data))
        }else if(networkCall.status==Resource.Status.ERROR){
            emit(Resource.error("Error ${networkCall.message}"))
        }
    }
}