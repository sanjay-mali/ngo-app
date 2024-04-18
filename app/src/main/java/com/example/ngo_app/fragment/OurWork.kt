package com.example.ngo_app.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.ngo_app.KnowMore
import com.example.ngo_app.R
import com.example.ngo_app.SharedViewModel
import com.example.ngo_app.databinding.ActivityKnowMoreBinding
import com.example.ngo_app.databinding.FragmentHomeBinding
import com.example.ngo_app.databinding.FragmentOurWorkBinding

class OurWork : Fragment() {

    private lateinit var binding: FragmentOurWorkBinding

    companion object {
        const val NGO_LOCATION = "com.example.ngo_app.NGO_LOCATION"
        const val NGO_POSITION = "com.example.ngo_app.NGO_POSITION"
        var NGO_DESCRIPTION = "com.example.ngo_app.NGO_DESCRIPTION"
    }
    private var ngoDescription: String? = null
    private var ngoLocation: String? = null
    private var ngoPosition: Int = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOurWorkBinding.inflate(inflater, container, false)

        val location = arguments?.getString("location")
        val description = arguments?.getString("description")
        val position = arguments?.getInt("position")

        binding.ngoLocation.text = "Ahmedabad"
        binding.ngoDescription.text = getString(R.string.ngo1)
        return binding.root
    }



}