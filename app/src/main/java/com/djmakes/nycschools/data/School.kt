package com.djmakes.nycschools.data

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

class School : ArrayList<School.SchoolInfo>() {

    @Parcelize
    data class SchoolInfo(
        @Json(name = "attendance_rate")
        val attendance: String = "",
        val bbl: String = "",
        val bin: String = "",
        val boro: String = "",
        val borough: String = "",
        val bus: String = "",
        @Json(name = "census_tract")
        val census: String = "",
        val city: String = "",
        @Json(name = "community_board")
        val communityBoard: String = "",
        @Json(name = "council_district")
        val council: String = "",
        val dbn: String = "",
        val extracurricular_activities: String = "",
        @Json(name = "finalgrades")
        val finalGrades: String = "",
        val latitude: String = "",
        val location: String = "",
        val longitude: String = "",
        val neighborhood: String = "",
        @Json(name = "overview_paragraph")
        val overview: String = "",
        @Json(name = "phone_number")
        val phoneNumber: String = "",
        @Json(name = "primary_address_line_1")
        val address: String = "",
        @Json(name = "school_email")
        val schoolEmail: String = "",
        @Json(name = "school_name")
        val schoolName: String = "",
        @Json(name = "state_code")
        val stateCode: String = "",
        val subway: String = "",
        @Json(name = "total_students")
        val totalStudents: String = "",
        val website: String = "",
        val zip: String = "",
    ) : Parcelable
}