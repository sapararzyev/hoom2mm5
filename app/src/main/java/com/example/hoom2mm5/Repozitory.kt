package com.example.hoom2mm5

import android.util.Log
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repozitory {

    fun makeRequest(sekondName : String,firstName: String): MutableLiveData<ColculateModel> {
        
        val liveData = MutableLiveData<ColculateModel>()
        App.api.getPerecentage(sekondName, firstName).enqueue(
            object : Callback<ColculateModel> {
                override fun onResponse(
                    call: Call<ColculateModel>,
                    response: Response<ColculateModel>,
                ) {
                       liveData.postValue(response.body())

                }
                override fun onFailure(call: Call<ColculateModel>, t: Throwable) {

                }
            }
        )
        return liveData
    }
}