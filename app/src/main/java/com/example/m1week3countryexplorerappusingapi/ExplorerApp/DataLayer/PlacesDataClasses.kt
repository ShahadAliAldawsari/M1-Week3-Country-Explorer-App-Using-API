package com.example.m1week3countryexplorerappusingapi.ExplorerApp.DataLayer

import com.google.gson.annotations.SerializedName


// Country, code2, code3, statesList
// https://countriesnow.space/api/v0.1/countries/states


// Country, code2, code3, citiesList
// https://countriesnow.space/api/v0.1/countries


// Country, flagUrl, code2, code3
// https://countriesnow.space/api/v0.1/countries/flag/images

data class ApiResponse<T>(
    @SerializedName("error") val error: Boolean,
    @SerializedName("msg") val msg: String,
    @SerializedName("data") val data: T
)

data class Country (
    @SerializedName ("name") val countryName: String,
    @SerializedName ("iso3") val countryCode3: String,
    @SerializedName ("iso2") val countryCode2: String,
    @SerializedName ("states") val states: List<String>,
)

data class State (
    @SerializedName ("name") val stateName: String,
    @SerializedName ("state_code") val stateCode3: String,
)

data class Cities (
    @SerializedName ("cities") val supPlaces: List<String>,
)
