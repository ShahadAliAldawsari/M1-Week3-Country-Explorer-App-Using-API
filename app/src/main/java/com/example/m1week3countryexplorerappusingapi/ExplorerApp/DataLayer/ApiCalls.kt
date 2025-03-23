package com.example.m1week3countryexplorerappusingapi.ExplorerApp.DataLayer

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun countriesApiCall(): List<Country> {
    val apiService = RetrofitInstance.getApiService()
    var countries by remember {
        mutableStateOf(emptyList<Country>())
    }

    LaunchedEffect(Unit) {
        val TAG = "CountriesApiCall"
        try {
            Log.d(TAG, "Fetching countries...")
            val response = apiService.getCountries()
            if (!response.error) {
                countries = response.data
                Log.d(TAG, "Countries fetched: ${countries.size}")
            }else{
                Log.d(TAG, "Error fetching countries: ${response.msg}")
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error in countriesApiCall: ${e.message}")
        }
    }
    return countries
}

@Composable
fun statesApiCall(countryCode3: String): List<State> {
    val apiService = RetrofitInstance.getApiService()
    var states by remember {
        mutableStateOf(emptyList<State>())
    }

    LaunchedEffect(Unit) {
        try {
            val response = apiService.getCountryStates(countryCode3)
            if (!response.error) {
                states = response.data
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error in statesApiCall: ${e.message}")
        }
    }
    return states
}


@Composable
fun citiesApiCall(stateCode3: String): List<Cities> {
    val apiService = RetrofitInstance.getApiService()
    var cities by remember {
        mutableStateOf(emptyList<Cities>())
    }

    LaunchedEffect(Unit) {
        try {
            val response = apiService.getCountryStateCities(stateCode3)
            if (!response.error) {
                cities = response.data
            }
        } catch (e: Exception) {
            Log.d(TAG, "Error fetching citiesApiCall: ${e.message}")

        }
    }
    return cities
}

