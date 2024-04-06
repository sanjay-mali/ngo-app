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
        const val NGO_DESCRIPTION = "com.example.ngo_app.NGO_DESCRIPTION"
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

        // Use the received data as needed
        binding.ngoLocation.text = location
        binding.ngoDescription.text = description
//        binding.textViewPosition.text = position.toString()
        arguments?.let {
            ngoDescription = it.getString(NGO_DESCRIPTION)
            ngoLocation = it.getString(NGO_LOCATION)
            ngoPosition = it.getInt(NGO_POSITION)
        }
//        val ngoDescription = intent.getStringExtra(KnowMore.EXTRA_NGO_DESCRIPTION)
//        val imageList = ArrayList<SlideModel>()
//        binding.ngoLocation.text = ngoLocation

        // Inside your fragment where you handle the Know More button click

//        when (sharedViewModel.selectedPosition) {
//            0 -> {
//                binding.ngoDescription.text = getString(R.string.ngo1)
//            }
//            1 -> {
//                binding.ngoDescription.text = getString(R.string.ngo2)
//            }
//            2 -> {
//                binding.ngoDescription.text = getString(R.string.ngo3)
//            }
//        }


        return binding.root
    }



}