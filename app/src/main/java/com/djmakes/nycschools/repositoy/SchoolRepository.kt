package com.djmakes.nycschools.repositoy

import com.djmakes.nycschools.data.School
import com.djmakes.nycschools.network.NetworkLayer
import com.djmakes.nycschools.network.safeApiCall
import com.djmakes.nycschools.utils.SimpleResponse

class SchoolRepository {

    suspend fun getSchoolFromApi(): SimpleResponse<List<School.SchoolInfo>> {
        return safeApiCall { NetworkLayer.updateApiForSchool.getSchoolFromAPI() }
    }
}