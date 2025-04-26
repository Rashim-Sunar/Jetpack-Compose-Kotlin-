package com.example.textfield

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.textfield.ui.theme.TextfieldTheme
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.OutlinedTextField
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType

// MainActivity class - Entry point of the application
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Enables edge-to-edge UI rendering
        setContent {
            TextfieldTheme {
                Greeting() // Calls the composable function to render the UI
            }
        }
    }
}

// Composable function that contains the UI
@Composable
fun Greeting() {
    Column(
        modifier = Modifier.fillMaxSize(), // Makes the column take the full screen size
        horizontalAlignment = Alignment.CenterHorizontally, // Centers content horizontally
        verticalArrangement = Arrangement.Center // Centers content vertically
    ){
        // Mutable state to hold text field value
        var text by remember {
            mutableStateOf("Type here...") // Default text in the text field
        }

        val maxChar: Int = 20 // Maximum character limit for the text field

        OutlinedTextField(
            value = text, // The current text in the field
            onValueChange = { newText ->
                if(newText.length <= maxChar){  // Restricts input to maxChar limit
                    text = newText
                }
            },

            label = {
                Text(text = "Title", color = Color.Blue) // Label inside the text field
            },
            singleLine = true, // Ensures the text field stays single-line

            // Leading icon (before the text input)
            leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Filled.Email, // Email icon
                        contentDescription = "Email Icon"
                    )
                }
            },

            // Trailing icon (after the text input)
            trailingIcon = {
                IconButton(onClick = {
                    Log.d("Trailing icon", "clicked") // Logs when icon is clicked
                }) {
                    Icon(
                        imageVector = Icons.Filled.Check, // Check icon
                        contentDescription = "Email icon"
                    )
                }
            },

            // Keyboard options
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email, // Sets keyboard type to email
                imeAction = ImeAction.Go // Displays "Go" button on keyboard
            ),
            keyboardActions = KeyboardActions(
                onGo = {
                    Log.d("ImeAction", "clicked") // Logs when "Go" button is pressed
                }
            )
        )
    }
}

// Preview function to see UI changes in Android Studio without running the app
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TextfieldTheme {
        Greeting()
    }
}
