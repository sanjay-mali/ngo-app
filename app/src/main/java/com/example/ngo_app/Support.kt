package com.example.ngo_app

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.example.ngo_app.fragment.SettingFragment

class Support : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_support)

        val sendEmailBtn = findViewById<Button>(R.id.sendEmailBtn)
        val recipientEt = "support@ngohelp.com"
        val subjectEt = findViewById<EditText>(R.id.subjectEt)
        val messageEt = findViewById<EditText>(R.id.messageEt)
        val backButton = findViewById<ImageView>(R.id.backButton)


        sendEmailBtn.setOnClickListener {
            val recipient = recipientEt
            val subject = subjectEt.text.toString().trim()
            val message = messageEt.text.toString().trim()
                sendEmail(recipient, subject, message)
        }

        backButton.setOnClickListener {
            val intent = Intent(this,SettingFragment::class.java)
            startActivity(intent)
        }

    }
    private fun sendEmail(recipient: String, subject: String, message: String) {
        val mIntent = Intent(Intent.ACTION_SEND)
        mIntent.data = Uri.parse("mailto:")
        mIntent.type = "text/plain"
        mIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
        mIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
        mIntent.putExtra(Intent.EXTRA_TEXT, message)


        try {
            val intent = Intent.createChooser(mIntent, "Choose Email Client...",)
            startActivity(intent)
        }
        catch (e: Exception){
            Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
        }

    }
}