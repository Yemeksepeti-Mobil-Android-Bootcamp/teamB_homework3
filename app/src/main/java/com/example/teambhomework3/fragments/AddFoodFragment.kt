package com.example.teambhomework3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.teambhomework3.R
import com.example.teambhomework3.databinding.FragmentAddFoodBinding
import com.example.teambhomework3.databinding.FragmentAddRestaurantBinding

class AddFoodFragment : Fragment() {

    private var _binding: FragmentAddFoodBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddFoodBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            findNavController().navigate(R.id.action_addFoodFragment_to_foodsFragment)
        }
        return super.onOptionsItemSelected(item)
    }

}