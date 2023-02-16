package com.djmakes.nycschools.repositoy

import com.djmakes.nycschools.data.SchoolSAT
import com.djmakes.nycschools.network.NetworkLayer
import com.djmakes.nycschools.network.safeApiCall
import com.djmakes.nycschools.utils.SimpleResponse

class SchoolSATRepository {

    suspend fun getSchoolById(schoolId: String): SimpleResponse<List<SchoolSAT.SchoolSATInfo>> {
        return safeApiCall { NetworkLayer.updateApiForSchoolSAT.getSchoolSATbyID(schoolId) }
    }
}