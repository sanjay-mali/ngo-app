package com.example.ngo_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.ngo_app.fragment.SettingFragment

class TermsAndCondition : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terms_and_condition)

        val termsAndConditionTextView = findViewById<TextView>(R.id.termsAndConditionTextView)
        val backToSetting = findViewById<ImageView>(R.id.backToSetting)
        termsAndConditionTextView.text = getString(R.string.terms_conditions_content)

        backToSetting.setOnClickListener {
            val intent = Intent(this, SettingFragment::class.java)
            startActivity(intent)
        }
    }
}