package ir.arka.cleansample.data.login.repository

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ir.arka.cleansample.data.common.utils.WrappedResponse
import ir.arka.cleansample.data.login.remote.api.LoginApi
import ir.arka.cleansample.data.login.remote.dto.*
import ir.arka.cleansample.domain.common.base.BaseResult
import ir.arka.cleansample.domain.login.LoginRepository
import ir.arka.cleansample.domain.login.entity.LoginEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class LoginRepositoryImpl @Inject constructor(private val loginApi: LoginApi) : LoginRepository {
    override suspend fun loginSendMobile(loginRequest: LoginSendMobileRequest): Flow<BaseResult<LoginEntity, WrappedResponse<LoginResponse>>> {
        return flow {
            val response = loginApi.login(loginRequest)
            if (response.isSuccessful) {
                val body = response.body()!!
                val loginEntity = LoginEntity(
                    body.data?.code!!
                )
                emit(BaseResult.Success(loginEntity))
            } else {
                val type = object : TypeToken<WrappedResponse<LoginResponse>>() {}.type
                val err: WrappedResponse<LoginResponse> =
                    Gson().fromJson(response.errorBody()!!.charStream(), type)
                err.data?.code = response.code()
                emit(BaseResult.Error(err))
            }
        }
    }
}