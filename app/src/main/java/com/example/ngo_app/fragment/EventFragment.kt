package com.example.ngo_app.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ngo_app.ViewPagerAdapter
import com.example.ngo_app.databinding.FragmentEventBinding

class EventFragment : Fragment() {

    lateinit var binding: FragmentEventBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEventBinding.inflate(inflater, container, false)


        val viewPager = binding.viewPager
        viewPager.adapter = ViewPagerAdapter(childFragmentManager)

        val tabLayout = binding.tabLayout
        tabLayout.setupWithViewPager(viewPager)


        return binding.root
    }
}