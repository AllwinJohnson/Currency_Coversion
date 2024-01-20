package com.allwin.currencycoversion.util.extension

import android.app.Activity
import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.showToast(message: String) {
    Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
}

fun Activity.showToast(message: String) {
    Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
}