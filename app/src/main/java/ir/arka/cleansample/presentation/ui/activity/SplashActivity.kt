package ir.arka.cleansample.presentation.ui.activity

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import ir.arka.cleansample.databinding.ActivitySplashBinding
import ir.arka.cleansample.R
import ir.arka.cleansample.presentation.common.base.BaseActivity
import ir.arka.cleansample.presentation.common.extension.startActivity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class SplashActivity : BaseActivity<ActivitySplashBinding>() {

    override val layoutResource: Int
        get() = R.layout.activity_splash

    override fun setUpViewBinding(savedInstanceState: Bundle?) {
        statusBar(R.color.bg_splash)
        lifecycleScope.launch {
            delay(4000)
            if (sharedPrefs.getToken().isNullOrEmpty())
                startActivity<SignupActivity>(true)
            else
                startActivity<MainActivity>(true)

        }
    }

}