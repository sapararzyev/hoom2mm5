package com.example.hoom2mm5

import androidx.lifecycle.MutableLiveData
import com.example.hoom2mm5.model.ColculateModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repozitory @Inject constructor(private var api: ColculateApi ) {

    fun makeRequest(sekondName : String,firstName: String): MutableLiveData<ColculateModel> {
        val liveData = MutableLiveData<ColculateModel>()
       api.getPerecentage(sekondName, firstName).enqueue(
            object : Callback<ColculateModel> {
                override fun onResponse(
                    call: Call<ColculateModel>,
                    response: Response<ColculateModel>,
                ) {
                       liveData.postValue(response.body())
                }
                override fun onFailure(call: Call<ColculateModel>, t: Throwable) {
                } })
        return liveData
    }
}