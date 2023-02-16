package com.djmakes.nycschools.data

import com.squareup.moshi.Json


class SchoolSAT : ArrayList<SchoolSAT.SchoolSATInfo>() {
    data class SchoolSATInfo(
        val dbn: String,
        @Json(name = "num_of_sat_test_takers")
        val testTakers: String,
        @Json(name = "sat_critical_reading_avg_score")
        val readingScore: String,
        @Json(name = "sat_math_avg_score")
        val mathScore: String,
        @Json(name = "sat_writing_avg_score")
        val writingScore: String,
        @Json(name = "school_name")
        val schoolName: String,
    )
}