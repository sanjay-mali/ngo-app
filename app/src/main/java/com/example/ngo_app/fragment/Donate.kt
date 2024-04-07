package com.example.ngo_app.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ngo_app.Donation
import com.example.ngo_app.DonationAdapter
import com.example.ngo_app.R
import com.example.ngo_app.databinding.FragmentDonateBinding
import com.example.ngo_app.databinding.FragmentHomeBinding

class Donate : Fragment() {


    private lateinit var binding: FragmentDonateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDonateBinding.inflate(inflater, container, false)

        val donationList = listOf(
            Donation("Donate for Old aged people ", "By Friends care foundation", 500.0, R.drawable.ngo1),
            Donation("Donate for physically and mentally challenged children", "By Omkar Foundation", 1000.0, R.drawable.ngo2),
            Donation("Give a helping hand for poor people","By Manav Kartavya", 750.0, R.drawable.ngo3)
        )

        val recyclerView = binding.donateRecyclerView
        val adapter = DonationAdapter(donationList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)

        return binding.root
    }


}