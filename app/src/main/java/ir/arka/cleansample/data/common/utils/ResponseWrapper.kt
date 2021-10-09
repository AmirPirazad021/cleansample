package ir.arka.cleansample.data.common.utils

import com.google.gson.annotations.SerializedName

data class WrappedListResponse<T> (
    @SerializedName("data") var data : List<T>? = null
)


data class WrappedResponse<T> (
    @SerializedName("data") var data : T? = null
)