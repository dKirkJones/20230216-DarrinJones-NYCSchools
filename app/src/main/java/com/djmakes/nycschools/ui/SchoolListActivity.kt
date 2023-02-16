package com.djmakes.nycschools.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.djmakes.nycschools.R
import com.djmakes.nycschools.adapter.SchoolListAdapter
import com.djmakes.nycschools.data.School
import com.djmakes.nycschools.databinding.ActivitySchoolListBinding
import com.djmakes.nycschools.viewModel.SchoolViewModel

class SchoolListActivity : AppCompatActivity(), SchoolListAdapter.OnItemClickListener {

    val TAG = "SchoolListActivity"

    private lateinit var binding: ActivitySchoolListBinding
    lateinit var schoolListAdapter: SchoolListAdapter
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var recyclerViewSchools: RecyclerView

    private val viewModel: SchoolViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySchoolListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.listProgress.isVisible = true
        recyclerViewSchools = findViewById(R.id.rv_school_list)
        linearLayoutManager = LinearLayoutManager(this)
        recyclerViewSchools.layoutManager = linearLayoutManager
        schoolListAdapter = SchoolListAdapter(emptyList(), this)
        recyclerViewSchools.adapter = schoolListAdapter

        viewModel.schoolsLiveData.observe(this) {
            binding.listProgress.isVisible = false
            schoolListAdapter.schoolList = it
            schoolListAdapter.notifyDataSetChanged()
        }

        viewModel.exceptionLiveData.observe(this) {
            binding.listProgress.isVisible = false
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
        viewModel.getSchools()
    }

    override fun onItemClick(schoolInfo: School.SchoolInfo) {

        val intent = Intent(this@SchoolListActivity, SchoolDetailsActivity::class.java)
        intent.putExtra("schoolDetails", schoolInfo)
        startActivity(intent)
    }

}