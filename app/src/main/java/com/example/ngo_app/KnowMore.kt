package com.example.ngo_app

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContentProviderCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.ngo_app.databinding.ActivityKnowMoreBinding
import com.example.ngo_app.fragment.Appointment
import com.example.ngo_app.fragment.Donate
import com.example.ngo_app.fragment.EventLists
import com.example.ngo_app.fragment.OurWork

class KnowMore : AppCompatActivity() {

    companion object {
        const val EXTRA_NGO_NAME = "com.example.ngo_app.EXTRA_NGO_NAME"
        const val EXTRA_NGO_DESCRIPTION = "com.example.ngo_app.EXTRA_NGO_DESCRIPTION"
        const val EXTRA_NGO_LOCATION = "com.example.ngo_app.EXTRA_NGO_LOCATION"
        const val EXTRA_NGO_POSITION = "com.example.ngo_app.EXTRA_NGO_POSITION"
    }

    private val binding: ActivityKnowMoreBinding by lazy {
        ActivityKnowMoreBinding.inflate(layoutInflater)
    }
    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)



        val ngoName = intent.getStringExtra(EXTRA_NGO_NAME)
        val ngoDescription = intent.getStringExtra(EXTRA_NGO_DESCRIPTION)
        val ngoLocation = intent.getStringExtra(EXTRA_NGO_LOCATION)
        val ngoPosition = intent.getIntExtra(EXTRA_NGO_POSITION, 0)
        binding.ngoName.text = ngoName



        val imageList = ArrayList<SlideModel>()

        when (ngoPosition) {
            0 -> {
                imageList.add(SlideModel(R.drawable.ngo_1_1))
                imageList.add(SlideModel(R.drawable.ngo_1_2))
                imageList.add(SlideModel(R.drawable.ngo_1_3))
                imageList.add(SlideModel(R.drawable.ngo_1_4))
                imageList.add(SlideModel(R.drawable.ngo_1_5))
            }
            1 -> {
                imageList.add(SlideModel(R.drawable.ngo_2_1))
                imageList.add(SlideModel(R.drawable.ngo_2_2))
                imageList.add(SlideModel(R.drawable.ngo_2_3))
                imageList.add(SlideModel(R.drawable.ngo_2_4))
                imageList.add(SlideModel(R.drawable.ngo_2_5))
                imageList.add(SlideModel(R.drawable.ngo_2_6))
            }
            2 -> {
                imageList.add(SlideModel(R.drawable.ngo_3_1))
                imageList.add(SlideModel(R.drawable.ngo_3_2))
                imageList.add(SlideModel(R.drawable.ngo_3_3))
                imageList.add(SlideModel(R.drawable.ngo_3_4))
                imageList.add(SlideModel(R.drawable.ngo_3_5))
                imageList.add(SlideModel(R.drawable.ngo_3_5))
                imageList.add(SlideModel(R.drawable.ngo_3_5))
            }
        }

        val imageSlider = binding.imageSlider
        imageSlider.setImageList(imageList)
        imageSlider.setImageList(imageList,scaleType = ScaleTypes.FIT)

        binding.backToHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        binding.Userprofile.setOnClickListener {
            val intent = Intent(this, UserProfile::class.java)
            startActivity(intent)
        }

        binding.ourWork.setOnClickListener {
            replaceFragment(OurWork())
            binding.ourWork.background = getDrawable(R.drawable.ngocardbtn)
            binding.appointment.background = getDrawable(R.drawable.nonselecteditem)
            binding.events.background = getDrawable(R.drawable.nonselecteditem)
            binding.donate.background = getDrawable(R.drawable.nonselecteditem)
            binding.ourWork.setTextColor(getColor(R.color.white))
            binding.donate.setTextColor(getColor(R.color.black))
            binding.appointment.setTextColor(getColor(R.color.black))
            binding.events.setTextColor(getColor(R.color.black))
        }
        binding.donate.setOnClickListener {
            replaceFragment(Donate())
            binding.ourWork.background = getDrawable(R.drawable.nonselecteditem)
            binding.appointment.background = getDrawable(R.drawable.nonselecteditem)
            binding.events.background = getDrawable(R.drawable.nonselecteditem)
            binding.donate.background = getDrawable(R.drawable.ngocardbtn)
            binding.ourWork.setTextColor(getColor(R.color.black))
            binding.donate.setTextColor(getColor(R.color.white))
            binding.appointment.setTextColor(getColor(R.color.black))
            binding.events.setTextColor(getColor(R.color.black))
        }
        binding.appointment.setOnClickListener {
            replaceFragment(Appointment())
            binding.ourWork.background = getDrawable(R.drawable.nonselecteditem)
            binding.appointment.background = getDrawable(R.drawable.ngocardbtn)
            binding.events.background = getDrawable(R.drawable.nonselecteditem)
            binding.donate.background = getDrawable(R.drawable.nonselecteditem)
            binding.ourWork.setTextColor(getColor(R.color.black))
            binding.donate.setTextColor(getColor(R.color.black))
            binding.appointment.setTextColor(getColor(R.color.white))
            binding.events.setTextColor(getColor(R.color.black))
        }
        binding.events.setOnClickListener {
            replaceFragment(EventLists())
            binding.ourWork.background = getDrawable(R.drawable.nonselecteditem)
            binding.appointment.background = getDrawable(R.drawable.nonselecteditem)
            binding.events.background = getDrawable(R.drawable.ngocardbtn)
            binding.donate.background = getDrawable(R.drawable.nonselecteditem)
            binding.ourWork.setTextColor(getColor(R.color.black))
            binding.donate.setTextColor(getColor(R.color.black))
            binding.appointment.setTextColor(getColor(R.color.black))
            binding.events.setTextColor(getColor(R.color.white))
        }
    }
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .addToBackStack(null)
            .commit()
    }
}