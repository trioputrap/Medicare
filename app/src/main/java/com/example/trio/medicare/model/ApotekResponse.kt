package com.example.trio.medicare.model

import com.google.gson.annotations.SerializedName

data class ApotekResponse(
    @SerializedName("data")
    val apoteks: List<Apotek>
)