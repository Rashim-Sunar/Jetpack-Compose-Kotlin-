package com.example.practice

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun DetailScreen(navController : NavHostController, name: String?){
    Column {
        Text(text = "This is the detail screen" , modifier = Modifier.clickable {
            navController.popBackStack()
            navController.navigate(Screen.Home.route) })
        Text(text = "Hello , $name")
    }
}
