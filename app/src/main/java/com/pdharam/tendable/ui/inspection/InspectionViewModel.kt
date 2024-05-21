package com.pdharam.tendable.ui.inspection

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pdharam.tendable.ui.inspection.model.InspectionModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class InspectionViewModel : ViewModel() {
    private val inspectionRepository: InspectionRepository = InspectionRepository()

    fun getInspectionFromDB(inspectionId: Int): LiveData<InspectionModel> {
        val liveData: MutableLiveData<InspectionModel> = MutableLiveData()

        viewModelScope.launch(Dispatchers.IO) {
            val inspectionResponse = inspectionRepository.getInspectionFromDB(inspectionId)
            liveData.postValue(inspectionResponse)
        }
        return liveData
    }
}