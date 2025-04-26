package com.example.practice

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavGraph(navController : NavHostController){
    NavHost(navController = navController, startDestination = "home_screen" ) {
        composable(route = Screen.Home.route){
            HomeScreen(navController)
        }

        composable(route = "${Screen.Details.route}/{name}"){
            val name = it.arguments?.getString("name") ?: "Unknown"
            DetailScreen(navController, name)
        }
    }
}