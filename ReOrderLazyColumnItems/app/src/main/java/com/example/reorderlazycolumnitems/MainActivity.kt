package com.example.reorderlazycolumnitems

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.reorderlazycolumnitems.ui.theme.ReOrderLazyColumnItemsTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ReOrderLazyColumnItemsTheme {
               var items by remember{
                  mutableStateOf(
                      listOf("Java", "Kotlin", "Python", "Go", "Javascript", "C++")
                  )
               }

                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(items, { it }){
                        Text(
                            text = "I love $it!",
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.LightGray.copy(alpha = 0.2f))
                                .padding(24.dp)
                                .animateItem(),
                            fontWeight = FontWeight.Bold
                        )
                    }

                    item {
                        Button(
                            modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp),
                           onClick = {items = items.shuffled()}
                        ) {
                            Text("Shuffle")
                        }
                    }
                }
            }
        }
    }
}