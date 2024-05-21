package com.pdharam.tendable.ui.saved_inspection_list

import com.google.gson.Gson
import com.pdharam.tendable.db.entity.InspectionEntity
import com.pdharam.tendable.db.entity.InspectionStatus
import com.pdharam.tendable.root.TendableApplication
import com.pdharam.tendable.ui.inspection.model.InspectionModel

class SavedInspectionListRepository() {


    suspend fun saveInspection(inspectionModel: InspectionModel) {

        val inspectionId = inspectionModel.inspection.id
        val inspectionJson = Gson().toJson(inspectionModel)

        val inspectionEntity =
            InspectionEntity(inspectionId, inspectionJson, InspectionStatus.DRAFT)

        TendableApplication.tendableDatabase.inspectionDao().insert(inspectionEntity)
    }

    fun getAllInspectionDB(): List<InspectionModel> {
        val inspectionEntity: List<InspectionEntity> =
            TendableApplication.tendableDatabase.inspectionDao().getAll()
        val insectionModelList =
            inspectionEntity.map { Gson().fromJson(it.inspectionJson, InspectionModel::class.java) }
                .toList()

        return insectionModelList
    }
}