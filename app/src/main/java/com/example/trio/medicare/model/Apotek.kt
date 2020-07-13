package com.example.trio.medicare.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Apotek(
    var id: Int? = null,
    var nama: String?,
    var alamat: String?,
    var open: String?,
    var closed: String?,
    var lat: String?,
    var long: String?,
    var obat_cocok: Int?,
    var keterangan: String?,
    @SerializedName("obat_apotek")
    var obats: List<Obat>
) : Parcelable