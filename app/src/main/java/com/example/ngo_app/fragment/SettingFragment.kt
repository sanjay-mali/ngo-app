package com.example.ngo_app.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ngo_app.R
import com.example.ngo_app.UserProfile
import com.example.ngo_app.WelcomeScreen
import com.example.ngo_app.databinding.FragmentSettingBinding

class SettingFragment : Fragment() {

    private var _binding: FragmentSettingBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding =  FragmentSettingBinding.inflate(inflater, container, false)

        binding.profileBtn.setOnClickListener{
            val intent = Intent(activity, UserProfile::class.java)
            startActivity(intent)
            activity?.finish()
        }

        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}