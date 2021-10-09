package ir.arka.cleansample.presentation.common.base

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import ir.arka.cleansample.R
import ir.arka.cleansample.infra.utils.SharedPrefs
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@ExperimentalCoroutinesApi
abstract class BaseActivity<B : ViewDataBinding> : AppCompatActivity() {

    abstract val layoutResource: Int
    lateinit var viewDataBinding: B

    @Inject
    lateinit var sharedPrefs: SharedPrefs

    abstract fun setUpViewBinding(savedInstanceState: Bundle?)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        statusBar(R.color.purple_700)

        viewDataBinding = DataBindingUtil.setContentView(this, layoutResource)
        setUpViewBinding(savedInstanceState)
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase!!))
    }

    fun statusBar(color: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.navigationBarColor = ContextCompat.getColor(this, color)
            window.addFlags(FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = ContextCompat.getColor(this, color)
        }
    }

    override fun onResume() {
        super.onResume()
    }

}
