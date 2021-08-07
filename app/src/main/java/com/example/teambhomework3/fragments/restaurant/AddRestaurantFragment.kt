package com.example.teambhomework3.fragments.restaurant

import android.os.Bundle
import android.os.Handler
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.teambhomework3.MainActivity
import com.example.teambhomework3.R
import com.example.teambhomework3.databinding.FragmentAddRestaurantBinding
import com.example.teambhomework3.databinding.FragmentRestaurantsBinding
import com.example.teambhomework3.entity.Restaurant
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.delay


class AddRestaurantFragment : Fragment() {

    private var _binding: FragmentAddRestaurantBinding? = null
    private val binding get() = _binding!!

    private lateinit var db: FirebaseFirestore


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddRestaurantBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        db= Firebase.firestore


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.saveButton.setOnClickListener {
            val restaurantNumber=binding.restaurantNumberTextInputEditText.editableText.toString().trim()
            val restaurantName=binding.restaurantNameTextInputEditText.editableText.toString().trim()
            val restaurantType=binding.restaurantTypeTextInputEditText.editableText.toString().trim()
            val restaurantAddress=binding.restaurantAdressTextInputLayout.editableText.toString().trim()
            val restaurantLogoUrl=binding.restaurantLogoUrlTextInputEditText.editableText.toString().trim()

            if(restaurantNumber.isNullOrEmpty()){
                binding.restaurantNumberTextInputEditText.error="This field is required"
                return@setOnClickListener
            }
            if(restaurantName.isNullOrEmpty()){
                binding.restaurantNameTextInputEditText.error="This field is required"
                return@setOnClickListener
            }
            if(restaurantType.isNullOrEmpty()){
                binding.restaurantTypeTextInputEditText.error="This field is required"
                return@setOnClickListener
            }
            if(restaurantAddress.isNullOrEmpty()){
                binding.restaurantAdressTextInputLayout.error="This field is required"
                return@setOnClickListener
            }
            if(restaurantLogoUrl.isNullOrEmpty()){
                binding.restaurantLogoUrlTextInputEditText.error="This field is required"
                return@setOnClickListener
            }

            val restaurantMap= hashMapOf<String,String>()
            restaurantMap["restarauntNumber"] = restaurantNumber
            restaurantMap["restaurantAdress"] = restaurantAddress
            restaurantMap["restaurantImage"] = restaurantLogoUrl
            restaurantMap["restaurantName"] = restaurantName
            restaurantMap["restaurantType"] = restaurantType

            db.collection("restaurants").document(restaurantName).set(restaurantMap)

            Toast.makeText(context,"Added Restaurant to Firestore",Toast.LENGTH_LONG).show()

            findNavController().navigate(R.id.action_addRestaurantFragment_to_restaurantsFragment)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            findNavController().navigate(R.id.action_addRestaurantFragment_to_restaurantsFragment)
        }
        return super.onOptionsItemSelected(item)
    }

}