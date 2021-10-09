package ir.arka.cleansample.data.login.remote.dto

import com.google.gson.annotations.SerializedName

data class LoginSendCodeRequest(
    @SerializedName("phone_number") val phoneNumber: String,
    @SerializedName("code") val code: String,
)