package ir.arka.cleansample.data.login.remote.api

import ir.arka.cleansample.data.common.utils.WrappedResponse
import ir.arka.cleansample.data.login.remote.dto.*
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApi {
    @POST("auth")
    suspend fun login(@Body loginRequest: LoginSendMobileRequest): Response<WrappedResponse<LoginResponse>>
}