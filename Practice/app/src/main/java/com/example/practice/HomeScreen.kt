package com.example.practice

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(navController: NavHostController){
    Text(text = "This is Home screen", modifier = Modifier.clickable {navController.navigate(route = "${Screen.Details.route}/Akash Chaudhuri")})
}