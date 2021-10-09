package ir.arka.cleansample.presentation.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import ir.arka.cleansample.infra.utils.SharedPrefs
import javax.inject.Inject

abstract class BaseFragment<B : ViewDataBinding> : Fragment() {

    abstract val layoutResource: Int
    lateinit var viewDataBinding: B

    abstract fun setUpViewBinding()

    @Inject
    lateinit var sharedPrefs: SharedPrefs

    var backPressedCallback: ((String) -> Unit)? = null
    fun onBackPressed(listener: (String) -> Unit) {
        backPressedCallback = listener
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = DataBindingUtil.inflate(inflater, layoutResource, container, false)
        setUpViewBinding()
        return viewDataBinding.root
    }

    fun callback(listener: (Boolean) -> Unit) {

        val callBack = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                listener.invoke(true)
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(callBack)
    }
}