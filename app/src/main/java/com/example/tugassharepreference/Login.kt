package com.example.tugassharepreference

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.tugassharepreference.databinding.FragmentLoginBinding


class Login : Fragment() {
    lateinit var binding: FragmentLoginBinding
    lateinit var sharedPref : SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ):
            View {
        // Inflate the layout for this fragment
        binding= FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPref = requireContext().getSharedPreferences("login_data", Context.MODE_PRIVATE)
        val username = sharedPref.getString("username", "")
        val password = sharedPref.getString("password", "")
        binding.btnLogin.setOnClickListener{
            val etUsername = binding.UsernameLogin.text.toString()
            val etPassword = binding.PasswordLogin.text.toString()

            if(etUsername == username && etPassword == password){
                findNavController().navigate(R.id.action_login_to_home2)
            }else{
                Toast.makeText(requireContext(), "Username atau password salah atau tidak ditemukan silahkan coba lagi", Toast.LENGTH_LONG).show()
            }
        }

        binding.tvSignUp.setOnClickListener {
            findNavController().navigate(R.id.action_login_to_register)
        }
    }


}