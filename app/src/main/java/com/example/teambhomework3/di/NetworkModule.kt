package com.example.teambhomework3.di

import androidx.viewbinding.BuildConfig
import com.fatihhernn.mmvm.data.remote.NetworkApiService
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideApiService(@ApiRetrofit retrofit: Retrofit):NetworkApiService{
        return retrofit.create(NetworkApiService::class.java)
    }

    @Provides
    @ApiRetrofit
    fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson, @ApiEndPoint endPoint: String):Retrofit{
        return Retrofit.Builder()
            .baseUrl(endPoint)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun provideGson(): Gson {
        return Gson()
    }

    @Provides
    fun provideOkHttpClient():OkHttpClient{
        val builder=OkHttpClient.Builder()
        builder.interceptors().add(HttpLoggingInterceptor().apply {
            level=if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        })
        return builder.build()

    }

    @Provides
    @ApiEndPoint
    fun provideApiString():String{
        return "https://dist-learn.herokuapp.com/api/"
    }
}
@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ApiEndPoint

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ApiRetrofit
