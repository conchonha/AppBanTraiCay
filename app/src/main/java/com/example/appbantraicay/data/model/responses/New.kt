package com.example.appbantraicay.data.model.responses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class New(
    @Expose @SerializedName("id") var id: Int,
    @Expose @SerializedName(
        "hinhbaiviet"
    ) var hinhbaiviet: String,
    @Expose @SerializedName("tenbaiviet") var tenbaiviet: String,
    @Expose @SerializedName(
        "noidung"
    ) var noidung: String,
    @Expose @SerializedName("thoigian") var thoigian: String
)