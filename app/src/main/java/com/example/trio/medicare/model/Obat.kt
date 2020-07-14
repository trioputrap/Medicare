package com.example.trio.medicare.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Obat(
    var id: Int? = null,
    var nama: String?,
    var bentuk: String?,
    var satuan: String?,
    var status: Int?,
    var description: String?,
    var paket: Int?,
    var selected: Boolean = false
) : Parcelable