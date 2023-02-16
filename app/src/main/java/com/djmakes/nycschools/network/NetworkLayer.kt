package com.djmakes.nycschools.network

import com.djmakes.nycschools.utils.SimpleResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


object NetworkLayer {
    const val BASE_URL = "https://data.cityofnewyork.us/"

    val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
    val updateApiForSchool: SchoolApiService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
        .create(SchoolApiService::class.java)

    val updateApiForSchoolSAT : SchoolSATApiService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
        .create(SchoolSATApiService::class.java)
}

inline fun <T> safeApiCall(apiCall: () -> Response<T>): SimpleResponse<T> {
    return try {
        // If a network request is to fail this is where it would fail
        SimpleResponse.success(apiCall.invoke())
    } catch (e: Exception) {
        // This when we would call our SimpleResponse object
        SimpleResponse.failure(e)
    }
}