package com.example.ngo_app.fragment

import NgoAdapter
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.ngo_app.NgoModel
import com.example.ngo_app.R
import com.example.ngo_app.UserProfile
import com.example.ngo_app.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val ngoList = generateNgoList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        val recyclerView = binding.ngoRecyclerView
        val adapter = NgoAdapter(ngoList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)

        binding.Userprofile.setOnClickListener{
            val profile = Intent(context,UserProfile::class.java)
            startActivity(profile)
        }

        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.slide2))
        imageList.add(SlideModel(R.drawable.slide3))
        imageList.add(SlideModel(R.drawable.slide1))

        val imageSlider = binding.imageSlider
        imageSlider.setImageList(imageList)
        imageSlider.setImageList(imageList,scaleType = ScaleTypes.FIT)


        return binding.root
    }
    private fun generateNgoList(): List<NgoModel> {
        val ngoList = ArrayList<NgoModel>()

        ngoList.add(
            NgoModel(
                R.drawable.ngo1,
                "Friends Care Foundation",
                "Ahmedabad, Gujarat, India",
                "Friends Care Foundation is a non-profit organization that works"
                )
        )
        ngoList.add(
            NgoModel(
                R.drawable.ngo2,
                "Omkar Foundation Trust",
                "Ahmedabad, Gujarat",
                "Omkar Foundation Trust is a non-profit organization that works"
            )
        )
        ngoList.add(
            NgoModel(
                R.drawable.ngo3,
                "MANAV KARTAVYA NGO",
                "Ahmedabad, Gujarat",
                "MANAV KARTAVYA NGO is a non-profit organization that works"
            )
        )

        return ngoList
    }

}