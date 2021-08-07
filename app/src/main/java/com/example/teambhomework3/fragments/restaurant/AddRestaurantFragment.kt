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
            val restaurantNumber=binding.restaurantNumberTextView.editText.toString().trim()
            val restaurantName=binding.restaurantNameTextView.editText.toString().trim()
            val restaurantType=binding.restaurantTypeTextView.editText.toString().trim()
            val restaurantAddress=binding.restaurantAdressTextView.editText.toString().trim()
            val restaurantLogoUrl=binding.restaurantLogoUrlTextView.editText.toString().trim()

            if(restaurantNumber.isNullOrEmpty()){
                binding.restaurantNumberTextView.error="This field is required"
                return@setOnClickListener
            }
            if(restaurantName.isNullOrEmpty()){
                binding.restaurantNameTextView.error="This field is required"
                return@setOnClickListener
            }
            if(restaurantType.isNullOrEmpty()){
                binding.restaurantTypeTextView.error="This field is required"
                return@setOnClickListener
            }
            if(restaurantAddress.isNullOrEmpty()){
                binding.restaurantAdressTextView.error="This field is required"
                return@setOnClickListener
            }
            if(restaurantLogoUrl.isNullOrEmpty()){
                binding.restaurantLogoUrlTextView.error="This field is required"
                return@setOnClickListener
            }

            val restaurantMap= hashMapOf<String,String>()
            restaurantMap["restarauntNumber"] = restaurantNumber
            restaurantMap["restaurantAdress"] = restaurantAddress
            restaurantMap["restaurantImage"] = restaurantLogoUrl
            restaurantMap["restaurantName"] = restaurantName
            restaurantMap["restarauntType"] = restaurantType

            db.collection("restaurants").document(restaurantName).set(restaurantMap)

            Toast.makeText(context,"Added Restaurant to Firestore",Toast.LENGTH_SHORT).show()

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