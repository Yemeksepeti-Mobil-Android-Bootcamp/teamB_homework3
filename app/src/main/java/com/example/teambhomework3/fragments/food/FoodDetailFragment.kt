package com.example.teambhomework3.fragments.food

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.teambhomework3.R
import com.example.teambhomework3.databinding.FragmentFoodDetail2Binding

class FoodDetailFragment : Fragment() {
    private var _binding: FragmentFoodDetail2Binding? = null
    private val binding get() = _binding!!

    private val args by navArgs<FoodDetailFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFoodDetail2Binding.inflate(inflater, container, false)
        val view = binding.root

        initViews()
        binding.foodDetailToolbarBaslik.text=args.foodDetail.foodName
        return view
    }

    private fun initViews() {
        binding.foodDetailTitle.text =args.foodDetail.foodName

        Glide
            .with(requireContext())
            .load(args.foodDetail.foodImage)
            .centerCrop()
            .into(binding.foodDetailFoto)

        binding.textViewFiyat.text = "${args.foodDetail.foodPrice}₺"

        binding.textView7.text = args.foodDetail.foodDescription
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}