package com.example.ngo_app

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class Support : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_support)

        val contactSupportButton = findViewById<Button>(R.id.contactSupportButton)

        contactSupportButton.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SEND).apply {
                type = "message/rfc822"
                putExtra(Intent.EXTRA_EMAIL, arrayOf("sanjaymali94284@gmail.com.com"))
                putExtra(Intent.EXTRA_SUBJECT, "Support Request")
            }

            // Check if there's an activity that can handle the email intent
            val emailActivities = packageManager.queryIntentActivities(emailIntent, 0)
            if (emailActivities.isNotEmpty()) {
                startActivity(emailIntent)
            } else {
                // Handle case where no email app is available
                // For example, display a toast or alert dialog
                Toast.makeText(this, "No email app found", Toast.LENGTH_SHORT).show()
            }
        }
    }
}