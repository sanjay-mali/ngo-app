package com.example.ngo_app

import TeamAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class OurTeam : AppCompatActivity() {

    private val teamList = listOf(
        TeamMember("Sanjay Mali", "Developer", "Experienced Android & Web Developer", R.drawable.ngo1),
        TeamMember("Misha Joshi", "Designer", "Creative Graphic Designer", R.drawable.ngo2),
        TeamMember("Kinnari Kapure", "Nullable", "Creative Graphic Designer", R.drawable.ngo3),
        TeamMember("Mustkim Khokhar", "Designer", "Creative Graphic Designer", R.drawable.ngo2),

    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_our_team)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewTeam)
        recyclerView.adapter = TeamAdapter(teamList)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}