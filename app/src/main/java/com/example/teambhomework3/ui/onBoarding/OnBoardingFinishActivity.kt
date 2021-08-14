package com.example.teambhomework3.ui.onBoarding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.teambhomework3.databinding.ActivityOnBoardingFinishBinding

class OnBoardingFinishActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOnBoardingFinishBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityOnBoardingFinishBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}