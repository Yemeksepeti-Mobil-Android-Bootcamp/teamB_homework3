package com.example.teambhomework3.ui.fragments.splash

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.teambhomework3.R
import com.example.teambhomework3.databinding.FragmentSplashBinding
import com.example.teambhomework3.ui.activity.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : Fragment() {

    private lateinit var _binding: FragmentSplashBinding
    private val viewModel:SplashViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentSplashBinding.inflate(inflater,container,false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.observeNavigationLiveData().observe(viewLifecycleOwner, Observer {
            when(it){
                "auth" -> findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
                "home" -> {
                    val intent = Intent(requireContext(), MainActivity::class.java)
                    startActivity(intent)

                }
            }
        })
        viewModel.checkTokenAndNavigation()
    }

}