package com.example.teambhomework3.fragments.food

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.teambhomework3.R
import com.example.teambhomework3.databinding.FragmentAddFoodBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class AddFoodFragment : Fragment() {

    private var _binding: FragmentAddFoodBinding? = null
    private val binding get() = _binding!!

    private lateinit var db: FirebaseFirestore

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddFoodBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        db= Firebase.firestore
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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

            val foodMap= hashMapOf<String,String>()
            foodMap["foodName"] = foodName
            foodMap["foodPrice"] = foodPrice
            foodMap["foodImage"] = foodImage
            foodMap["foodDescription"] = foodDescription

            db.collection("foods").document(foodName).set(foodMap)

            Toast.makeText(context,"Food has been stored in Firestore", Toast.LENGTH_LONG).show()

            findNavController().navigate(R.id.action_addFoodFragment_to_foodsFragment)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            findNavController().navigate(R.id.action_addFoodFragment_to_foodsFragment)
        }
        return super.onOptionsItemSelected(item)
    }

}