package com.pdharam.tendable.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pdharam.tendable.network.ApiResult
import com.pdharam.tendable.ui.inspection.model.InspectionModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DashboardViewModel : ViewModel() {
    private val inspectionRepository: DashboardRepository = DashboardRepository()

    fun startInspection(): LiveData<ApiResult<InspectionModel>> {
        val liveData: MutableLiveData<ApiResult<InspectionModel>> = MutableLiveData()

        viewModelScope.launch(Dispatchers.IO) {

            val inspectionResponse = inspectionRepository.startInspection()

            if (inspectionResponse is ApiResult.Success)
                inspectionRepository.saveInspection(inspectionResponse.data)

            liveData.postValue(inspectionResponse)
        }
        return liveData
    }
}