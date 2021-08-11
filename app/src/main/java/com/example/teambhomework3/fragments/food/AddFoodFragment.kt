package com.example.teambhomework3.fragments.food

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.teambhomework3.R
import com.example.teambhomework3.databinding.FragmentAddFoodBinding
import com.example.teambhomework3.entity.Food
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class AddFoodFragment : Fragment() {

    private var _binding: FragmentAddFoodBinding? = null
    private val binding get() = _binding!!

    private lateinit var db: FirebaseFirestore
    private val args by navArgs<AddFoodFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddFoodBinding.inflate(inflater, container, false)

        setHasOptionsMenu(true)
        initViews()

        Log.v("dass","${args.restaurantName}")

        return binding.root
    }

    private fun initViews() {
        db = Firebase.firestore

        binding.saveFoodButton.setOnClickListener {
            val foodName = binding.foodNameTextInputEditText.editableText.toString().trim()
            val foodPrice = binding.foodPriceTextInputEditText.editableText.toString().trim()
            val foodImage = binding.foodImageUrlTextInputEditText.editableText.toString().trim()
            val foodDescription = binding.foodDescriptionTextInputEditText.editableText.toString().trim()

            if(foodName.isNullOrEmpty()){
                binding.foodNameTextInputEditText.error="This field is required"
                return@setOnClickListener
            }
            if(foodPrice.isNullOrEmpty()){
                binding.foodPriceTextInputEditText.error="This field is required"
                return@setOnClickListener
            }
            if(foodImage.isNullOrEmpty()){
                binding.foodImageUrlTextInputEditText.error="This field is required"
                return@setOnClickListener
            }

            db.collection("restaurants")
                .document(args.restaurantName)
                .collection("restaurantFoods")
                .add(
                    Food(
                        foodName,
                        foodImage,
                        foodPrice,
                        foodDescription ))

            Toast.makeText(context,"Food has been stored in Firestore", Toast.LENGTH_LONG).show()

            val direction = AddFoodFragmentDirections.actionAddFoodFragmentToFoodsFragment(args.restaurantName, args.restaurantImage)
            findNavController().navigate(direction)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            findNavController().navigate(R.id.action_addFoodFragment_to_foodsFragment)
        }
        return super.onOptionsItemSelected(item)
    }
}