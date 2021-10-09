package ir.arka.cleansample.data.login.remote.dto

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("code") var code: Int? = null,
    @SerializedName("messages") var messages : List<String>? = null,
    @SerializedName("result") var result : LoginResultResponse? = null,
    @SerializedName("status") var status: String? = null
)

data class LoginResultResponse(
    @SerializedName("code") var code: Int? = null,
    @SerializedName("token") var token: String? = null,
    @SerializedName("isNew") var isNew: String? = null,
)