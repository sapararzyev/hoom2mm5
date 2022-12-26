package com.example.hoom2mm5.model

import com.google.gson.annotations.SerializedName

data class ColculateModel (
    @SerializedName("fname")
    val firstName: String,
    @SerializedName("sname")
    val secondName: String,
    val percentage: String,
    val result: String
    )
