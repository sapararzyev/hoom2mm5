package com.example.hoom2mm5

import com.example.hoom2mm5.model.ColculateModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


interface ColculateApi {
    @GET("getPercentage")
    fun getPerecentage(
        @Query("sname") secondName: String,
        @Query("fname") firstName: String,
        @Header("X-RapidAPI-Key") Key : String = "018edc51c1mshb117e9da4daae38p17734fjsn25b9109b0cf1",
        @Header("X-RapidAPI-Host") host: String = "love-calculator.p.rapidapi.com"
    ): Call<ColculateModel>
}