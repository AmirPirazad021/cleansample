package ir.arka.cleansample.domain.login.usecase

import ir.arka.cleansample.data.common.utils.WrappedResponse
import ir.arka.cleansample.data.login.remote.dto.*
import ir.arka.cleansample.domain.common.base.BaseResult
import ir.arka.cleansample.domain.login.LoginRepository
import ir.arka.cleansample.domain.login.entity.LoginEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val loginRepository: LoginRepository) {
    suspend fun executeSendMobile(loginRequest: LoginSendMobileRequest): Flow<BaseResult<LoginEntity, WrappedResponse<LoginResponse>>> {
        return loginRepository.loginSendMobile(loginRequest)
    }
}