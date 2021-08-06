package com.example.teambhomework3.utils

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.teambhomework3.R


object ThemeUtils {

    const val LIGHT: String = "LIGHT"
    const val DARK: String = "DARK"

    private var cTheme: String = SharedPreferencesModule.getString(SharedPreferencesModule.THEME, LIGHT)

    fun changeTheme(activity: AppCompatActivity, theme: String = LIGHT) {
        cTheme = theme

        activity.finish().also {
            activity.startActivity(Intent(activity.baseContext, activity.javaClass))
        }
    }

    fun onActivityCreateSetTheme(activity: AppCompatActivity) {
        when (cTheme) {
            LIGHT -> {
                activity.setTheme(R.style.Theme_TeamBHomework3_Light)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
            DARK -> {
                activity.setTheme(R.style.Theme_TeamBHomework3_Dark)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
            else -> {
                activity.setTheme(R.style.Theme_TeamBHomework3_Light)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
    }
}