package ir.arka.cleansample.presentation

import android.content.Context
import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp
import io.github.inflationx.calligraphy3.CalligraphyConfig
import io.github.inflationx.calligraphy3.CalligraphyInterceptor
import io.github.inflationx.viewpump.ViewPump
import ir.arka.cleansample.R

@HiltAndroidApp
class MyApplication : MultiDexApplication() {

    companion object {
        @Volatile
        lateinit var appContext: Context
    }

    override fun onCreate() {
        try {
            appContext = applicationContext
        } catch (ignore: Throwable) {
            ignore.printStackTrace()
        }
        super.onCreate()
        initCalligraphy()
    }

    private fun initCalligraphy() {

        ViewPump.init(
            ViewPump.builder()
                .addInterceptor(
                    CalligraphyInterceptor(
                        CalligraphyConfig.Builder()
                            .setDefaultFontPath("fonts/isn.ttf")
                            .setFontAttrId(R.attr.fontPath)
                            .build()
                    )
                )
                .build()
        )
    }

}