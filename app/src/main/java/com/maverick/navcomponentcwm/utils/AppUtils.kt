package com.maverick.navcomponentcwm.utils

import android.content.Context
import android.widget.Toast

fun Context.showToast(context: Context, message: String, length: Int) {
    Toast.makeText(context, message, length).show()
}