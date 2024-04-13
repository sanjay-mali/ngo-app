package com.example.ngo_app

data class AppointmentDataClass(
    val id: Long = -1,
    val date: String,
    val time: String,
    val reason: String
)