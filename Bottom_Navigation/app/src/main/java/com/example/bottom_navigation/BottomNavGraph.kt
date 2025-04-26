package com.example.bottom_navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun BottomNavGraph(
    navController: NavHostController,
    padding: Modifier
){
    NavHost(
        navController = navController,
        startDestination =BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route){
            Home()
        }

        composable(route = BottomBarScreen.Profile.route){
            Profile()
        }

        composable(route = BottomBarScreen.Settings.route){
            Settings()
        }
    }
}