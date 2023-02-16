package com.djmakes.nycschools.ui

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.djmakes.nycschools.R
import com.djmakes.nycschools.data.School
import com.djmakes.nycschools.databinding.ActivitySchoolDetailsBinding
import com.djmakes.nycschools.viewModel.SchoolDetailViewModel

class SchoolDetailsActivity : AppCompatActivity() {
    val TAG = "SchoolDetailActivity"
    private lateinit var binding: ActivitySchoolDetailsBinding
    private val viewModel: SchoolDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySchoolDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val schoolDetails = intent.getParcelableExtra("schoolDetails") as? School.SchoolInfo
        if (schoolDetails != null) {
            viewModel.setSchoolDetails(schoolDetails)
        }
        viewModel.schoolDetail.observe(this) {
            schoolDetails
        }
        binding.detailSchoolName.text = schoolDetails?.schoolName
        binding.detailSchoolAddress.text = schoolDetails?.address
        binding.detailSchoolCity.text = schoolDetails?.city
        binding.detailSchoolPhone.text = schoolDetails?.phoneNumber
        binding.detailSchoolOverview.text = schoolDetails?.overview

        var schoolDbn = schoolDetails?.dbn

        val btn_SAT = findViewById<Button>(R.id.sat_button)

        btn_SAT.setOnClickListener {
            val intent = Intent(this, SATDetailsActivity::class.java)
            intent.putExtra("schoolDbn", schoolDbn)
            startActivity(intent)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}