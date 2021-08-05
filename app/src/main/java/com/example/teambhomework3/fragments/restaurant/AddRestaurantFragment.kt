package com.example.teambhomework3.fragments.restaurant

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.teambhomework3.MainActivity
import com.example.teambhomework3.R
import com.example.teambhomework3.databinding.FragmentAddRestaurantBinding
import com.example.teambhomework3.databinding.FragmentRestaurantsBinding


class AddRestaurantFragment : Fragment() {

    private var _binding: FragmentAddRestaurantBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddRestaurantBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            findNavController().navigate(R.id.action_addRestaurantFragment_to_restaurantsFragment)
        }
        return super.onOptionsItemSelected(item)
    }

}