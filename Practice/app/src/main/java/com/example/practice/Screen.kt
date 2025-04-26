package com.example.practice

sealed class Screen(val route: String) {
    data object Home : Screen("home_screen")
    data object Details : Screen("details_screen/{name}")
}