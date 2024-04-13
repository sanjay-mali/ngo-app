package com.example.ngo_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.ngo_app.databinding.ActivityEditProfileBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.auth.auth
import com.google.firebase.database.*
import com.google.firebase.firestore.FirebaseFirestore

class EditProfile : AppCompatActivity() {

    private lateinit var binding: ActivityEditProfileBinding
    private lateinit var editTextName: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPhoneNumber: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var btnSaveProfile: Button
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        editTextName = binding.editTextName
        editTextEmail = binding.editTextEmail
        editTextPhoneNumber = binding.editTextPhoneNumber
        editTextPassword = binding.editTextPassword
        btnSaveProfile = binding.btnSaveProfile


        btnSaveProfile.setOnClickListener {
            val name = editTextName.text.toString().trim()
            val email = editTextEmail.text.toString().trim()
            val phoneNumber = editTextPhoneNumber.text.toString().trim()
            val password = editTextPassword.text.toString().trim()
            updateUserProfile(name, email, phoneNumber, password)
        }

//        val currentUser = FirebaseAuth.getInstance().currentUser
//        currentUser?.let {
//            nameEditText.setText(currentUser.displayName)
//            emailEditText.setText(currentUser.email)
//        }

//        saveButton.setOnClickListener {
//            val newName = nameEditText.text.toString()
//            val newEmail = emailEditText.text.toString()
//            val newPhoneNumber = phoneEditText.text.toString()
//
//            val user = FirebaseAuth.getInstance().currentUser
//            val profileUpdates = UserProfileChangeRequest.Builder()
//                .setDisplayName(newName)
//                .build()
//
//            user?.updateProfile(profileUpdates)
//                ?.addOnCompleteListener { task ->
//                    if (task.isSuccessful) {
//                        updateUserDatabase(newName, newEmail, newPhoneNumber)
//                    } else {
//                        Toast.makeText(this@EditProfile, "Failed to update profile", Toast.LENGTH_SHORT).show()
//                    }
//                }
//        }
    }

    private fun updateUserProfile(
        name: String,
        email: String,
        phoneNumber: String,
        password: String,
    ) {

//        val user = Firebase.auth.currentUser
//        user?.let {
//            // Name, email address, and profile photo Url
//            val name = it.displayName
//            val email = it.email
////            val photoUrl = it.photoUrl
//
//            // Check if user's email is verified
////            val emailVerified = it.isEmailVerified
//
//            // The user's ID, unique to the Firebase project. Do NOT use this value to
//            // authenticate with your backend server, if you have one. Use
//            // FirebaseUser.getIdToken() instead.
//            val uid = it.uid
//
//            Log.e("EditProfile", "User $name")
//            Log.e("EditProfile", "User $uid")
//            Log.e("EditProfile", "User $email")
//        }
//        database = Firebase.database.reference.
// Check if user is signed in
//        val auth = FirebaseAuth.getInstance()
//        val currentUser = auth.currentUser
//
//        if (currentUser != null) {
//            // User is signed in, fetch user data
//            val userId = currentUser.uid
//            val userRef = database.child("Users").child(userId)
//
//            userRef.addListenerForSingleValueEvent(object : ValueEventListener {
//                override fun onDataChange(dataSnapshot: DataSnapshot) {
//                    if (dataSnapshot.exists()) {
//                        val username = dataSnapshot.child("username").getValue(String::class.java)
//                        Log.d("EditProfile", "Username: $username")
//                    } else {
//                        Log.e("EditProfile", "User data not found in database")
//                    }
//                }
//
//                override fun onCancelled(databaseError: DatabaseError) {
//                    Log.e("EditProfile", "Failed to read user data: ${databaseError.message}")
//                }
//            })
//        } else {
//            // User is not signed in
//            Log.e("EditProfile", "User is not signed in")
//        }

//        val user = Firebase.auth.currentUser
//        Log.e("EditProfile", "User $user")



//        val database = Firebase.database
//        val myRef = database.getReference("Users")
//        myRef.addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(dataSnapshot: DataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                val value = dataSnapshot.value
//                Log.d("EditProfile", "Value is: $value")
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                // Failed to read value
//                Log.w("EditProfile", "Failed to read value.", error.toException())
//            }
//        })
    //
    }

//        {
//            val newName = editTextName.text.toString().trim()
//            val newEmail = editTextEmail.text.toString().trim()
//            val newPhoneNumber = editTextPhoneNumber.text.toString().trim()
//            val newPassword = editTextPassword.text.toString().trim()
//
//            val user = FirebaseAuth.getInstance().currentUser
//
//            if(user == null) {
//                Log.e("EditProfile", "User is null")
//            }
//
//            user?.updateEmail(newEmail)
//
//                ?.addOnCompleteListener { emailUpdateTask ->
//                    if (emailUpdateTask.isSuccessful) {
//                        // Email updated successfully, now update profile in Firebase Realtime Database
//                        val uid = user.uid
//                        val databaseReference = FirebaseDatabase.getInstance().getReference("Users").child(uid)
//                        val userData = HashMap<String, Any>()
//                        userData["name"] = newName
//                        userData["email"] = newEmail
//                        userData["phoneNumber"] = newPhoneNumber
//                        // Add more fields as needed
//
//                        databaseReference.updateChildren(userData)
//                            .addOnCompleteListener { databaseUpdateTask ->
//                                if(databaseUpdateTask.isSuccessful) {
//                                    // Profile updated successfully
//                                    // You can show a success message or navigate back to the previous screen
//                                }else {
//                                    // Failed to update profile in database
//                                    // Handle the error, show a message, or log the error
//                                }
//                            }
//                    } else {
//                        // Failed to update email in Firebase Authentication
//                        // Handle the error, show a message, or log the error
//                    }
//                }
//
//            // Update password if a new password is provided
//            if (newPassword.isNotEmpty()) {
//                user?.updatePassword(newPassword)
//                    ?.addOnCompleteListener { passwordUpdateTask ->
//                        if (passwordUpdateTask.isSuccessful) {
//                            Log.e("EditProfile", "Password updated successfully")
//                        } else {
//                            // Failed to update password
//                            Log.e("EditProfile", "Failed to update password")
//                            // Handle the error, show a message, or log the error
//                        }
//                    }
//            }
//        }
}