package com.example.ngo_app

import com.example.ngo_app.AppointmentAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ngo_app.databinding.ActivityAppointmentListsBinding

class AppointmentLists : AppCompatActivity() {

    private lateinit var binding: ActivityAppointmentListsBinding
    private lateinit var dbHelper: AppointmentDatabaseHelper
    private lateinit var appointmentAdapter: AppointmentAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppointmentListsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        appointmentAdapter = AppointmentAdapter()
        binding.recyclerViewAppointments.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewAppointments.adapter = appointmentAdapter

        dbHelper = AppointmentDatabaseHelper(this)
        val appointments = dbHelper.getAllAppointments()
        appointmentAdapter.updateAppointments(appointments)

    }
}