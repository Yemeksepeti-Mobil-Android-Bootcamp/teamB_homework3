package com.example.teambhomework3.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.teambhomework3.databinding.FragmentProfileBinding
import com.example.teambhomework3.entity.Adress
import com.example.teambhomework3.utils.adapters.ProfileAdapter
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    private lateinit var db: FirebaseFirestore
    private lateinit var myAdapter: ProfileAdapter
    private lateinit var adressArrayList: ArrayList<Adress>


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val view = binding.root

        db = Firebase.firestore
        initViews(db)
        onClickListener()

        return view
    }

    private fun initViews(db: FirebaseFirestore) {

        binding.profileAdressRecyclerView.layoutManager = GridLayoutManager(requireContext(), 1)
        binding.profileAdressRecyclerView.setHasFixedSize(true)

        adressArrayList = arrayListOf()
        myAdapter = ProfileAdapter(adressArrayList, requireContext())
        binding.profileAdressRecyclerView.adapter = myAdapter

        getUser(db)
        getAdress(db)
    }

    private fun onClickListener() {
        val bottomSheetFragment = BottomSheetFragment()
        binding.profileAddAdress.setOnClickListener {
            bottomSheetFragment.show(requireActivity().supportFragmentManager, "BottomSheetDialog")
        }
    }

    private fun getUser(db: FirebaseFirestore){
        db.collection("users")
            .get()
            .addOnSuccessListener { profile->
                for (doc in profile){
                    binding.profileName.text = doc.data["name"].toString()
                    binding.profileDate.text = doc.data["joinedDate"].toString()

                    Glide
                        .with(requireContext())
                        .load(doc.data["profileImage"])
                        .centerCrop()
                        .into(binding.profileImageView)
                }
            }
    }

    private fun getAdress(db: FirebaseFirestore){
        db.collection("users").document("7TqNLIAQzjJVWLRAsAmC")
            .collection("adress")
            .get()
            .addOnSuccessListener {
                for (doc in it){
                    adressArrayList.add(
                        Adress(
                            "${doc.data["adressName"]}",
                            "${doc.data["adressCity"]}",
                            "${doc.data["adress"]}",
                            "${doc.data["adressNumber"]}",
                        )
                    )
                }
                myAdapter.notifyDataSetChanged()
            }
            .addOnFailureListener { exception ->
                Log.w("errorDocuments", "Error getting documents.", exception)
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}