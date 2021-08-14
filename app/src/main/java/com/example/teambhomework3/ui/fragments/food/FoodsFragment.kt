package com.example.teambhomework3.ui.fragments.food

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.teambhomework3.databinding.FragmentFoodsBinding
import com.example.teambhomework3.data.entity.Food
import com.example.teambhomework3.utils.adapters.FoodAdapter
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class FoodsFragment : Fragment() {

    private var _binding: FragmentFoodsBinding? = null
    private val binding get() = _binding!!

    private lateinit var myAdapter: FoodAdapter
    private lateinit var db: FirebaseFirestore
    private lateinit var foodArrayList: ArrayList<Food>

    private val args by navArgs<FoodsFragmentArgs>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFoodsBinding.inflate(inflater, container, false)

        binding.foodAddFab.setOnClickListener {
            val action = FoodsFragmentDirections.actionFoodsFragmentToAddFoodFragment(args.restaurantNameData, args.restaurantImageData)
            findNavController().navigate(action)
        }

        initViews()
        return binding.root
    }

    private fun initViews(){
        binding.recyclerView2.layoutManager = GridLayoutManager(requireContext(),2)
        binding.recyclerView2.setHasFixedSize(true)
     
        foodArrayList = arrayListOf()
        myAdapter = FoodAdapter(foodArrayList,requireContext())
        binding.recyclerView2.adapter = myAdapter

        Glide
            .with(requireContext())
            .load(args.restaurantImageData)
            .centerCrop()
            .into(binding.restaurantDetailImage)

        binding.collapsingToolbar.title = args.restaurantNameData
        binding.restaurantDetailToolbar.title = args.restaurantNameData

        db = Firebase.firestore

        getFoods(db)
    }


    private fun getFoods(db: FirebaseFirestore) {
        db.collection("restaurants").document(args.restaurantNameData)
            .collection("restaurantFoods").get()
            .addOnSuccessListener { food->
                for (doc in food){
                    foodArrayList.add(
                        Food(
                            "${doc.data["foodName"]}",
                            "${doc.data["foodImage"]}",
                            "${doc.data["foodPrice"]}",
                            "${doc.data["foodDescription"]}"
                        )
                    )
                }
                myAdapter.notifyDataSetChanged()
            }
            .addOnFailureListener { exception ->
                Log.w("errorDocuments", "Error getting documents.", exception)
            }
    }


}