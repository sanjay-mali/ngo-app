package com.example.ngo_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.ngo_app.databinding.ActivityFullBlogBinding

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

        // Retrieve blog item data from intent
        val title = intent.getStringExtra("BLOG_TITLE")
        val imageUrl = intent.getStringExtra("BLOG_IMAGE")
        val content = intent.getStringExtra("BLOG_CONTENT")

        // Populate views with blog item data

            binding.titleTextView.text = title
            binding.contentTextView.text = content
            // Load image using Glide or Picasso library
            Glide.with(this).load(imageUrl).into(binding.imageView)
            // Glide.with(this).load(it.imageUrl).into(binding.imageView)

    }
}