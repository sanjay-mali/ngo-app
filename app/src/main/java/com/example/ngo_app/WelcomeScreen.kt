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

        if (isLoggedIn()) {
            redirectToHome()
            finish()
        }else {
            // The user is not logged in
            startBtn = findViewById(R.id.startBtn)
            startBtn.setOnClickListener {
                val intent = Intent(this, LogIn::class.java)
                startActivity(intent)
                finish()
            }

        }
    }

    private fun isLoggedIn(): Boolean {
        // Retrieve login status from SharedPreferences
        val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean("isLoggedIn", false)
    }

    private fun redirectToHome() {
        // Redirect the user to the home page
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish() // Finish current activity to prevent going back to welcome screen
    }

    private fun onGetStartedClicked(view: View) {
        // Redirect the user to the login screen
        val intent = Intent(this, LogIn::class.java)
        startActivity(intent)
        finish()
    }
}