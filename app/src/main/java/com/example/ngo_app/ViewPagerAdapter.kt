package com.example.ngo_app

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.ngo_app.fragment.EventLists
import com.example.ngo_app.fragment.Volunteer

class ViewPagerAdapter(fm:FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 2;
    }

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> {
                EventLists()
            }

            1 -> {
                Volunteer()
            }

            else -> {
                EventLists()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position) {
            0 -> {
                return "Events"
            }
            1 -> {
                return "Volunteers Programs"
            }

        }
        return super.getPageTitle(position)
    }

}
