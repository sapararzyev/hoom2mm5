package com.example.hoom2mm5

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class AktivityMainViewModel: ViewModel() {

    val repozitory = Repozitory()

    fun getRequest(firstName : String , secontName: String):LiveData<ColculateModel>{
      return  repozitory.makeRequest(firstName,secontName)
    }
}