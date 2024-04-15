package com.example.ngo_app.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ngo_app.BlogAdapter
import com.example.ngo_app.BlogItem
import com.example.ngo_app.FullBlogActivity
import com.example.ngo_app.R
class BlogFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_blog, container, false)

        // Inflate the layout for this fragment

//        val blogAdapter = BlogAdapter(blogList)
//        val recyclerView = view.findViewById<RecyclerView>(R.id.blogRecyclerView)
//        recyclerView.adapter = blogAdapter
//        recyclerView.layoutManager = LinearLayoutManager(context)

        val recyclerView: RecyclerView = view.findViewById(R.id.blogRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val blogItems = getBlogItems()
        val blogAdapter = BlogAdapter(requireContext(), blogItems)
        recyclerView.adapter = blogAdapter

        return view
    }

    private fun getBlogItems(): List<BlogItem> {
        return  listOf<BlogItem>(

            BlogItem(
                2,
                "Powering Up For Better Irrigation: The Green Revolution in Pinjrat Village",
                getString(R.string.blog2),
                "Admin",
                "https://www.careindia.org/wp-content/uploads/2023/08/unnamed-3-389x231.jpg"
            ),
            BlogItem(
                3,
                "What role do the contemporary NGOs play in child education?",
                getString(R.string.blog3),
                "Admin",
                "https://www.shakshamfoundation.org/wp-content/uploads/2024/03/eductaion.webp"
            ),
            BlogItem(
                4,
                "Dignity kits enrolment & keep girls in school",
                getString(R.string.blog4),
                "Admin",
                "https://khushii.org/wp-content/uploads/2021/09/dignity-banner.jpg"
            ),
            BlogItem(
                5,
                "How Women-Led NGOs Are Pioneering Empathy-Driven Change in Society?",
                getString(R.string.blog5),
                "Admin",
                "https://www.indiaisus.com/images/uploadedimages/thumbs/0000436_i2u%20og%20women%20empowerment.png"
            )
        )

    }
}