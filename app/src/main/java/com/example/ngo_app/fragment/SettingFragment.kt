package com.example.ngo_app.fragment
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ngo_app.DatabaseHelper
import com.example.ngo_app.OurTeam
import com.example.ngo_app.RatingAndFeedback
import com.example.ngo_app.TeamMember
import com.example.ngo_app.TermsAndCondition
import com.example.ngo_app.UserProfile
import com.example.ngo_app.databinding.FragmentSettingBinding
import com.example.ngo_app.faq_item
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class SettingFragment : Fragment() {

    private var _binding: FragmentSettingBinding? = null
    private lateinit var dbHelper: DatabaseHelper

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingBinding.inflate(inflater, container, false)

        binding.profileBtn.setOnClickListener{
            val intent = Intent(activity, UserProfile::class.java)
//            intent.putExtra("username", username)
            startActivity(intent)
//            activity?.finish()
        }
//        dbHelper = context?.let { DatabaseHelper(it) }!!
//        dbHelper = DatabaseHelper(requireContext())
//        val currentUserEmail = "user@example.com"
//        val fullName = dbHelper.getFullName(currentUserEmail)
//        fullName?.let {
//            // Set the full name to a TextView or any other UI element
//            binding.username.text = fullName
//        }
        val sharedPrefs = requireActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        // Retrieve the email from SharedPreferences
        val email = sharedPrefs.getString("email", "")
        dbHelper = DatabaseHelper(requireContext())
        val fullName = dbHelper.getFullNameByEmail(email!!)
        binding.username.text = fullName


        binding.ourTeams.setOnClickListener{
            val intent = Intent(activity, OurTeam::class.java)
            startActivity(intent)
        }

        binding.faqs.setOnClickListener{
            val intent = Intent(activity, faq_item::class.java)
            startActivity(intent)
        }

        binding.termsAndConditions.setOnClickListener {
            val intent = Intent(activity, TermsAndCondition::class.java)
            startActivity(intent)
        }

        binding.rating.setOnClickListener {
            val intent = Intent(activity,RatingAndFeedback::class.java)
            startActivity(intent)
        }



        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}