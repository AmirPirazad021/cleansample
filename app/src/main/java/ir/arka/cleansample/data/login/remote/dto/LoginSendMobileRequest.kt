package ir.arka.cleansample.data.login.remote.dto

import com.google.gson.annotations.SerializedName

data class LoginSendMobileRequest(
    @SerializedName("phone_number") val phoneNumber: String,
)