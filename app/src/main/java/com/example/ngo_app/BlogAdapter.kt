package com.example.ngo_app

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class BlogAdapter(private val context: Context,private val blogList: List<BlogItem>) : RecyclerView.Adapter<BlogAdapter.BlogViewHolder>() {

    inner class BlogViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        val contentTextView: TextView = itemView.findViewById(R.id.contentTextView)
        val authorTextView: TextView = itemView.findViewById(R.id.authorTextView)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val readMoreButton: Button = itemView.findViewById(R.id.readMoreButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.blog_item_card, parent, false)
        return BlogViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) {
        val currentItem = blogList[position]
        holder.titleTextView.text = currentItem.title
        holder.contentTextView.text = currentItem.content
        holder.authorTextView.text = currentItem.author
        Glide.with(holder.imageView.context).load(currentItem.imageUrl).into(holder.imageView)

        holder.readMoreButton.setOnClickListener {
            val intent = Intent(holder.itemView.context, FullBlogActivity::class.java)
            intent.putExtra("BLOG_TITLE", currentItem.title)
            intent.putExtra("BLOG_IMAGE", currentItem.imageUrl)
            intent.putExtra("BLOG_CONTENT", currentItem.content)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return blogList.size
    }
}
