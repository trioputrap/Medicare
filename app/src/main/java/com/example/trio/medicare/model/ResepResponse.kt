package com.example.trio.medicare.model

import com.google.gson.annotations.SerializedName

data class ResepResponse(
    @SerializedName("data")
    val reseps: List<Resep>
)