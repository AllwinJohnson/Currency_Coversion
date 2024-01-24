package com.allwin.currencycoversion.util.extension

import android.app.Activity
import android.widget.Toast
import androidx.fragment.app.Fragment

/*extension functions below*/
fun Fragment.showToast(message: String) {
    Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
}

fun Activity.showToast(message: String) {
    Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
}

fun Double?.formatRate(): String {
    return if (this != null) {
        String.format("%.2f", this)
    } else {
        ""
    }
}