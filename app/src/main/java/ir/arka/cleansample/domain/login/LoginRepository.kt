package ir.arka.cleansample.domain.login

import ir.arka.cleansample.data.common.utils.WrappedResponse
import ir.arka.cleansample.data.login.remote.dto.*
import ir.arka.cleansample.domain.common.base.BaseResult
import ir.arka.cleansample.domain.login.entity.LoginEntity
import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    suspend fun loginSendMobile(loginRequest: LoginSendMobileRequest): Flow<BaseResult<LoginEntity, WrappedResponse<LoginResponse>>>
}