package com.example.m1week3countryexplorerappusingapi.ExplorerApp.DataLayer


import com.google.gson.annotations.SerializedName
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


interface ApiService {
    @GET("countries")
    suspend fun getCountries(): ApiResponse<List<Country>>

    @POST("countries/{countryCode3}/states")
    suspend fun getCountryStates(@Query("countryCode3") countryCode3: String): ApiResponse<CountryStates>

    @POST("countries/state/cities")
    suspend fun getCountryStateCities(@Body stateCode3: String): ApiResponse<List<City>>
}

