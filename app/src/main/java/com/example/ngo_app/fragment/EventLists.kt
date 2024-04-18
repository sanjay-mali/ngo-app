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
        eventList.add(Eventitem("Outbreak of Kindness", "The Yuva Mandal (Youth Group) of Parikshitnagar, a small low-income community just near the Gandhi Ashram, pooled their own money and started collecting funds from their neighborhood to run a daily kitchen. MS has provided them with the dry groceries as they use their collection to buy fresh vegetables and cover the cost of cooking and transport. The group decided to prepare a different daily menu with wholesome meals other than kichadi. One part of the team identifies needy localities, one takes care of purchasing and transport and the other prepares the food. This team of nine youth feed close to 600 people daily. They even offer chai and ganthiya to police officers as a gesture of gratitude.", "April, 30,2024" ,"Manavsadhan","https://manavsadhna.org/wp-content/uploads/2022/06/outbreak-of-kindness-2.jpg"))
        eventList.add(Eventitem("Visamo kids", "February 11, 2023", "Uvarsad-Adalaj Road, Gandhinagar ","Visamo Kids Foundation in Ahmedabad, India has an event on December 15, 2023. They also hosted an event on September 9, 2023, to raise funds for their programs that support underprivileged youth.Here are some other events that Visamo Kids Foundation has held: February 11, 2023: 7 PM and later at Karnavati University, Uvarsad-Adalaj Road, Gandhinagar Visamo Kids Foundation is an NGO that helps children. Some say the NGO takes care of the children and provides great facilities. Others say it's a deserving place that helps children grow positively in a difficult world.", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS3Ng1kbxnzr5TZKfQy2OgYyiTltenbMg0Q1a7sm_SPvA&s"))
        eventList.add(Eventitem("a trivia night about superheroes", "June 12, 2024","Gujarati Book Club", "Gujarati Book Club The Karma Foundation has many events, including campaigns, scholarships, and street schools. The foundation also has a Community Soup Kitchen that serves meals. The Karma Foundation is an NGO that aims to help people meet new people and inspire themselves. Some of its events include: Elijah's Promise: A program that has served over 17,000 meals at the Community Soup Kitchen in one month Jeevan Shrishti: A scholarship program for street schools Gujarati Book Club: A campaign Sanitary Hygiene: An event","https://pbs.twimg.com/media/FqX8PbGWYAEC6kY.jpg:large"))

        return eventList
    }


}