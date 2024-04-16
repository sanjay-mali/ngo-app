package com.example.ngo_app

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EventAdapter(private val context: Context, private val eventList: List<Eventitem>) :
    RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    inner class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val eventNameTextView: TextView = itemView.findViewById(R.id.eventNameTextView)
        val eventDateTextView: TextView = itemView.findViewById(R.id.eventDateTextView)
        val eventLocationTextView: TextView = itemView.findViewById(R.id.eventLocationTextView)
        val eventDescriptionTextView: TextView = itemView.findViewById(R.id.eventDescriptionTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.event_item_card, parent, false)
        return EventViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val currentEvent = eventList[position]
        holder.eventNameTextView.text = currentEvent.eventName
        holder.eventDateTextView.text = currentEvent.eventDate
        holder.eventLocationTextView.text = currentEvent.eventLocation
        holder.eventDescriptionTextView.text = currentEvent.eventDescription

        holder.itemView.setOnClickListener {
            // Handle item click event here
            val intent = Intent(context, EventDetailsActivity::class.java).apply {
                putExtra("EVENT_NAME", currentEvent.eventName)
                putExtra("EVENT_DATE", currentEvent.eventDate)
                putExtra("EVENT_LOCATION", currentEvent.eventLocation)
                putExtra("EVENT_DESCRIPTION", currentEvent.eventDescription)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return eventList.size
    }
}