package ir.arka.cleansample.data.login.remote.dto

import com.google.gson.annotations.SerializedName

data class UpdateUserRequest(
    @SerializedName("first_name") val firstName: String,
    @SerializedName("last_name") val lastName: String,
    @SerializedName("national_code") val nationalCode: String,
    @SerializedName("avatar") val avatar: String
)