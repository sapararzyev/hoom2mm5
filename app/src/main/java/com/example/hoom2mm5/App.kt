package com.example.hoom2mm5

import android.app.Application

class App:Application() {
    companion object{
        lateinit var api: ColculateApi
    }
    override fun onCreate() {
        super.onCreate()
        val retrofit = RetrofitService()
        api = retrofit.getApi()
    }
}