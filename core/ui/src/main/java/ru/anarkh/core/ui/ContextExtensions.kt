package ru.anarkh.core.ui

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes
import kotlin.math.roundToInt

fun Context.dpToPx(dp: Int): Int = dpToPx(dp.toFloat()).roundToInt()

fun Context.dpToPx(dp: Float): Float = dp * resources.displayMetrics.density

fun Context.showToast(@StringRes messageRes: Int) = showToast(getString(messageRes))

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}