package com.example.ngo_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class welcome_screen : AppCompatActivity() {
    private lateinit var startBtn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_screen)
        startBtn = findViewById(R.id.startBtn)
        startBtn.setOnClickListener {
            val intent = Intent(this, LogIn::class.java)
            startActivity(intent)
        }


    }
}