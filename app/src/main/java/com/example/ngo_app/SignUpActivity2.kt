package com.example.ngo_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ngo_app.databinding.ActivitySignUp2Binding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.database

class SignUpActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivitySignUp2Binding
    private lateinit var dbHelper: DatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUp2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        dbHelper = DatabaseHelper(this)

        binding.signUpButton.setOnClickListener {
            val name = binding.name.text.toString()
            val phoneNumber = binding.phoneNumber.text.toString()
            val email = binding.email.text.toString()
            val password = binding.pwd.text.toString()

            if (name.isNotEmpty() && email.isNotEmpty() && phoneNumber.isNotEmpty() && password.isNotEmpty()) {
                val result = dbHelper.addUser(name, email, phoneNumber, password)
                if (result != -1L) {
                    Toast.makeText(this, "User registered successfully!", Toast.LENGTH_SHORT).show()
                    val loginIntent = Intent(this, LogIn::class.java)
                    startActivity(loginIntent)
                } else {
                    Toast.makeText(this, "Error registering user", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }

        binding.haveAnAccount.setOnClickListener {
            val intent = Intent(this, LogIn::class.java)
            startActivity(intent)
        }
    }
}