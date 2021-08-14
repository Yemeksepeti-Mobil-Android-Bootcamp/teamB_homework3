package com.example.teambhomework3.ui.fragments.register

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.teambhomework3.R
import com.example.teambhomework3.databinding.FragmentRegisterBinding
import com.example.teambhomework3.utils.Resource
import com.example.teambhomework3.utils.gone
import com.example.teambhomework3.utils.show
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment() {

    private lateinit var _binding: FragmentRegisterBinding
    private val viewModel:RegisterViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentRegisterBinding.inflate(inflater,container,false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding.registerBtn.setOnClickListener {
            var userName= _binding.userNameText.text.toString()
            var email=_binding.emailTextView.text.toString()
            var password=_binding.passwordTextView.text.toString()

            viewModel.register(email,userName,password).observe(
                viewLifecycleOwner, Observer {
                    when(it.status){
                        Resource.Status.LOADING ->{
                            _binding.progressBar3.show()
                        }
                        Resource.Status.SUCCESS ->{
                            Toast.makeText(context,"Register is success! ${it.message}", Toast.LENGTH_LONG).show()
                            _binding.progressBar3.gone()
                            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
                        }
                        Resource.Status.ERROR ->{
                            Toast.makeText(context,"Register is failure! ${it.message}", Toast.LENGTH_LONG).show()
                            _binding.progressBar3.gone()
                        }
                    }
                }
            )
        }
    }





}