package com.example.ngo_app

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ngo_app.databinding.ActivityLogInBinding
import com.google.firebase.Firebase
import com.google.firebase.database.database

class LogIn : AppCompatActivity() {

    private lateinit var binding: ActivityLogInBinding
    private val database = Firebase.database
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.logInButton.setOnClickListener {
            val username = binding.uname.text.toString()
            val password = binding.password.text.toString()

            if (username.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            else
            {
                checkUser(username, password)
                finish()
            }
//                        if (data?.email == phoneNumber && data.password == password){
//                            Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show()
//                        }
//                        else{
//                            Toast.makeText(this, "Invalid Email or Password", Toast.LENGTH_SHORT).show()
//                        }
//                    }
//                }
//
//            }
        }

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        if (isLoggedIn()) {
            redirectToHome()
        } else {
            loginUser()
        }

        binding.signUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity2::class.java)
            startActivity(intent)
        }
    }

    private fun isLoggedIn(): Boolean {
        return sharedPreferences.getBoolean("isLoggedIn", false)
    }

    private fun redirectToHome() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
    private fun loginUser() {
        val editor = sharedPreferences.edit()
        editor.putBoolean("isLoggedIn", true)
        editor.apply()
        redirectToHome()
    }
    private fun checkUser(username: String, password: String) {
        val myRef = database.getReference("Users")
        myRef.child(username).get().addOnSuccessListener {
            if (it.exists()){
                val user = it.child("username").value
                myRef.child(username).child("password").get().addOnSuccessListener {
                    if(it.exists())
                    {
                        val pwd = it.value
                        if(pwd == password)
                        {
                            val sIntent = Intent(this,MainActivity::class.java)
                            startActivity(sIntent)
                        }
                        else
                        {
                            Toast.makeText(this, "Wrong Password", Toast.LENGTH_SHORT).show()
                        }
                    }
                    else
                    {
                        Toast.makeText(this, "Password not found", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            else
            {
                Toast.makeText(this, "User not found", Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener {
            Toast.makeText(this, "Failure to load ", Toast.LENGTH_SHORT).show()
        }
    }
}