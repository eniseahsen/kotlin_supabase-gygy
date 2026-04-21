package eu.tutorials.supabaseproject.navigation

sealed class Screen(val route: String){
    object Home: Screen("home")
    object Add: Screen("add")
}