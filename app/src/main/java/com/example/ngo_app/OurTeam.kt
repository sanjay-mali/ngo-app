package com.example.ngo_app

import TeamAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class OurTeam : AppCompatActivity() {

    private val teamList = listOf(
        TeamMember("Name: Sanjay Mali", "Role: Developer", "Bio: Experienced Android & Web Developer"),
        TeamMember("Name: Misha Joshi", "Role: Designer", "Bio: Creative UI/UX Designer"),
        TeamMember("Name: Kinnari Kapure", "Role: Developer", "Bio: Web Developer & Designer"),
        TeamMember("Name: Mustkim Khokhar", "Role: Designer", "Bio: Creative Graphic Designer"),

    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_our_team)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewTeam)
        recyclerView.adapter = TeamAdapter(teamList)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}