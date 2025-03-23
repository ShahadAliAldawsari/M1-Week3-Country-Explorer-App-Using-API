package com.example.m1week3countryexplorerappusingapi.ExplorerApp.DataLayer

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance{
    private lateinit var instance: Retrofit
    private val loggingInterceptor=HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    private fun getInstance ():Retrofit{
        if(!::instance.isInitialized) {
            val okHttpClient = OkHttpClient.Builder()
                .addNetworkInterceptor(loggingInterceptor)
                .build()
            instance = Retrofit.Builder()
                .baseUrl("https://countriesnow.space/api/v0.1/") ///api/v0.1/countries/states
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()

        }
        return instance
    }
    fun getApiService(): ApiService = getInstance().create(ApiService::class.java)
}

















