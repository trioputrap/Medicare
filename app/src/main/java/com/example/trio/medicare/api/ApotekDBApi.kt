package com.example.trio.medicare.api

import android.net.Uri
import com.example.trio.medicare.util.Constant

object ApotekDBApi {

    fun getApotek(): String {
        return Uri.parse(Constant.BASE_URL).buildUpon()
            .appendPath("apotek")
            .build()
            .toString()
    }

    fun getResep(user_id: Int): String {
        return Uri.parse(Constant.BASE_URL).buildUpon()
            .appendPath("recipes-user")
            .appendPath("$user_id")
            .build()
            .toString()
    }

    fun getRiwayat(user_id: Int): String {
        return Uri.parse(Constant.BASE_URL).buildUpon()
            .appendPath("riwayat-user")
            .appendPath("$user_id")
            .build()
            .toString()
    }
}