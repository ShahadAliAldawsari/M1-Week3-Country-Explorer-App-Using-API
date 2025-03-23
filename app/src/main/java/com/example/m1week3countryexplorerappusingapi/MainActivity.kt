package com.example.m1week3countryexplorerappusingapi

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.m1week3countryexplorerappusingapi.ExplorerApp.PresentationLayer.Navigation.Nav
import com.example.m1week3countryexplorerappusingapi.ui.theme.M1Week3CountryExplorerAppUsingAPITheme

class MainActivity : ComponentActivity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: Activity created")
        enableEdgeToEdge()
        setContent {
            val isDark = remember { mutableStateOf(false) }
            M1Week3CountryExplorerAppUsingAPITheme (darkTheme = !isDark.value){
                Nav(isDark=isDark)
            }
        }
    }
}
