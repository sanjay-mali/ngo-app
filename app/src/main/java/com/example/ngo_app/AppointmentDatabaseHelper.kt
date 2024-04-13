package com.example.ngo_app

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class AppointmentDatabaseHelper(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "AppointmentDB"
        private const val TABLE_APPOINTMENTS = "appointments"
        private const val KEY_ID = "id"
        private const val KEY_DATE = "date"
        private const val KEY_TIME = "time"
        private const val KEY_REASON = "reason"
    }
    override fun onCreate(db: SQLiteDatabase?) {
        val createTableQuery = ("CREATE TABLE $TABLE_APPOINTMENTS ($KEY_ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "$KEY_DATE TEXT, $KEY_TIME TEXT, $KEY_REASON TEXT)")
        db?.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_APPOINTMENTS")
        onCreate(db)
    }

    fun addAppointment(appointment: AppointmentDataClass): Long {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(KEY_DATE, appointment.date)
        values.put(KEY_TIME, appointment.time)
        values.put(KEY_REASON, appointment.reason)
        return db.insert(TABLE_APPOINTMENTS, null, values)
    }

    fun getAllAppointments(): List<AppointmentDataClass> {
        val appointmentList = mutableListOf<AppointmentDataClass>()
        val db = this.readableDatabase
        val cursor: Cursor? = db.rawQuery("SELECT * FROM $TABLE_APPOINTMENTS", null)
        cursor?.use {
            while (it.moveToNext()) {
                val id = it.getLong(it.getColumnIndex(KEY_ID))
                val date = it.getString(it.getColumnIndex(KEY_DATE))
                val time = it.getString(it.getColumnIndex(KEY_TIME))
                val reason = it.getString(it.getColumnIndex(KEY_REASON))
                val appointment = AppointmentDataClass(id, date, time, reason)
                appointmentList.add(appointment)
            }
        }
        return appointmentList
    }

}