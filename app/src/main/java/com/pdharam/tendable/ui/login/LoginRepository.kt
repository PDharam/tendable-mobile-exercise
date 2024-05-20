package com.pdharam.tendable.ui.login

import com.pdharam.tendable.network.ApiResult
import com.pdharam.tendable.network.InspectionApiService
import com.pdharam.tendable.network.ServiceBuilder
import com.pdharam.tendable.ui.login.model.LoginRequest
import com.pdharam.tendable.ui.login.model.LoginResponse

class LoginRepository {

    suspend fun login(request: LoginRequest): ApiResult<LoginResponse> {
        return try {
            ApiResult.Success(
                ServiceBuilder.buildService(InspectionApiService::class.java).login(request)
            )
        } catch (exception: Exception) {
            ApiResult.Error(exception)
        }
    }
}