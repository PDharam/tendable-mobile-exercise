package com.pdharam.tendable.network

import com.pdharam.tendable.ui.inspection.model.InspectionModel
import com.pdharam.tendable.ui.login.model.LoginRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface InspectionApiService {

    @POST("login")
    suspend fun login(@Body loginRequest: LoginRequest)

    @GET("inspections/start")
    suspend fun startInspection(): InspectionModel

    @POST("inspections/submit")
    suspend fun submitInspection(@Body inspection: InspectionModel)
}