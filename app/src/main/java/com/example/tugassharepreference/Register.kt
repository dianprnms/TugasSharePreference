package com.example.tugassharepreference

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.tugassharepreference.databinding.FragmentRegisterBinding

class Register : Fragment() {
    lateinit var binding : FragmentRegisterBinding
    lateinit var sharedPref : SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPref = requireContext().getSharedPreferences("login_data", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        binding.btnRegister.setOnClickListener {
            editor.apply {
                putString("name", binding.NameRegister.text.toString())
                putString("username", binding.UsernameRegister.text.toString())
                putString("password", binding.PasswordRegister.text.toString())
                putBoolean("is_logged_in", true)
                apply()
            }
            findNavController().navigate(R.id.action_register_to_login)
        }

        binding.tvSignIn.setOnClickListener {
            findNavController().navigate(R.id.action_register_to_login)
        }
    }
}