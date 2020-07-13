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

}