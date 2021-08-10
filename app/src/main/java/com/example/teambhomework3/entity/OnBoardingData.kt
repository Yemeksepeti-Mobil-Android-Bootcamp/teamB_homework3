package com.example.teambhomework3.entity

import androidx.annotation.DrawableRes

data class OnBoardingData(
    val title:String,
    val description:String,
    @DrawableRes val image : Int
)
