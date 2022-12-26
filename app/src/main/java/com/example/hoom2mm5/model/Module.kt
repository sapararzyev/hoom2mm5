package com.example.hoom2mm5.model

import android.content.Context
import android.content.SharedPreferences
import com.example.hoom2mm5.ColculateApi
import com.example.hoom2mm5.Repozitory
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@dagger.Module
@InstallIn(SingletonComponent::class)

object Module {
    @Provides
    @Singleton
    fun getRepo(): Repozitory {
         return Repozitory(getApi()) }

    @Provides
    @Singleton
    fun getApi(): ColculateApi {
        return getRetrofit().create(ColculateApi::class.java) }

    @Provides
    @Singleton
    fun getRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build() }

    @Singleton
    @Provides
    fun getShared(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("preferences", Context.MODE_PRIVATE) }
}