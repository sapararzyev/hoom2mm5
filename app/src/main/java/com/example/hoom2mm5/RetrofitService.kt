package com.example.hoom2mm5

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {

    val retrofitService = Retrofit.Builder()
        .baseUrl("https://love-calculator.p.rapidapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    fun getApi(): ColculateApi{
        return retrofitService.create(ColculateApi::class.java)
    }
}