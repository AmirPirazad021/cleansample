package ir.arka.cleansample.presentation.common.base

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import ir.arka.cleansample.presentation.ui.fragments.login.SendMobileFragment
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@ExperimentalCoroutinesApi
class MainFragmentFactory
@Inject
constructor() : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (className) {

            SendMobileFragment::class.java.name -> {
                SendMobileFragment()
            }

            else -> super.instantiate(classLoader, className)
        }
    }

}