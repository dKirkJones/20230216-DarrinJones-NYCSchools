package com.djmakes.nycschools.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.djmakes.nycschools.data.School

class SchoolDetailViewModel : ViewModel() {

    private val _schoolDetail: MutableLiveData<School.SchoolInfo> = MutableLiveData()
    val schoolDetail: LiveData<School.SchoolInfo> = _schoolDetail

    fun setSchoolDetails(school: School.SchoolInfo) {
        _schoolDetail.value = school
    }

}