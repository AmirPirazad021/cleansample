package ir.arka.cleansample.domain.login.entity

data class UserEntity(
    var user: UserData? = null,
)
data class UserData(
    var id: Int? = null,
    var first_name: String? = null,
    var last_name: String? = null,
    var email: String? = null,
    var email_verified_at: String? = null,
    var national_code: String? = null,
    var phone_number: String? = null,
    var avatar: String? = null,
    var active: Int? = null,
    var created_at: String? = null,
    var updated_at: String? = null,
)