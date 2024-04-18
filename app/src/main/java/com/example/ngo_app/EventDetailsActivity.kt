package com.example.ngo_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class EventDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_details)


        val eventName = intent.getStringExtra("EVENT_NAME")
        val eventDate = intent.getStringExtra("EVENT_DATE")
        val eventLocation = intent.getStringExtra("EVENT_LOCATION")
        val eventDescription = intent.getStringExtra("EVENT_DESCRIPTION")
        val eventImage = intent.getStringExtra("EVENT_IMAGE")

        val eventImageView = findViewById<ImageView>(R.id.eventImageView)
        // Set the event details to respective TextViews in the layout
        findViewById<TextView>(R.id.eventNameTextView).text = eventName
        findViewById<TextView>(R.id.eventDateTextView).text = eventDate
        findViewById<TextView>(R.id.eventLocationTextView).text = eventLocation
        findViewById<TextView>(R.id.eventDescriptionTextView).text = eventDescription
        Glide.with(this).load(eventImage).into(eventImageView)

        val backButton = findViewById<ImageView>(R.id.backButton)

        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

}