package com.pdharam.tendable.ui.inspection

import com.google.gson.Gson
import com.pdharam.tendable.db.entity.InspectionEntity
import com.pdharam.tendable.db.entity.InspectionStatus
import com.pdharam.tendable.network.ApiResult
import com.pdharam.tendable.network.InspectionApiService
import com.pdharam.tendable.network.ServiceBuilder
import com.pdharam.tendable.root.TendableApplication
import com.pdharam.tendable.ui.inspection.model.InspectionModel
import com.pdharam.tendable.util.SharedPreferenceUtil

class InspectionRepository() {
    var sharedPreferenceUtil: SharedPreferenceUtil

    init {
        sharedPreferenceUtil = SharedPreferenceUtil()
    }

    suspend fun startInspection(): ApiResult<InspectionModel> {
        return try {
            ApiResult.Success(
                ServiceBuilder.buildService(InspectionApiService::class.java).startInspection()
            )
        } catch (exception: Exception) {
            ApiResult.Error(exception)
        }
    }

    suspend fun saveInspection(inspectionModel: InspectionModel) {

        val inspectionId = inspectionModel.inspection.id
        val inspectionJson = Gson().toJson(inspectionModel)

        val inspectionEntity =
            InspectionEntity(inspectionId, inspectionJson, InspectionStatus.DRAFT)

        TendableApplication.tendableDatabase.inspectionDao().insert(inspectionEntity)
    }

    fun getInspectionFromDB(inspectionId: Int): InspectionModel {
        val inspectionEntity =
            TendableApplication.tendableDatabase.inspectionDao().getInspectionById(inspectionId)
        return Gson().fromJson(inspectionEntity.inspectionJson, InspectionModel::class.java)
    }
}