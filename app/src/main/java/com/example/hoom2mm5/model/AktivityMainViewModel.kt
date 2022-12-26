package com.example.hoom2mm5.model

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.hoom2mm5.Repozitory
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AktivityMainViewModel @Inject constructor(private var repozitory: Repozitory, private val prefs: SharedPreferences): ViewModel() {

    fun getRequest(firstName : String , secontName: String):LiveData<ColculateModel>{
      return  repozitory.makeRequest(firstName,secontName)
    }

    fun saveBoardState(){
        prefs.edit().putBoolean("isShow",true).apply()
    }
    fun isBoardShow(): Boolean{
        return prefs.getBoolean("isShow",false)
    }
}