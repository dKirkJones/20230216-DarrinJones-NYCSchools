package com.djmakes.nycschools.network

import com.djmakes.nycschools.data.SchoolSAT
import com.djmakes.nycschools.utils.SimpleResponse
import retrofit2.Response

class ApiClient(
    private val schoolSATApiService: SchoolSATApiService
) {
    suspend fun getSchoolById(schoolId: String): SimpleResponse<List<SchoolSAT.SchoolSATInfo>> {
        return   safeApiCall { schoolSATApiService.getSchoolSATbyID(schoolId)  }
    }
  private inline fun <T> safeApiCall(apiCall: () -> Response<T>): SimpleResponse<T> {
      return try {
          // If a network request is to fail this is where it would fail
          SimpleResponse.success(apiCall.invoke())
      } catch (e: Exception) {
          // This when we would call our SimpleResponse object
          SimpleResponse.failure(e)
      }
  }
}