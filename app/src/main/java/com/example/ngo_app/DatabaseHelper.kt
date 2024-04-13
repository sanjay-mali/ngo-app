package com.example.ngo_app

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context:Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "UserDB"
        private const val TABLE_USERS = "users"
        private const val KEY_ID = "id"
        private const val KEY_FULL_NAME = "full_name"
        private const val KEY_EMAIL = "email"
        private const val KEY_PHONE = "phone"
        private const val KEY_PASSWORD = "password"
    }
    override fun onCreate(db: SQLiteDatabase?) {
        val createTableQuery = ("CREATE TABLE $TABLE_USERS ($KEY_ID INTEGER PRIMARY KEY, "
                + "$KEY_FULL_NAME TEXT, $KEY_EMAIL TEXT, $KEY_PHONE TEXT, $KEY_PASSWORD TEXT)")
        db?.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_USERS")
        onCreate(db)
    }
    fun addUser(fullName: String, email: String, phone: String, password: String): Long {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(KEY_FULL_NAME, fullName)
            put(KEY_EMAIL, email)
            put(KEY_PHONE, phone)
            put(KEY_PASSWORD, password)
        }

        return db.insert(TABLE_USERS, null, values)
    }
    fun checkUser(email: String, password: String): Boolean {
        val db = this.readableDatabase
        val query = "SELECT * FROM $TABLE_USERS WHERE $KEY_EMAIL=? AND $KEY_PASSWORD=?"
        val cursor = db.rawQuery(query, arrayOf(email, password))
        val count = cursor.count
        cursor.close()
        return count > 0 // Return true if the user exists with the provided email and password
    }

    fun getFullNameByEmail(email: String): String? {
        val db = this.readableDatabase
        val query = "SELECT $KEY_FULL_NAME FROM $TABLE_USERS WHERE $KEY_EMAIL=?"
        val cursor = db.rawQuery(query, arrayOf(email))
        var fullName: String? = null
        cursor?.use {
            if (it.moveToFirst()) {
                fullName = it.getString(it.getColumnIndex(KEY_FULL_NAME))
            }
        }
        cursor?.close()
        return fullName
    }


}