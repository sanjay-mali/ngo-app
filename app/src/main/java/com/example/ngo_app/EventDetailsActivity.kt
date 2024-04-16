package com.example.ngo_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class EventDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_details)


        val eventName = intent.getStringExtra("EVENT_NAME")
        val eventDate = intent.getStringExtra("EVENT_DATE")
        val eventLocation = intent.getStringExtra("EVENT_LOCATION")
        val eventDescription = intent.getStringExtra("EVENT_DESCRIPTION")

        // Set the event details to respective TextViews in the layout
        findViewById<TextView>(R.id.eventNameTextView).text = eventName
        findViewById<TextView>(R.id.eventDateTextView).text = eventDate
        findViewById<TextView>(R.id.eventLocationTextView).text = eventLocation
        findViewById<TextView>(R.id.eventDescriptionTextView).text = eventDescription

    }

}