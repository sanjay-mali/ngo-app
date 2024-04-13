package com.example.ngo_app.fragment

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import com.example.ngo_app.AppointmentDataClass
import com.example.ngo_app.AppointmentDatabaseHelper
import com.example.ngo_app.DatabaseHelper
import com.example.ngo_app.R
import com.example.ngo_app.databinding.FragmentAppointmentBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import java.util.Calendar
import java.util.Locale
import java.util.UUID

class Appointment() : Fragment() {

    private lateinit var binding: FragmentAppointmentBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var firebaseDatabase: FirebaseDatabase
    private var selectedDate: String = ""
    private var selectedTime: String = ""
    private lateinit var dbHelper: AppointmentDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAppointmentBinding.inflate(inflater, container, false)


        dbHelper = AppointmentDatabaseHelper(requireContext())

        binding.selectDateButton.setOnClickListener {
            showDatePicker()
        }

        binding.selectTimeButton.setOnClickListener {
            showTimePicker()
        }

        binding.saveAppointmentButton.setOnClickListener {
            val date = binding.selectDateButton.text.toString()
            val time = binding.selectTimeButton.text.toString()
            val reason = binding.appointmentReasonEditText.text.toString()
            if (date.isNotEmpty() && time.isNotEmpty() && reason.isNotEmpty()) {
                val appointment = AppointmentDataClass(date = date, time = time, reason = reason)
                saveAppointmentToDatabase(appointment)
            } else {
                Toast.makeText(requireContext(), "Please select date, time, and enter reason", Toast.LENGTH_SHORT).show()
            }
        }


        return binding.root
    }

    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = context?.let {
            DatePickerDialog(
                it,
                DatePickerDialog.OnDateSetListener { datePicker: DatePicker, year: Int, monthOfYear: Int, dayOfMonth: Int ->
                    selectedDate = "$dayOfMonth/${monthOfYear + 1}/$year"
                    binding.selectDateButton.text = selectedDate
                },
                year,
                month,
                dayOfMonth
            )
        }
        datePickerDialog?.show()
    }

    private fun showTimePicker() {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        val timePickerDialog = TimePickerDialog(
            context,
            TimePickerDialog.OnTimeSetListener { timePicker: TimePicker, hourOfDay: Int, minute: Int ->
                selectedTime = String.format(Locale.getDefault(), "%02d:%02d", hourOfDay, minute)
                binding.selectTimeButton.text = selectedTime
            },
            hour,
            minute,
            true // 24-hour format
        )
        timePickerDialog.show()
    }

    private fun saveAppointmentToDatabase(appointment: AppointmentDataClass) {
        val insertedId = dbHelper.addAppointment(appointment)
        if (insertedId != -1L) {
            Toast.makeText(requireContext(), "Appointment saved successfully", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(requireContext(), "Failed to save appointment", Toast.LENGTH_SHORT).show()
        }
    }
}