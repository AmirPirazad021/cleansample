package ir.arka.cleansample.data.login.remote.dto

import com.google.gson.annotations.SerializedName

data class UpdateUserResponse(
    @SerializedName("code") var code: Int? = null,
    @SerializedName("messages") var messages : List<String>? = null,
    @SerializedName("result") var result : UpdateUserResultResponse? = null,
    @SerializedName("status") var status: String? = null
)
data class UpdateUserResultResponse(
    @SerializedName("user") var user: UserData? = null,
)
data class UserData(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("first_name") var first_name: String? = null,
    @SerializedName("last_name") var last_name: String? = null,
    @SerializedName("email") var email: String? = null,
    @SerializedName("email_verified_at") var email_verified_at: String? = null,
    @SerializedName("national_code") var national_code: String? = null,
    @SerializedName("phone_number") var phone_number: String? = null,
    @SerializedName("avatar") var avatar: String? = null,
    @SerializedName("active") var active: Int? = null,
    @SerializedName("created_at") var created_at: String? = null,
    @SerializedName("updated_at") var updated_at: String? = null,
)