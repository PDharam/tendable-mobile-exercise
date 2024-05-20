package com.pdharam.tendable.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pdharam.tendable.network.ApiResult
import com.pdharam.tendable.ui.login.model.LoginRequest
import com.pdharam.tendable.ui.login.model.LoginResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private val loginRepository: LoginRepository = LoginRepository()

    fun login(email: String, password: String): LiveData<ApiResult<LoginResponse>> {
        val liveData: MutableLiveData<ApiResult<LoginResponse>> = MutableLiveData()

        viewModelScope.launch(Dispatchers.IO) {
            val loginResponse = loginRepository.login(LoginRequest(email, password))
            liveData.postValue(loginResponse)
        }
        return liveData;
    }
}