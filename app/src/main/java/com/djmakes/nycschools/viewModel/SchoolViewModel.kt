package com.djmakes.nycschools.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.djmakes.nycschools.data.School
import com.djmakes.nycschools.repositoy.SchoolRepository
import com.djmakes.nycschools.utils.SimpleResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SchoolViewModel : ViewModel() {

    private val TAG = "ViewModel"
    private val repo = SchoolRepository()

    private val _schoolsLiveData: MutableLiveData<List<School.SchoolInfo>> = MutableLiveData()
    val schoolsLiveData: LiveData<List<School.SchoolInfo>> = _schoolsLiveData

    private val _exceptionLiveData: MutableLiveData<String> = MutableLiveData()
    val exceptionLiveData: LiveData<String> = _exceptionLiveData

    fun getSchools() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repo.getSchoolFromApi()
            when (response.status){
                SimpleResponse.Status.Success -> {
                    withContext(Dispatchers.Main) {
                        _schoolsLiveData.value = response.body
                    }
                }
                SimpleResponse.Status.Failure -> {
                    withContext(Dispatchers.Main) {
                        _exceptionLiveData.value = response.exception?.message
                    }
                }
            }
        }
    }



}