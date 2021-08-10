package com.example.teambhomework3.utils

import android.app.Activity
import android.content.Context
import com.example.teambhomework3.R


object Animato {

    fun animateDiagonal(context: Context) {
        (context as Activity).overridePendingTransition(
            R.anim.animate_diagonal_right_enter,
            R.anim.animate_diagonal_right_exit
        )
    }


}