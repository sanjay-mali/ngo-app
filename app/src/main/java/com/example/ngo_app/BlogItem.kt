package com.example.ngo_app

import android.os.Parcelable

data class BlogItem(
    val id: Long,
    val title: String,
    val content: String,
    val author: String,
    val imageUrl: String
)