package com.example.ngo_app.fragment
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ngo_app.OurTeam
import com.example.ngo_app.TeamMember
import com.example.ngo_app.UserProfile
import com.example.ngo_app.databinding.FragmentSettingBinding
import com.example.ngo_app.faq_item

class SettingFragment : Fragment() {

    private var _binding: FragmentSettingBinding? = null
    private lateinit var sharedPreferences: SharedPreferences
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingBinding.inflate(inflater, container, false)

        sharedPreferences = requireActivity().getSharedPreferences("MyPrefs", 0)

        val username = sharedPreferences.getString("username", "User")
        binding.username.text = username

        binding.profileBtn.setOnClickListener{
            val intent = Intent(activity, UserProfile::class.java)
            intent.putExtra("username", username)
            startActivity(intent)
            activity?.finish()
        }

        binding.ourTeams.setOnClickListener{
            val intent = Intent(activity, OurTeam::class.java)
            startActivity(intent)
        }

        binding.faqs.setOnClickListener{
            val intent = Intent(activity, faq_item::class.java)
            startActivity(intent)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}