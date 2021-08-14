package com.example.teambhomework3.ui.fragments.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.teambhomework3.R
import com.example.teambhomework3.databinding.FragmentBottomSheetBinding
import com.example.teambhomework3.data.entity.address.Adress
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class BottomSheetFragment: BottomSheetDialogFragment() {
    private var _binding: FragmentBottomSheetBinding? = null
    private val binding get() = _binding!!

    private lateinit var db: FirebaseFirestore

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBottomSheetBinding.inflate(inflater, container, false)
        val view = binding.root

        db = Firebase.firestore

        binding.bottomSheetAddAdressButton.setOnClickListener {
            setData(db)

            Toast.makeText(requireContext(), "Adres Eklendi", Toast.LENGTH_LONG).show()

            findNavController().navigate(R.id.action_profileFragment_self)
        }

        return view
    }

    private fun setData(db:FirebaseFirestore) {

        val random = (0 until 10).random()

        db.collection("users")
            .document("7TqNLIAQzjJVWLRAsAmC")
            .collection("adress")
            .add(
                Adress(
                binding.bottomSheetAdressTitleEditText.text.toString(),
                binding.bottomSheetAdressCityEditText.text.toString(),
                binding.bottomSheetAdressEditText.text.toString(),
                binding.bottomSheetAdressNumberEditText.text.toString(),
                random.toString())
            )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}