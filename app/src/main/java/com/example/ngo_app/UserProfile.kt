package com.example.ngo_app

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ngo_app.databinding.ActivityUserProfileBinding
import com.example.ngo_app.fragment.SettingFragment

class UserProfile : AppCompatActivity() {
    private lateinit var binding: ActivityUserProfileBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.usernameInProfile.text = intent.getStringExtra("username")

        binding.logout.setOnClickListener{
            val sharedPreferences = this.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putBoolean("isLoggedIn", false)
            editor.apply()
            val intent = Intent(this, WelcomeScreen::class.java)
            startActivity(intent)
            this.finish()
        }

        binding.backToSetting.setOnClickListener{
            val intent = Intent(this, SettingFragment::class.java)
            startActivity(intent)
        }

    }
}