package com.pdharam.tendable.network

import com.pdharam.tendable.ui.login.model.LoginRequest
import com.pdharam.tendable.ui.login.model.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface InspectionApiService {

    @POST("login")
    suspend fun login(@Body loginRequest: LoginRequest): LoginResponse
}