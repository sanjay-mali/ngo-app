package com.example.ngo_app.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ngo_app.BlogAdapter
import com.example.ngo_app.EventAdapter
import com.example.ngo_app.Eventitem
import com.example.ngo_app.R
import com.example.ngo_app.ViewPagerAdapter
import com.example.ngo_app.databinding.FragmentEventBinding

class EventFragment : Fragment() {

    private var _binding: FragmentEventBinding? = null
    private val binding get() = _binding!!
    private lateinit var eventAdapter: EventAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEventBinding.inflate(inflater, container, false)

        val recyclerView = binding.eventRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val eventItems = getEventList()
        val eventAdapter = EventAdapter(requireContext(), eventItems)
        recyclerView.adapter = eventAdapter

        return binding.root
    }

    private fun getEventList(): List<Eventitem> {
        // Sample data, replace this with your actual data fetching logic
        val eventList = mutableListOf<Eventitem>()
        eventList.add(Eventitem("Event 1", "Description 1", "Date 1" ,"Description 1"))
        eventList.add(Eventitem("Event 2", "Description 2", "Date 2","Description 2"))
        eventList.add(Eventitem("Event 3", "Description 3", "Date 3", "Description 3"))
        // Add more events as needed
        return eventList
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPager = binding.viewPager
        viewPager.adapter = ViewPagerAdapter(childFragmentManager)

        val tabLayout = binding.tabLayout
        tabLayout.setupWithViewPager(viewPager)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}