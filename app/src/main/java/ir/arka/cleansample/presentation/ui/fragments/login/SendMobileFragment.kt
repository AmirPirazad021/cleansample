package ir.arka.cleansample.presentation.ui.fragments.login

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import ir.arka.cleansample.databinding.FragmentSendMobileBinding
import ir.arka.cleansample.R
import ir.arka.cleansample.data.common.utils.WrappedResponse
import ir.arka.cleansample.data.login.remote.dto.LoginSendMobileRequest
import ir.arka.cleansample.data.login.remote.dto.LoginResponse
import ir.arka.cleansample.domain.login.entity.LoginEntity
import ir.arka.cleansample.presentation.common.base.BaseFragment
import ir.arka.cleansample.presentation.common.extension.loading
import ir.arka.cleansample.presentation.common.extension.showToast
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

private const val TAG = "LoginFragment"

@AndroidEntryPoint
class SendMobileFragment : BaseFragment<FragmentSendMobileBinding>() {
    override val layoutResource: Int
        get() = R.layout.fragment_send_mobile

    private val viewModel: LoginViewModel by viewModels()

    override fun setUpViewBinding() {

        observe()
        sendMobileNumber()
    }

    private fun sendMobileNumber() {
        viewDataBinding.apply {
            tvSubmit.setOnClickListener {
                val loginReq = LoginSendMobileRequest(etMobileNum.text.toString())
                viewModel.login(loginReq)
                sharedPrefs.saveMobile(etMobileNum.text.toString())
            }
        }
    }

    private fun observe() {
        viewModel.mState.flowWithLifecycle(
            lifecycle, Lifecycle.State.STARTED
        ).onEach { state -> handleStateChange(state) }.launchIn(lifecycleScope)
    }

    private fun handleStateChange(state: LoginActivityState) {
        when (state) {
            is LoginActivityState.ErrorLogin -> handleErrorLogin(state.rawResponse)
            is LoginActivityState.SuccessLogin -> handleSuccessLogin(state.loginEntity)
            is LoginActivityState.ShowToast -> requireActivity().showToast(state.message)
            is LoginActivityState.IsLoading -> handleLoading(state.isLoading)
        }
    }

    private fun handleLoading(loading: Boolean) {
        viewDataBinding.vsSendCode.loading(requireActivity(), loading)
    }

    private fun handleSuccessLogin(loginEntity: LoginEntity) {
        Log.e(TAG, "handleSuccessLogin: ${loginEntity.code}")
        val nav = SendMobileFragmentDirections.actionLoginFragmentToSendCodeFragment()
        findNavController().navigate(nav)
        sharedPrefs.saveMobile(viewDataBinding.etMobileNum.text.toString())
    }

    private fun handleErrorLogin(rawResponse: WrappedResponse<LoginResponse>) {

        Log.e(TAG, "message: ${rawResponse.data?.messages?.get(0)}")
    }

}