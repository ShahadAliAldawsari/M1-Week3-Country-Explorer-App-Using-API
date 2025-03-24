@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.m1week3countryexplorerappusingapi.ExplorerApp.PresentationLayer.UI


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.m1week3countryexplorerappusingapi.ExplorerApp.DataLayer.City
import com.example.m1week3countryexplorerappusingapi.ExplorerApp.DataLayer.Country
import com.example.m1week3countryexplorerappusingapi.ExplorerApp.DataLayer.State
import com.example.m1week3countryexplorerappusingapi.ExplorerApp.Navigation.CitiesNavScreen
import com.example.m1week3countryexplorerappusingapi.ExplorerApp.Navigation.StatesNavScreen
import com.example.m1week3countryexplorerappusingapi.R


//to deal with this error: This material API is experimental and is likely to change or to be removed in the future.
@ExperimentalMaterial3Api
@Composable
fun TopBar(
    /*scrollBehavior: TopAppBarScrollBehavior,*/
    isDark: MutableState<Boolean>, title: String
) {
    TopAppBar(
//        scrollBehavior = scrollBehavior,
        colors = TopAppBarDefaults.topAppBarColors(
            MaterialTheme.colorScheme.primaryContainer,
        ),
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineMedium,
                fontFamily = FontFamily.Serif,
                fontWeight = SemiBold
            )
        },

        //menu icon at the beginning of the bar
        navigationIcon = {
            Icon(
                imageVector = Icons.Rounded.Menu,
                contentDescription = "menu icon",
                modifier = Modifier
                    .padding(8.dp)
                    .width(32.dp)
                    .height(32.dp),
                tint = MaterialTheme.colorScheme.onSurface
            )
        },

        actions = {
            //dark & light themes switcher icon at the end of the bar
            // dark mode icon before the end of the bar
//            var isDark by remember { mutableStateOf(false) }
            Button(
                onClick = { isDark.value = !isDark.value },
                modifier = Modifier.padding(0.dp),
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.buttonColors(Color.Transparent)

            ) {
                val screenModeIcon = if (isDark.value) R.drawable.sun else R.drawable.moon
                Icon(
                    painter = painterResource(id = screenModeIcon),
                    contentDescription = "search icon",
                    modifier = Modifier
                        .padding(0.dp)
                        .width(28.dp)
                        .height(28.dp),
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    )
}

@Composable
fun Item(name: String, code3: String?, onNavigation: () -> Unit) {
    Button(
        modifier = Modifier
            .padding(0.dp)
            .background(Color.Transparent)
            .fillMaxWidth(),
        onClick = {
            onNavigation()
        },
        colors = ButtonDefaults.buttonColors(Color.Transparent)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
                .padding(16.dp, 4.dp, 16.dp, 4.dp),
            colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primaryContainer),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
            ) {

                Text(
                    text = name,
                    modifier = Modifier
                        .padding(8.dp),
                    style = MaterialTheme.typography.titleLarge,
                    fontFamily = FontFamily.Serif,
                    )

                Spacer(Modifier.width(4.dp))

                if (code3 != null) {
                    Text(
                        text = code3,
                        modifier = Modifier
                            .wrapContentSize(Alignment.Center)
                            .padding(8.dp),
                        style = MaterialTheme.typography.titleLarge,
                        fontFamily = FontFamily.Serif,
                    )
                }
            }
        }
    }
}


@Composable
fun CountriesScreen(
    title: String, countries: List<Country>,
    isDark: MutableState<Boolean>, navCtrl: NavHostController
) {
    Scaffold(
        topBar = {
            TopBar(
                title = title,
                isDark = isDark
            )
        }
    )
    { topPaddingValue ->
        LazyColumn(
            modifier = Modifier
                .padding(top = topPaddingValue.calculateTopPadding() + 8.dp)
                .fillMaxWidth()
        ) {
            items(items = countries) { country ->
                Item(name = country.countryName, code3 = country.countryCode3, onNavigation = {
                    navCtrl.navigate(StatesNavScreen(countryCode3 = country.countryCode3))
                })
            }
        }
    }
}

@Composable
fun StatesScreen(
    title: String, states: List<State>,
    isDark: MutableState<Boolean>, navCtrl: NavHostController
) {
    Scaffold(
        topBar = {
            TopBar(
                title = title,
                isDark = isDark
            )
        }
    )
    { topPaddingValue ->
        LazyColumn(
            modifier = Modifier
                .padding(top = topPaddingValue.calculateTopPadding() + 8.dp)
                .fillMaxWidth()
        ) {
            items(items = states) { state ->
                Item(name = state.stateName.toString(), code3 = state.stateCode3.toString(), onNavigation = {
                    navCtrl.navigate(CitiesNavScreen(stateCode3 = state.stateCode3.toString()))
                })
            }
        }
    }
}

@Composable
fun CitiesScreen(
    title: String, cities: List<City>,
    isDark: MutableState<Boolean>, navCtrl: NavHostController
) {
    Scaffold(
        topBar = {
            TopBar(
                title = title,
                isDark = isDark
            )
        }
    )
    { topPaddingValue ->
        LazyColumn(
            modifier = Modifier
                .padding(top = topPaddingValue.calculateTopPadding() + 8.dp)
                .fillMaxWidth()
        ) {
            items(items = cities) { city ->
                Item(name = city.toString(), code3 = null, onNavigation = {
                    navCtrl.navigate(CitiesNavScreen(stateCode3 = null.toString()))
                })
            }
        }
    }
}