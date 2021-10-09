package ir.arka.cleansample.presentation.common.extension

import android.content.Context
import android.view.View
import android.widget.ViewSwitcher
import ir.arka.cleansample.R

fun View.gone() {
    visibility = View.GONE
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}


/**
 * 0 => loaded
 * 1 => loading
 *
 * */
fun ViewSwitcher.loading(
    context: Context,
    isLoading: Boolean = false,
    isNoInternet: Boolean = false
) {
    this.displayedChild = if (isLoading) {
        1
    } else {
        0
    }
    if (isNoInternet)
        context.showToast(resources.getString(R.string.no_connection))
}
