package com.example.ngo_app.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ngo_app.EventAdapter
import com.example.ngo_app.Eventitem
import com.example.ngo_app.R
import com.example.ngo_app.databinding.FragmentEventListsBinding

class EventLists : Fragment() {

    private lateinit var binding: FragmentEventListsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEventListsBinding.inflate(inflater, container, false)

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


}