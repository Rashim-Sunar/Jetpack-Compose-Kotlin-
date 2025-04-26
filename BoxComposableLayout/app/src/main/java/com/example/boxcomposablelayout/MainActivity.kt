package com.example.boxcomposablelayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.boxcomposablelayout.ui.theme.BoxComposableLayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BoxComposableLayoutTheme {
                CreateBox()
            }
        }
    }
}

@Composable
fun CreateBox(){
    Box(
        modifier = Modifier
            .background(Color.Red)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .background(Color.Blue)
                .verticalScroll(rememberScrollState()),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = "Hello world is my fav word.",
                fontSize = 34.sp
            )
        }
    }
}

@Preview (showBackground = true)
@Composable
fun DefaultPreview(){
    BoxComposableLayoutTheme {
        CreateBox()
    }
}
