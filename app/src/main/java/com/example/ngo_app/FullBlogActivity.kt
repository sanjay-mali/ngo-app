package com.example.ngo_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.ngo_app.databinding.ActivityFullBlogBinding
import com.example.ngo_app.fragment.BlogFragment

class FullBlogActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFullBlogBinding

    companion object {
        const val BLOG_TITLE = "blogItem"
        const val BLOG_IMAGE = "blogImage"
        const val BLOG_CONTENT = "blogContent"

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFullBlogBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = intent.getStringExtra("BLOG_TITLE")
        val imageUrl = intent.getStringExtra("BLOG_IMAGE")
        val content = intent.getStringExtra("BLOG_CONTENT")

        binding.titleTextView.text = title
        binding.contentTextView.text = content
        Glide.with(this).load(imageUrl).into(binding.imageView)

        binding.backButton.setOnClickListener {
            val intent = Intent(this,BlogFragment::class.java)
            startActivity(intent)
        }
    }
}