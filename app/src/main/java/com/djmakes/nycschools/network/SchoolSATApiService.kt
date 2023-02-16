package com.djmakes.nycschools.network

import com.djmakes.nycschools.data.SchoolSAT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SchoolSATApiService {
    @GET("resource/f9bf-2cp4.json")
    suspend fun getSchoolSATbyID(
        @Query("dbn") dbn: String
    ): Response<List<SchoolSAT.SchoolSATInfo>>
}