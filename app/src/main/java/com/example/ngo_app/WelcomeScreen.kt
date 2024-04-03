package com.example.ngo_app

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button

class WelcomeScreen : AppCompatActivity() {
    private lateinit var startBtn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_screen)
        startBtn = findViewById(R.id.startBtn)
        startBtn.setOnClickListener {
            if (isLoggedIn()) {
                redirectToHome()
            } else {
                onGetStartedClicked(startBtn)
            }
        }
    }

    private fun isLoggedIn(): Boolean {
        val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean("isLoggedIn", false)
    }

    private fun redirectToHome() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun onGetStartedClicked(view: View) {
        val intent = Intent(this, LogIn::class.java)
        startActivity(intent)
    }
}