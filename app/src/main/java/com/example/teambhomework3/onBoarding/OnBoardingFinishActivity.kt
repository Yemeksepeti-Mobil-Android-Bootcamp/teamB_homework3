package com.example.teambhomework3.onBoarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.teambhomework3.MainActivity
import com.example.teambhomework3.R
import com.example.teambhomework3.databinding.ActivityOnBoardingFinishBinding
import com.example.teambhomework3.databinding.ActivityOnBoardingStartBinding

class OnBoardingFinishActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOnBoardingFinishBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityOnBoardingFinishBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val intent =
                Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)

        }
    }
}