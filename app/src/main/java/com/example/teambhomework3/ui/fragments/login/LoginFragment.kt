package com.example.teambhomework3.ui.fragments.login

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.teambhomework3.R
import com.example.teambhomework3.databinding.FragmentLoginBinding
import com.example.teambhomework3.ui.activity.MainActivity
import com.example.teambhomework3.utils.Resource
import com.example.teambhomework3.utils.gone
import com.example.teambhomework3.utils.show
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private lateinit var _binding:FragmentLoginBinding
    private val viewModel:LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentLoginBinding.inflate(inflater,container,false)
        return _binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding.loginBtn.setOnClickListener {
            val mail=_binding.emailText.text.toString()
            val password=_binding.passwordTextView.text.toString()
            viewModel.login(mail,password).observe(viewLifecycleOwner, Observer {
                when(it.status){
                    Resource.Status.LOADING ->{
                        _binding.progressBar2.show()
                    }
                    Resource.Status.SUCCESS ->{
                        _binding.progressBar2.gone()
                        val intent = Intent(context, MainActivity::class.java)
                        startActivity(intent)
                    }
                    Resource.Status.ERROR ->{
                        _binding.progressBar2.gone()
                        val dialog= AlertDialog.Builder(context)
                            .setTitle("Error")
                            .setMessage("${it.message}")
                            .setPositiveButton("ok"){dialog,button->
                                dialog.dismiss()
                            }
                        dialog.show()
                    }
                }
            })
        }
        _binding.registerButton.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }

}