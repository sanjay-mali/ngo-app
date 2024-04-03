package com.example.ngo_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ngo_app.databinding.ActivityLogInBinding
import com.google.firebase.Firebase
import com.google.firebase.database.database

class LogIn : AppCompatActivity() {

    private lateinit var binding: ActivityLogInBinding
    val database = Firebase.database
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.logInButton.setOnClickListener {
            val phoneNumber = binding.email.text.toString()
            val password = binding.password.text.toString()

            if (phoneNumber.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            else
            {
                val myRef = database.getReference("Users")
                myRef.child(phoneNumber).get().addOnSuccessListener {
                    if (it.exists()){
                        val user = it.child("phoneNumber").value
                        myRef.child(phoneNumber).child("password").get().addOnSuccessListener { data ->
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

        binding.signUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity2::class.java)
            startActivity(intent)
        }
    }
}