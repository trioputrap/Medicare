package com.example.trio.medicare.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Resep(
    var id: Int? = null,
    var dokter: String?,
    var faskes: String?,
    var date: String?,
    var status: Int?,
    var obat_tersisa: Int?,
    var long: Int?,
    var jumlah_obat: Int?,
    @SerializedName("recipe_obat")
    var obats: List<Obat>
) : Parcelable