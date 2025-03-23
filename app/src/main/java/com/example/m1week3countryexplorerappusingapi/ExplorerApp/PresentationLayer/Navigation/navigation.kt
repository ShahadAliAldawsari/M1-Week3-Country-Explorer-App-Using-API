package com.example.m1week3countryexplorerappusingapi.ExplorerApp.PresentationLayer.Navigation

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.toRoute
import com.example.m1week3countryexplorerappusingapi.ExplorerApp.DataLayer.citiesApiCall
import com.example.m1week3countryexplorerappusingapi.ExplorerApp.DataLayer.countriesApiCall
import com.example.m1week3countryexplorerappusingapi.ExplorerApp.DataLayer.statesApiCall
import com.example.m1week3countryexplorerappusingapi.ExplorerApp.PresentationLayer.UI.CitiesScreen
import com.example.m1week3countryexplorerappusingapi.ExplorerApp.PresentationLayer.UI.CountriesScreen
import com.example.m1week3countryexplorerappusingapi.ExplorerApp.PresentationLayer.UI.StatesScreen
import kotlinx.serialization.Serializable


@Serializable
object countriesNavScree

@Serializable
data class statesNavScree(
    val countryCode3: String,
)

@Serializable
data class citiesNavScree(
    val stateCode3: String,
)

@SuppressLint("StaticFieldLeak")
@Composable
fun Nav(isDark:MutableState<Boolean>) {
    val TAG = "NavComposable"
    val navCtrl = rememberNavController()
    NavHost(
        navController = navCtrl,
        startDestination = countriesNavScree,
        builder = {
            composable<countriesNavScree> {
                CountriesScreen(
                    title = "Countries",
                    isDark = isDark,
                    navCtrl = navCtrl,
                    countries = countriesApiCall()
                )
            }
            composable(
                route = "statesNavScree/{countryCode3}",
                arguments = listOf(navArgument("countryCode3") { type = NavType.StringType })
            )
            { navBackStackEntry ->
                val countryCode3 = navBackStackEntry.arguments?.getString("countryCode3")
                Log.d(TAG, "Navigating to States Screen with countryCode3: $countryCode3")
                if (countryCode3 != null) {
                    StatesScreen(
                        title = "States",
                        isDark = isDark,
                        navCtrl = navCtrl,
                        states = statesApiCall(countryCode3),
                        countryCode3 = countryCode3
                    )
                }
            }
            composable(
                route = "citiesNavScree/{stateCode3}",
                arguments = listOf(navArgument("stateCode3") { type = NavType.StringType })
            )
            { navBackStackEntry ->
                val stateCode3 = navBackStackEntry.arguments?.getString("stateCode3")
                Log.d(TAG, "Navigating to Cities Screen with stateCode3: $stateCode3")
                if (stateCode3 != null) {
                    CitiesScreen(
                        title = "Cities",
                        isDark = isDark,
                        navCtrl = navCtrl,
                        cities = citiesApiCall(stateCode3),
                        stateCode3 = stateCode3
                    )
                }
            }
        }
    )
}