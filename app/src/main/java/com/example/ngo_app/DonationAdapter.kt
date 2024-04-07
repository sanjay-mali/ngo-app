package com.example.ngo_app

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DonationAdapter(private val donations: List<Donation>) :
    RecyclerView.Adapter<DonationAdapter.DonationViewHolder>() {

    inner class DonationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.ngoImageTextView)
        private val titleTextView: TextView = itemView.findViewById(R.id.donation_nameTextView)
        private val ngoNameTextView: TextView = itemView.findViewById(R.id.ngo_name_fot_donation)
        private val amountRaisedTextView: TextView = itemView.findViewById(R.id.raisedTextView)

        @SuppressLint("SetTextI18n")
        fun bind(donation: Donation) {
            imageView.setImageResource(donation.imageResId)
            titleTextView.text = donation.title
            ngoNameTextView.text = donation.ngoName
            amountRaisedTextView.text = "Raised: ${donation.amountRaised}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DonationViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.dotate_card, parent, false)
        return DonationViewHolder(view)
    }

    override fun onBindViewHolder(holder: DonationViewHolder, position: Int) {
        holder.bind(donations[position])
    }

    override fun getItemCount(): Int = donations.size
}
