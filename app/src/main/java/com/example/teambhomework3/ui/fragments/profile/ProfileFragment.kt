package com.example.teambhomework3.ui.fragments.profile

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.teambhomework3.R
import com.example.teambhomework3.databinding.FragmentProfileBinding
import com.example.teambhomework3.data.entity.address.Adress
import com.example.teambhomework3.data.entity.order.Order
import com.example.teambhomework3.utils.adapters.AddressAdapter
import com.example.teambhomework3.utils.adapters.OrderAdapter
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    private lateinit var db: FirebaseFirestore
    private lateinit var myAdapter: AddressAdapter
    private lateinit var orderAdapter: OrderAdapter
    private lateinit var adressArrayList: ArrayList<Adress>
    private lateinit var orderArrayList: ArrayList<Order>


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

        binding.profileOrderRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.profileOrderRecyclerView.setHasFixedSize(true)

        adressArrayList = arrayListOf()
        orderArrayList = arrayListOf()

        myAdapter = AddressAdapter(adressArrayList, requireContext())
        orderAdapter = OrderAdapter(orderArrayList)

        binding.profileAdressRecyclerView.adapter = myAdapter

        binding.profileOrderRecyclerView.adapter = orderAdapter

        getUser(db)
        getAdress(db)
        getOrders(db)
    }

    private fun onClickListener() {
        val bottomSheetFragment = BottomSheetFragment()
        binding.profileAddAdress.setOnClickListener {
            bottomSheetFragment.setStyle(
                DialogFragment.STYLE_NORMAL,
                R.style.ThemeOverlay_Demo_BottomSheetDialog
            )
            bottomSheetFragment.show(requireActivity().supportFragmentManager, "BottomSheetDialog")
        }
    }

    private fun getUser(db: FirebaseFirestore) {
        db.collection("users")
            .get()
            .addOnSuccessListener { profile ->
                for (doc in profile) {
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

    private fun getAdress(db: FirebaseFirestore) {
        db.collection("users").document("7TqNLIAQzjJVWLRAsAmC")
            .collection("adress")
            .get()
            .addOnSuccessListener {
                for (doc in it) {
                    adressArrayList.add(
                        Adress(
                            "${doc.data["adressName"]}",
                            "${doc.data["addressCity"]}",
                            "${doc.data["address"]}",
                            "${doc.data["adressNumber"]}",
                            "${doc.id}"
                        )
                    )
                }
                myAdapter.notifyDataSetChanged()
            }
            .addOnFailureListener { exception ->
                Log.w("errorDocuments", "Error getting documents.", exception)
            }
    }

    private fun getOrders(db: FirebaseFirestore) {
        db.collection("users").document("7TqNLIAQzjJVWLRAsAmC")
            .collection("orders")
            .get()
            .addOnSuccessListener {
                for (doc in it) {
                    orderArrayList.add(
                        Order(
                            "${doc.data["restaurantName"]}",
                            "${doc.data["orderFoodName"]}",
                        )
                    )
                }
                orderAdapter.notifyDataSetChanged()
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