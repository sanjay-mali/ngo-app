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
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUp2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()

        binding.signUpButton.setOnClickListener {
            val name = binding.name.text.toString()
            val phoneNumber = binding.phoneNumber.text.toString()
            val email = binding.email.text.toString()
            val password = binding.pwd.text.toString()
            val username = binding.userName.text.toString()

            val data = Users(name, phoneNumber, email, password,username)
            val database = Firebase.database
            val myRef = database.getReference("Users")
            myRef.child(username).setValue(data)
                .addOnSuccessListener {
                    Toast.makeText(this, "Register Successfully", Toast.LENGTH_SHORT).show()

                }.addOnFailureListener() {
                    Toast.makeText(this, "Failure ", Toast.LENGTH_SHORT).show()
                }
            if (email.isEmpty() || password.isEmpty() || name.isEmpty() || phoneNumber.isEmpty() || username.isEmpty()){

                Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
        }

        binding.haveAnAccount.setOnClickListener {
            val intent = Intent(this, LogIn::class.java)
            startActivity(intent)
        }
    }
}