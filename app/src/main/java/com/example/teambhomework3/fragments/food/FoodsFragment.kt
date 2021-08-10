package com.example.teambhomework3.fragments.food

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.teambhomework3.R
import com.example.teambhomework3.databinding.FragmentFoodsBinding
import com.example.teambhomework3.entity.Food
import com.example.teambhomework3.utils.adapters.FoodAdapter
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.processNextEventInCurrentThread


class FoodsFragment : Fragment() {

    private var _binding: FragmentFoodsBinding? = null
    private val binding get() = _binding!!
    private lateinit var myAdapter: FoodAdapter
    private lateinit var db: FirebaseFirestore
    private lateinit var foodArrayList: ArrayList<Food>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFoodsBinding.inflate(inflater, container, false)

        binding.foodAddFab.setOnClickListener {
            findNavController().navigate(R.id.action_foodsFragment_to_addFoodFragment)
        }

        initViews()
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private fun initViews(){
        binding.recyclerView2.layoutManager = GridLayoutManager(requireContext(),1)
        binding.recyclerView2.setHasFixedSize(true)

        foodArrayList = arrayListOf()
        myAdapter = FoodAdapter(foodArrayList,requireContext())
        binding.recyclerView2.adapter = myAdapter

        db = Firebase.firestore

        getFoods(db)
    }


    private fun getFoods(db: FirebaseFirestore){
        db.collection("restaurantFoods").get()
            .addOnSuccessListener { food ->
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
            .addOnFailureListener { exception->
                Log.w("errorDocuments","Error getting documents", exception)
            }
    }

}