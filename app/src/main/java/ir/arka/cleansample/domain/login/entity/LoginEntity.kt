package ir.arka.cleansample.domain.login.entity

data class LoginEntity(
    var code: Int? = null,
    var isNew: Boolean? = null,
    var token: String? = null
)