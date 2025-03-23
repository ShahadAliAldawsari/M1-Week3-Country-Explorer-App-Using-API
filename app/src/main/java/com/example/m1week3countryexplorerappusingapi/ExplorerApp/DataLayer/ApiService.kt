package com.example.m1week3countryexplorerappusingapi.ExplorerApp.DataLayer


import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Query
import java.net.CacheRequest


interface ApiService {
    @GET("countries")
    suspend fun getCountries():ApiResponse<List<Country>>

    @GET("countries/states")
    suspend fun getCountryStates(@Query("countryCode3") countryCode3: String):ApiResponse<List<State>>

    @GET("countries/states/cities")
    suspend fun getCountryStateCities(@Query("stateCode3") stateCode3: String):ApiResponse<List<Cities>>

}

