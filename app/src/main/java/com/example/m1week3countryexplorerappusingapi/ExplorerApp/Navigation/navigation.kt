package com.example.m1week3countryexplorerappusingapi.ExplorerApp.PresentationLayer.Navigation

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.m1week3countryexplorerappusingapi.ExplorerApp.DataLayer.citiesApiCall
import com.example.m1week3countryexplorerappusingapi.ExplorerApp.DataLayer.countriesApiCall
import com.example.m1week3countryexplorerappusingapi.ExplorerApp.DataLayer.statesApiCall
import com.example.m1week3countryexplorerappusingapi.ExplorerApp.PresentationLayer.UI.CitiesScreen
import com.example.m1week3countryexplorerappusingapi.ExplorerApp.PresentationLayer.UI.CountriesScreen
import com.example.m1week3countryexplorerappusingapi.ExplorerApp.PresentationLayer.UI.StatesScreen
import kotlinx.serialization.Serializable



@Serializable
object CountriesNavScreen

@Serializable
data class StatesNavScreen(
    val countryCode3: String,
)

@Serializable
data class CitiesNavScreen(
    val stateCode3: String,
)

@SuppressLint("StaticFieldLeak")
@Composable
fun Nav(isDark:MutableState<Boolean>) {
    val TAG = "NavComposable"
    val navCtrl = rememberNavController()
    NavHost(
        navController = navCtrl,
        startDestination = CountriesNavScreen,
        builder = {

            composable<CountriesNavScreen> {
                CountriesScreen(
                    title = "Countries",
                    isDark = isDark,
                    navCtrl = navCtrl,
                    countries = countriesApiCall()
                )
            }
            composable<StatesNavScreen>
            { navBackStackEntry ->
                val args = navBackStackEntry.toRoute<StatesNavScreen>()
                Log.d(TAG, "Navigating to States Screen with countryCode3: ${args.countryCode3}")
                StatesScreen(
                    title = "States",
                    isDark = isDark,
                    navCtrl = navCtrl,
                    states = statesApiCall(args.countryCode3)
                )

            }
            composable<CitiesNavScreen>{ navBackStackEntry ->
                val args = navBackStackEntry.toRoute<CitiesNavScreen>()
                Log.d(TAG, "Navigating to Cities Screen with stateCode3: ${args.stateCode3}")
                CitiesScreen(
                    title = "Cities",
                    isDark = isDark,
                    navCtrl = navCtrl,
                    cities = citiesApiCall(args.stateCode3)
                )
            }
        }
    )
}