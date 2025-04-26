package com.example.superscripttext

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.superscripttext.ui.theme.SuperscriptTextTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperscriptTextTheme {
                Column(
                    modifier = Modifier.fillMaxSize().padding(20.dp, 50.dp)
                ) {
                    SuperScriptText(normalText = "Hello", superText = "World!")
                }
            }
        }
    }
}

@Composable
fun SuperScriptText(normalText: String, superText: String){
    Text(
        buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = 20.sp
                )
            ){
                append(normalText)
            }

            withStyle(
                style = SpanStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    //baselineShift = BaselineShift.Subscript,
                    baselineShift = BaselineShift.Superscript
                )
            ){
                append(superText)
            }
        }
    )
}

@Preview (showBackground = true)
@Composable
fun DefaultPreview(){
    SuperscriptTextTheme {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            SuperScriptText(normalText = "Hello", superText = "World!")
        }
    }
}

