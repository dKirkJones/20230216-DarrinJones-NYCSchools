package com.djmakes.nycschools.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.djmakes.nycschools.data.SchoolSAT
import com.djmakes.nycschools.repositoy.SchoolSATRepository
import com.djmakes.nycschools.utils.SimpleResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SchoolSATViewModel : ViewModel() {

    private val TAG = "SATViewMode"
    private val schoolSATRepo = SchoolSATRepository()

    private val _schoolSATLiveData: MutableLiveData<List<SchoolSAT.SchoolSATInfo?>> =
        MutableLiveData()
    val schoolSATLiveData: LiveData<List<SchoolSAT.SchoolSATInfo?>> = _schoolSATLiveData

    private val _exceptionLiveData: MutableLiveData<String> = MutableLiveData()
    val exceptionLiveData: LiveData<String> = _exceptionLiveData


    fun startRefreshSchoolId(schoolId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val responseForSat = schoolSATRepo.getSchoolById(schoolId)
            when (responseForSat.status) {
                SimpleResponse.Status.Success -> {
                    withContext(Dispatchers.Main) {
                        _schoolSATLiveData.value = responseForSat.body
                    }
                }
                SimpleResponse.Status.Failure -> {
                    withContext(Dispatchers.Main) {
                        _exceptionLiveData.value = responseForSat.exception?.message
                    }
                }
            }
        }
    }

}