package com.example.appbantraicay.data.model.responses;

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/*
    Copyright © 2022 UITS CO.,LTD
    Created by SangTB on 5/18/2022
*/
data class Category(
    @SerializedName("id")
    @Expose
    var id: Int? = null,

    @SerializedName("ten")
    @Expose
    var name: String? = null,

    @SerializedName("hinhicon")
    @Expose
    var iconImage: String? = null
){
    override fun toString(): String {
        return "id: $id \n ten: $name \n hinhicon: $iconImage"
    }
}
