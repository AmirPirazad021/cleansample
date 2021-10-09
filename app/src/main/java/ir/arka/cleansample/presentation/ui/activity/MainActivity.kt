package ir.arka.cleansample.presentation.ui.activity

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import ir.arka.cleansample.databinding.ActivityMainBinding
import ir.arka.cleansample.R
import ir.arka.cleansample.infra.utils.setupWithNavController
import ir.arka.cleansample.presentation.common.base.BaseActivity
import kotlinx.coroutines.ExperimentalCoroutinesApi

private const val TAG = "MainActivity"

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    private var currentNavController: LiveData<NavController>? = null
    override val layoutResource: Int
        get() = R.layout.activity_main

    companion object {
        lateinit var bottomNavigationView: BottomNavigationView
    }

    // onCreate
    override fun setUpViewBinding(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            setupBottomNavigationBar()

        } // Else, need to wait for onRestoreInstanceState
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBottomNavigationBar()
    }

    /**
     * Called on first creation and when restoring state.
     */
    private fun setupBottomNavigationBar() {

        val navGraphIds = listOf(
            R.navigation.navigation_my_home,
            R.navigation.navigation_advertisement,
            R.navigation.navigation_entertainment,
            R.navigation.navigation_services,
            R.navigation.navigation_profile
        )

        val appBarConfiguration = AppBarConfiguration.Builder(R.menu.bottom_nav).build()

        // Setup the bottom navigation view with a list of navigation graphs
        val controller = viewDataBinding.bottomNav.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.nav_host_container,
            intent = intent
        )

        // Whenever the selected controller changes, setup the action bar.
        controller.observe(this) { navController ->
            setupActionBarWithNavController(navController, appBarConfiguration)
        }
        bottomNavigationView = viewDataBinding.bottomNav
        currentNavController = controller
        bottomNavigationView.selectedItemId = R.id.navigation_my_home

    }

    override fun onSupportNavigateUp(): Boolean {
        return currentNavController?.value?.navigateUp() ?: false
    }
}
