package com.djmakes.nycschools.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.djmakes.nycschools.R

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_start = findViewById<Button>(R.id.btn_start)

        btn_start.setOnClickListener {
            startActivity(Intent(this, SchoolListActivity::class.java)) }
    }
}