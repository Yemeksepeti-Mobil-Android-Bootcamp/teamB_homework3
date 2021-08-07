package com.example.teambhomework3.fragments.restaurant

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.teambhomework3.R
import com.example.teambhomework3.databinding.FragmentAddRestaurantBinding
import com.example.teambhomework3.databinding.FragmentRestaurantsBinding
import com.example.teambhomework3.entity.Restaurant
import com.example.teambhomework3.utils.adapters.RestaurantAdapter
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class RestaurantsFragment : Fragment() {

    private var _binding: FragmentRestaurantsBinding? = null
    private val binding get() = _binding!!

    private lateinit var myAdapter: RestaurantAdapter
    private lateinit var restaurantArrayList: ArrayList<Restaurant>
    private lateinit var db: FirebaseFirestore

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRestaurantsBinding.inflate(inflater, container, false)

        initViews()

        return binding.root
    }

    private fun initViews() {
        binding.restaurantRecyclerView.layoutManager = GridLayoutManager(requireContext(), 1)
        binding.restaurantRecyclerView.setHasFixedSize(true)

        restaurantArrayList = arrayListOf()
        myAdapter = RestaurantAdapter(restaurantArrayList, requireContext())
        binding.restaurantRecyclerView.adapter = myAdapter

        db = Firebase.firestore

        onClick()
        getRestaurants(db)
    }

    private fun onClick() {
        binding.restaurantAddFab.setOnClickListener {
            findNavController().navigate(R.id.action_restaurantsFragment_to_addRestaurantFragment)
        }
    }

    private fun getRestaurants(db: FirebaseFirestore) {
        db.collection("restaurants").get()
            .addOnSuccessListener { restaurant->
                for (doc in restaurant){
                    restaurantArrayList.add(
                        Restaurant(
                            "${doc.data["restaurantName"]}",
                            "${doc.data["restaurantAdress"]}",
                            "${doc.data["restaurantImage"]}",
                            "${doc.data["restaurantNumber"]}",
                            "${doc.data["restaurantType"]}",
                        ))
                }
                myAdapter.notifyDataSetChanged()
            }
            .addOnFailureListener { exception ->
                Log.w("errorDocuments", "Error getting documents.", exception)
            }
    }
}