package com.example.ngo_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.Toast
import com.example.ngo_app.fragment.SettingFragment
import com.google.firebase.database.FirebaseDatabase

class RatingAndFeedback : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rating_and_feedback)
        val ratingBar = findViewById<RatingBar>(R.id.ratingBar)
        val feedbackEditText = findViewById<EditText>(R.id.feedbackEditText)
        val submitButton = findViewById<Button>(R.id.submitFeedbackButton)
        val backToSetting = findViewById<ImageView>(R.id.backToSetting)

        submitButton.setOnClickListener {
            val rating = ratingBar.rating
            val feedback = feedbackEditText.text.toString()

            val ratingFeedback = RatingFeedback(rating, feedback)

            // Get a reference to your Firebase database
            val database = FirebaseDatabase.getInstance()
            val feedbackRef = database.getReference("feedback")

            // Generate a unique key for each feedback entry
            val feedbackKey = feedbackRef.push().key

            // Check if the key is generated successfully
            if (feedbackKey != null) {
                // Store the rating and feedback under the generated key
                feedbackRef.child(feedbackKey).setValue(ratingFeedback)
                    .addOnSuccessListener {
                        // Feedback stored successfully
                        Toast.makeText(
                            this,
                            "Rating and feedback submitted successfully!",
                            Toast.LENGTH_SHORT
                        ).show()
                        // Clear the feedback EditText after submission
                        feedbackEditText.text.clear()
                    }
                    .addOnFailureListener {
                        // Error occurred while storing feedback
                        Toast.makeText(
                            this,
                            "Failed to submit rating and feedback. Please try again.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
            }
        }
        backToSetting.setOnClickListener {
            val intent = Intent(this, SettingFragment::class.java)
            startActivity(intent)
        }
    }
}