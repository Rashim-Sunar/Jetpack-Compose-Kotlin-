package com.example.bottom_navigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun MainScreen(){
    val navController  = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomBar(navController = navController)
        }
    ) { paddingValues -> // ✅ Add padding values here
        BottomNavGraph(
            navController = navController,
            padding = Modifier.padding(paddingValues)
        )
    }
}

@Composable
fun BottomBar(
    navController: NavHostController
){
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Profile,
        BottomBarScreen.Settings
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(
        containerColor = Color.Blue,
        contentColor = Color.White
    ) {
        screens.forEach { screen ->
            AddItems(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}

@Composable
fun RowScope.AddItems(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    val isSelected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
    NavigationBarItem( // ✅ Corrected NavigationBarItem usage
        label = { Text(text = screen.title) },
        icon = {
            Icon(
                imageVector = screen.icon,
                contentDescription = screen.title,
//                modifier = if (isSelected) Modifier.background(androidx.compose.ui.graphics.Color.Gray) // ✅ Change Selected Icon Background
//                else Modifier
            )
               },
        selected = isSelected,
        onClick = {
            navController.navigate(screen.route){
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }

                  },
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = Color.White, // ✅ Selected icon color
            unselectedIconColor = Color.White.copy(alpha = 0.7f), // ✅ Unselected icon color
            selectedTextColor = Color.White, // ✅ Selected text color
            unselectedTextColor = Color.White.copy(alpha = 0.7f) // ✅ Unselected text color
        )
    )
}
