package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Column(
                    modifier = Modifier.height(500.dp)
                        .width(500.dp),
//                        .background(Color.Red),
                    // modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
//                    CustomItem(weight = 2f)
//                    CustomItem(weight = 1f, MaterialTheme.colorScheme.secondary)
                    MySurface()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        content = { paddingValues ->
            Text(
                text = "Hello, Compose!",
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(paddingValues)
            )
        }
    )
}

@Composable
fun ColumnScope.CustomItem(weight : Float, color: Color = MaterialTheme.colorScheme.primary){
    Surface(
        modifier = Modifier
            .width(200.dp)
            .weight(weight),
        color = color

    ){}
}

@Composable
fun MySurface() {
    Surface(
        color = Color.LightGray, // Background color
        shape = RoundedCornerShape(8.dp), // Rounded corners
        shadowElevation = 4.dp, // Elevation effect
        modifier = Modifier.padding(8.dp) // Adding padding
    ) {
        Text(text = "Hello, Jetpack Compose!", modifier = Modifier.padding(16.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        Column(
            //modifier = Modifier.fillMaxSize(),
            modifier = Modifier.height(500.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            //verticalArrangement = Arrangement.Center
        ){
//           CustomItem(weight = 2f)
//            CustomItem(weight = 1f, MaterialTheme.colorScheme.secondary)
            MySurface()
        }
    }
}
