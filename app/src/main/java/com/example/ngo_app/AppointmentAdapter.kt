package com.example.ngo_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.ngo_app.databinding.ItemAppointmentBinding

class AppointmentAdapter : RecyclerView.Adapter<AppointmentAdapter.AppointmentViewHolder>() {

    private var appointmentList = emptyList<AppointmentDataClass>() // List of appointments

    inner class AppointmentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewAppointmentDetails: TextView = itemView.findViewById(R.id.textViewAppointmentDetails)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppointmentViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_appointment, parent, false)
        return AppointmentViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AppointmentViewHolder, position: Int) {
        val currentAppointment = appointmentList[position]
        holder.textViewAppointmentDetails.text = "Date: ${currentAppointment.date}, Time: ${currentAppointment.time}, Reason: ${currentAppointment.reason}"
    }

    override fun getItemCount(): Int {
        return appointmentList.size
    }

    fun updateAppointments(appointments: List<AppointmentDataClass>) {
        appointmentList = appointments
        notifyDataSetChanged() // Refresh the RecyclerView
    }
}
