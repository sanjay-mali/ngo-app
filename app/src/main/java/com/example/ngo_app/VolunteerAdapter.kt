package com.example.ngo_app

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ngo_app.fragment.Volunteer

class VolunteerAdapter(
    private val context: Context,
    val volunteerList: List<VolunteerProgram>,
    private val listener: Volunteer
) : RecyclerView.Adapter<VolunteerAdapter.VolunteerViewHolder>() {

    inner class VolunteerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val programNameTextView: TextView = itemView.findViewById(R.id.programNameTextView)
        val ngoNameTextView: TextView = itemView.findViewById(R.id.ngoNameTextView)
        val detailsTextView: TextView = itemView.findViewById(R.id.programDetailsTextView)
        val programImageView: ImageView = itemView.findViewById(R.id.programImageView)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            val intent = Intent(context, FullVolunteerActivity::class.java)
            val currentItem = volunteerList[position]
            intent.putExtra("PROGRAM_POSITION", position)
            context.startActivity(intent)
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VolunteerViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_volunteer_program, parent, false)
        return VolunteerViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: VolunteerViewHolder, position: Int) {
        val currentItem = volunteerList[position]
        holder.programNameTextView.text = currentItem.programName
        holder.ngoNameTextView.text = currentItem.ngoName
        holder.detailsTextView.text = currentItem.programDetails
        Glide.with(context).load(currentItem.imageUrl).into(holder.programImageView)
    }

    override fun getItemCount(): Int {
        return volunteerList.size
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}
