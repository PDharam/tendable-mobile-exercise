package com.pdharam.tendable.ui.saved_inspection_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pdharam.tendable.ui.inspection.model.InspectionModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SavedInspectionListViewModel : ViewModel() {
    private val savedInspectionListRepository: SavedInspectionListRepository =
        SavedInspectionListRepository()

    fun getAllInspectionDB(inspectionId: Int): LiveData<List<InspectionModel>> {
        val liveData: MutableLiveData<List<InspectionModel>> = MutableLiveData()

        viewModelScope.launch(Dispatchers.IO) {
            val inspectionResponse = savedInspectionListRepository.getAllInspectionDB()
            liveData.postValue(inspectionResponse)
        }
        return liveData
    }
}