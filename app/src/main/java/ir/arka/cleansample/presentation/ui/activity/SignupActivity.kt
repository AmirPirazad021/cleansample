package ir.arka.cleansample.presentation.ui.activity

import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import ir.arka.cleansample.databinding.ActivitySignupBinding
import ir.arka.cleansample.R
import ir.arka.cleansample.presentation.common.base.BaseActivity
import kotlinx.coroutines.ExperimentalCoroutinesApi


@ExperimentalCoroutinesApi
@AndroidEntryPoint
class SignupActivity : BaseActivity<ActivitySignupBinding>() {

    override val layoutResource: Int
        get() = R.layout.activity_signup

    override fun setUpViewBinding(savedInstanceState: Bundle?) {

    }

}