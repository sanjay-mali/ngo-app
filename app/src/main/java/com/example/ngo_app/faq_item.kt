package com.example.ngo_app

import FaqAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ngo_app.fragment.SettingFragment

class faq_item : AppCompatActivity() {

    private lateinit var faqAdapter: FaqAdapter
    private lateinit var faqRecyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_faq_item)

        val faqList = listOf(
            FaqItem("How can I donate to NGOs listed in the app?", "You can donate to NGOs directly through the app by clicking on the \"Donate Now\" button on their profile or donation cards. Follow the instructions provided to complete your donation securely."),
            FaqItem("Can I create my own NGO profile on the app?", "Currently, only registered NGOs can create profiles on the app. If you represent an NGO and would like to join the platform, please contact our support team for assistance."),
            FaqItem("How can I update or delete a blog post that I've created?", "If you are an admin or authorized user, you can update or delete your blog posts from the admin panel. Log in to the admin dashboard to manage your blog content."),
            FaqItem("Is my personal information secure on the app?", "We take data security and privacy seriously. Your personal information is encrypted and stored securely. We do not share your information with third parties without your consent."),
            FaqItem("Can I volunteer for NGOs through this app?", "While you cannot directly volunteer through the app, you can use the app to find NGOs and their contact information. Reach out to NGOs you are interested in volunteering for directly to inquire about volunteer opportunities."),
            FaqItem("How can I report inappropriate content or issues with the app?", "If you encounter any inappropriate content or technical issues within the app, please report them to our support team immediately. Your feedback helps us improve the app for all users."),
            FaqItem("How can I contact the support team for assistance?", "You can contact our support team by emailing")
        )

        faqRecyclerView = findViewById(R.id.faqRecyclerView)
        faqAdapter = FaqAdapter(faqList)
        faqRecyclerView.adapter = faqAdapter
        faqRecyclerView.layoutManager = LinearLayoutManager(this)

        val backToSetting = findViewById<ImageView>(R.id.backToSetting)
        backToSetting.setOnClickListener {
            val intent = Intent(this, SettingFragment::class.java)
            startActivity(intent)
        }
    }
}