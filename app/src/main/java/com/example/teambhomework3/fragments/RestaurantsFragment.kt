package com.example.teambhomework3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.teambhomework3.R
import com.example.teambhomework3.databinding.FragmentAddRestaurantBinding
import com.example.teambhomework3.databinding.FragmentRestaurantsBinding


class RestaurantsFragment : Fragment() {

    private var _binding: FragmentRestaurantsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRestaurantsBinding.inflate(inflater, container, false)

        binding.restaurantAddFab.setOnClickListener {
            findNavController().navigate(R.id.action_restaurantsFragment_to_addRestaurantFragment)
        }
        return binding.root
    }
}