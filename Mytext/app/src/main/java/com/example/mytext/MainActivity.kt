package com.example.mytext

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.layout.FlowRowScopeInstance.weight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.mytext.ui.theme.MytextTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MytextTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Red)

                ) {
                    CustomText(text = "Hello world")
                    CustomText2()
                    CreateBox()
                }
            }
        }
    }
}

@Composable
fun CustomText(text : String){
    Text(
        text = text,
        modifier = Modifier
            .background(Color.Blue)
            .width(120.dp)
            .padding(10.dp, 20.dp),
        textAlign = TextAlign.End,
        color = Color.White
    )
}

@Composable
fun CustomText2(){
    Text(
        text = "Aakash ".repeat(50),
        modifier = Modifier
            .background(Color.Cyan)
            .width(200.dp),
        fontSize = 10.sp,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
fun CreateBox(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center

    ){
        Box(
            modifier = Modifier
                .width(100.dp)
                .height(50.dp)
                .background(Color.Yellow)
                .verticalScroll(rememberScrollState())
        ){
            Text(
                text = "Hello world is the best word for programmers.",
                overflow = TextOverflow.Ellipsis

            )
        }
    }
}

@Preview (showBackground = true)
@Composable
fun DefaultPreview(){
    MytextTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Red)
        ) {
            CustomText(text = "Hello world")
            CustomText2()
            CreateBox()
        }
    }
}