package com.example.ngo_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.ngo_app.databinding.ActivityFullVolunteerBinding
import com.example.ngo_app.fragment.EventLists
import com.example.ngo_app.fragment.Volunteer

class FullVolunteerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFullVolunteerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFullVolunteerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val programName = intent.getStringExtra("PROGRAM_NAME")
        val ngoName = intent.getStringExtra("NGO_NAME")
        val details = intent.getStringExtra("DETAILS")
        val dateRange = intent.getStringExtra("DATE_RANGE")
        val imageUrl = intent.getStringExtra("IMAGE_URL")

        // Get the position of the NGO in the list
        binding.registerButton.setOnClickListener {
//            Toast.makeText(this, "Registered for $programName", Toast.LENGTH_SHORT).show()

            when (intent.getIntExtra("NGO_POSITION", 0)) {
            0 -> {

            }
            1 -> {
                Toast.makeText(this, "PROGram 2 ", Toast.LENGTH_SHORT).show()

            }
            2 -> {ā
                Toast.makeText(this, "PROGram 3 ", Toast.LENGTH_SHORT).show()

            }
        }
        }

        binding.backButton.setOnClickListener {
            val intent = Intent(this,EventLists::class.java)
            startActivity(intent)
        }

        // Now set these details to the corresponding views in your layout
        binding.programNameTextView.text = programName
        binding.ngoNameTextView.text = ngoName
        binding.programDetailsTextView.text = details
        binding.dateRangeTextView.text = dateRange
        // Load the image using Glide or your preferred image loading library
        Glide.with(this).load(imageUrl).into(binding.programImageView)

    }
}