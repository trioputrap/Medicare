package com.example.trio.medicare.util

import android.view.View
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun Date.toShortString(): String {
    val df = SimpleDateFormat("E, d MMM yyyy", Locale.getDefault())

    return df.format(this)
}

fun Any.toStringNull(): String {
    return if (this.toString() == "null") "" else this.toString()
}

fun String.toDateStringFormat(pattern: String = "E, dd MMM yyyy"): String {
    val df = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
    val df1 = SimpleDateFormat(pattern, Locale.getDefault())

    return df1.format(df.parse(this))
}