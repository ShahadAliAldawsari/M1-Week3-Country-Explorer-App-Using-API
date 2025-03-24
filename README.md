<h1>Countries Explorer App</h1>
<h2>Project Overview</h2>
The Country Explorer App is an Android application built using Jetpack Compose, Retrofit, and modern architectural patterns like Clean Architecture and MVI (Model-View-Intent). It allows users to explore countries, their states, and cities by fetching data from the CountriesNow API.<br>

<h2>Features Implemented</h2>
- Explore Countries: View a list of countries with their names and ISO codes.<br>
- Explore States: Navigate to view states within a selected country.<br>
- Explore Cities: Navigate to view cities within a selected state.<br>
- Dark/Light Theme: Toggle between dark and light themes for better user experience.<br>
- API Integration: Fetch data from the CountriesNow API using Retrofit.<br>
- Clean Architecture: Separation of concerns with clear layers (Data, Domain, Presentation).<br>
- MVI Pattern: Unidirectional data flow for predictable state management.<br>

<h2>Technologies Used</h2>
- Kotlin: Primary programming language.<br>
- Jetpack Compose: Modern UI toolkit for building native Android UI.<br>
- Retrofit: HTTP client for API communication.<br>
- Gson: JSON parsing library.<br>
- OkHttp: HTTP client with logging interceptor for debugging.<br>
- Navigation Compose: Seamless navigation between screens.<br>
- Material Design 3: Modern and customizable UI components.<br>

<h2>Code Structure</h2>
app/<br>
├── src/<br>
│   ├── main/<br>
│   │   ├── java/com/example/m1week3countryexplorerappusingapi/<br>
│   │   │   ├── ExplorerApp/<br>
│   │   │   │   ├── DataLayer/----------------# Data layer (API, models, repositories)<br>
│   │   │   │   ├── DomainLayer/--------------# Domain layer (use cases, interfaces)<br>
│   │   │   │   ├── PresentationLayer/--------# Presentation layer (UI, MVI)<br>
│   │   │   │   │   ├── Navigation/-----------# Navigation components<br>
│   │   │   │   │   ├── UI/-------------------# Composable screens and components<br>
│   │   │   ├── MainActivity.kt---------------# Entry point of the app<br>
│   │   ├── res/------------------------------# Resources (themes, drawables, etc.)<br>


<h2>Setup Instructions</h2>
1- Clone the Repository<br>
2- Open the project in Android Studio (preferably the latest stable version).<br>
3- Sync the project with Gradle files.<br>
4- Build the project using Build > Make Project.<br>
5- Connect an Android device or emulator.<br>
6- Click Run > Run 'app' to launch the app.<br>


