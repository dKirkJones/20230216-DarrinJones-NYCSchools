package com.djmakes.nycschools.network

import com.djmakes.nycschools.data.School
import retrofit2.Response
import retrofit2.http.GET

interface SchoolApiService {
    @GET("resource/s3k6-pzi2.json")
    suspend fun getSchoolFromAPI()
            : Response<List<School.SchoolInfo>>
}