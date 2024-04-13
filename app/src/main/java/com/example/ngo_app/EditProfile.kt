package com.example.ngo_app

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.ngo_app.databinding.ActivityEditProfileBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.auth.auth
import com.google.firebase.database.*
import com.google.firebase.firestore.FirebaseFirestore

class EditProfile : AppCompatActivity() {

    private lateinit var binding: ActivityEditProfileBinding
    private lateinit var sharedPrefs: SharedPreferences
    private lateinit var dbHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnSaveProfile.setOnClickListener {
            val updatedFullName =  binding.editTextName.text.toString()
            val updatedEmail = binding.editTextEmail.text.toString()
            val updatedPhone = binding.editTextPhoneNumber.text.toString()
            val newPassword = binding.editTextPassword.text.toString()


            // Retrieve the email from SharedPreferences
            sharedPrefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
            val currentEmail = sharedPrefs.getString("email", "")

            // Update in SharedPreferences
            val editor = sharedPrefs.edit()
            editor.putString("email", updatedEmail)
            editor.putString("fullName", updatedFullName)
            editor.apply()

            // Update in database
            dbHelper = DatabaseHelper(this)
            dbHelper.updateUser(currentEmail!!, updatedFullName, updatedEmail, updatedPhone, newPassword)

            // Update displayed name
//            binding.username.text = updatedFullName

            Toast.makeText(this, "Profile updated successfully", Toast.LENGTH_SHORT).show()
        }

        binding.backToSetting.setOnClickListener {
            val intent = Intent(this, UserProfile::class.java)
            startActivity(intent)
        }
    }
}