package com.djmakes.nycschools.ui

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.djmakes.nycschools.databinding.ActivitySatDetailsBinding
import com.djmakes.nycschools.viewModel.SchoolSATViewModel


class SATDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySatDetailsBinding
    val TAG = "SATDetails"

    val viewModel: SchoolSATViewModel by lazy {
        ViewModelProvider(this)[SchoolSATViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySatDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val schoolDbn = intent.getStringExtra("schoolDbn")
        binding.satProgress.isVisible = true

        viewModel.startRefreshSchoolId(schoolDbn.toString())
        viewModel.schoolSATLiveData.observe(this) { response ->
            binding.satProgress.isVisible = false
            if (response.isNotEmpty()) {
                binding.satTxSchoolName.text = response[0]?.schoolName
                binding.satTxTakerCount.text = response[0]?.testTakers
                binding.satTxMathScore.text = response[0]?.mathScore
                binding.satTxReadingScore.text = response[0]?.readingScore
                binding.satTxWritingScore.text = response[0]?.writingScore
            }
        }
        viewModel.exceptionLiveData.observe(this) {
            binding.satProgress.isVisible = false
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
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
