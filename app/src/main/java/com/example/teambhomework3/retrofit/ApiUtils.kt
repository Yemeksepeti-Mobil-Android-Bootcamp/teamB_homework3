package com.example.teambhomework3.retrofit

import android.util.Log
import com.example.teambhomework3.models.core.Food
import com.example.teambhomework3.models.listing.YemeksepetiHW3BaseListingResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


interface RetrofitResponseHandler<T> {
    fun onResponse(response: YemeksepetiHW3BaseListingResponse<T>)
    fun onError()
}

class ApiUtils {
    companion object {
        val BASE_URL = "https://yemeksepeti-android-hw3-api.herokuapp.com/"

        fun getApiService(): YemeksepetiHW3ApiService {
            return RetrofitClient.getClient(BASE_URL).create(YemeksepetiHW3ApiService::class.java)
        }

//        fun listFoods(page: Int = 1, callBack: RetrofitResponseHandler<Food>) {
//            getApiService().listFoods(page).enqueue(object :
//                Callback<YemeksepetiHW3BaseListingResponse<Food>> {
//                override fun onResponse(
//                    call: Call<YemeksepetiHW3BaseListingResponse<Food>>,
//                    response: Response<YemeksepetiHW3BaseListingResponse<Food>>
//                ) {
//                    if (response.isSuccessful) {
//                        response.body()?.let {
//                            callBack.onResponse(it)
//                        }
//                    } else {
//                        callBack.onError()
//                        Log.v("RetrofitHelper", "any errors.")
//                    }
//                }
//
//                override fun onFailure(
//                    call: Call<YemeksepetiHW3BaseListingResponse<Food>>,
//                    t: Throwable
//                ) {
//                    Log.v("RetrofitHelper", "onFailure -> service unavailable errors.")
//                    callBack.onError()
//                }
//            })
//        }
    }

}