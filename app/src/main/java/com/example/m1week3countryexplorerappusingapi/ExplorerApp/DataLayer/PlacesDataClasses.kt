package com.example.m1week3countryexplorerappusingapi.ExplorerApp.DataLayer

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable


// Country, code2, code3, statesList
// https://countriesnow.space/api/v0.1/countries/states


// Country, code2, code3, citiesList
// https://countriesnow.space/api/v0.1/countries


// Country, flagUrl, code2, code3
// https://countriesnow.space/api/v0.1/countries/flag/images

@Serializable
data class ApiResponse<T>(
    @SerializedName("error") val error: Boolean,
    @SerializedName("msg") val msg: String,
    @SerializedName("data") val data: T
)

@Serializable
data class Country (
    @SerializedName ("country") val countryName: String,
    @SerializedName ("iso3") val countryCode3: String,
    @SerializedName ("iso2") val countryCode2: String,
    @SerializedName ("cities") val cities: List<String>,
)

@Serializable
data class CountryStates (
    @SerializedName ("name") val countryName: String,
    @SerializedName ("iso3") val countryCode3: String,
    @SerializedName ("iso2") val countryCode2: String,
    @SerializedName ("states") val states: List<State>,
)

@Serializable
data class State (
    @SerializedName ("name") val stateName: String,
    @SerializedName ("state_code") val stateCode3: String,
)

@Serializable
data class City (
    @SerializedName ("cities") val city: String,
)
