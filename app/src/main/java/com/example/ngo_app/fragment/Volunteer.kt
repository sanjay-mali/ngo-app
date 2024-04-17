package com.example.ngo_app.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ngo_app.FullVolunteerActivity
import com.example.ngo_app.VolunteerAdapter
import com.example.ngo_app.VolunteerProgram
import com.example.ngo_app.databinding.FragmentVolunteerBinding

class Volunteer : Fragment() {
    private lateinit var binding: FragmentVolunteerBinding
    private lateinit var volunteerAdapter: VolunteerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentVolunteerBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val volunteerList = listOf(
            VolunteerProgram(
                "Karma Foundation Volunteering",
                "Karma Foundation",
                "We, at Karma Foundation,serve society at large, be it women, men, children, or families.We empower and nurture them with various initiatives under the roof for them to build a safer environment for the nations progressive future.\n" +
                        "\n" +
                        "We have influenced more than 10.1 lakhs, needy families, in remote areas also provided good quality grocery kits to more than 2,000 families across rural Gujarat with keeping nutrition in consideration and Providing scholarships to female students Giving career-related counseling to help them connect their talent with monetary rewards. We have been grateful that 105 girl students got impacted by this project, and our constant efforts to keep the fire of girl education alight are ongoing.\n" +
                        "\n" +
                        "We are Conducting awareness sessions and campaigns Providing counseling to patients suffering from depression and other mental health issues. We have spread positive mental health, which had impacted 46,064 people.\n",
                "https://www.karmafoundation.co/img/469x516.jpg"
            ),
            VolunteerProgram(
                "Gujarat sahay Foundation Volunteering ",
                "Gujarat sahay",
                "When it comes to giving back to the community, Ahmedabad has a number of NGOs and charitable trusts that are making a big impact. From helping the poor and underprivileged to providing education and support services, Gujarat Sahay is doing great work in Ahmedabad.\n" +
                        "\n" +
                        "Creating a platform for donors and recipients to meet and engage in charity work\n" +
                        "Promote authentic needs which deserve attention and your help\n" +
                        "Aim is to make people aware of the social responsibilities they have towards their fellow citizens\n" +
                        "If you’re looking for a way to make a difference, there’s probably an NGO or charitable trust in Ahmedabad that is a perfect fit for you. With a mission to empower the less fortunate, Gujarat Sahay is India’s first 100% charity website. We don’t get any benefit from activities that have been guided by our efforts.\n" +
                        "\n",
                "https://www.gujaratsahay.org/wp-content/uploads/2020/09/DSCN0261-scaled.jpg"
            ),
            VolunteerProgram(
                "VISAMO KIDS FOUNDATION Volunteering",
                "VISAMO KIDS FOUNDATION",
                "Visamo Kids Foundation (VKF) is working to make fundamental changes in the lives and thoughts of underprivileged children in Gujarat by providing them with free education, with the hope that they will, in turn, upgrade their families and society. It started with 18 children from poor families of earthquake-affected regions of Gujarat. VKF manages a home that provides lodging, boarding, and education support to 95 underprivileged children. Every year, 10 kids from deprived families gain admission into Visamo at the age of five years and stay at this home till they complete Grade 12. VKF provides medical aid, counselling sessions, academic supervision, guidance, and frequent parent-child interaction.",
            "https://visamokids.org/wp-content/uploads/2022/09/Visamo-Roof-300x200.jpg"
            ),
        )
        volunteerAdapter = VolunteerAdapter(requireContext(), volunteerList, this)
        binding.volunteerRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.volunteerRecyclerView.adapter = volunteerAdapter
    }

    fun onItemClick(position: Int) {
        // Handle item click, navigate to FullVolunteerActivity
        val intent = Intent(requireContext(), FullVolunteerActivity::class.java)
        val item = volunteerAdapter.volunteerList[position]
        intent.putExtra("PROGRAM_NAME", item.programName)
        intent.putExtra("NGO_NAME", item.ngoName)
        intent.putExtra("DETAILS", item.programDetails)
        intent.putExtra("IMAGE_URL", item.imageUrl)
        intent.putExtra("NGO_POSITION", position)
        startActivity(intent)
    }

}