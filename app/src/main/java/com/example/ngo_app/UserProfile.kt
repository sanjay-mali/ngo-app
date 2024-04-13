package com.example.ngo_app

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.ngo_app.databinding.ActivityUserProfileBinding
import com.example.ngo_app.fragment.SettingFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class UserProfile : AppCompatActivity() {
    private lateinit var binding: ActivityUserProfileBinding
    private lateinit var dbHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        dbHelper = DatabaseHelper(this)
//        val currentUserEmail = "user@example.com"
//        val fullName = dbHelper.getFullName(currentUserEmail)
//        fullName?.let {
//            // Set the full name to a TextView or any other UI element
//            binding.usernameInProfile.text = fullName
//        }

        // Retrieve full name from SharedPreferences
        val sharedPrefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        // Retrieve the email from SharedPreferences
        val email = sharedPrefs.getString("email", "")
        dbHelper = DatabaseHelper(this)
        val fullName = dbHelper.getFullNameByEmail(email!!)
        binding.usernameInProfile.text = fullName
// Display the full name in your UI
        binding.usernameInProfile.text = fullName

        binding.editProfileButton.setOnClickListener{
            val intent = Intent(this, EditProfile::class.java)
            startActivity(intent)
        }

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