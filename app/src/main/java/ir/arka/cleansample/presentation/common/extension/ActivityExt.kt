package ir.arka.cleansample.presentation.common.extension

import android.app.Activity
import android.content.Intent


inline fun <reified T : Activity> Activity.startActivity(
    isFinish: Boolean = false,
    block: Intent .() -> Unit = {}
) {
    startActivity(Intent(this, T::class.java).apply(block))
    if (isFinish)
        finish()
}
