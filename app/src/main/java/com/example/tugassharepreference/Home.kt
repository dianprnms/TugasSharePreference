package com.example.tugassharepreference

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.tugassharepreference.databinding.FragmentHomeBinding

class Home : Fragment() {
    lateinit var binding : FragmentHomeBinding
    lateinit var sharedPref : SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPref = requireContext().getSharedPreferences("login_data", Context.MODE_PRIVATE)
        val name = sharedPref.getString("name", "")
        binding.btnLogout.setOnClickListener {
            clearData()
        }
        binding.showName.text = "Hello, $name"
    }

    fun clearData(){
        val editor = sharedPref.edit()
        editor.apply {
            remove("username")
            remove("password")
            putBoolean("is_logged_in", false)
            apply()
            findNavController().navigate(R.id.action_home2_to_login)
        }
    }
}