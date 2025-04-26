package com.example.lazycolumn_stickyheader

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.lazycolumn_stickyheader.ui.theme.LazyColumnStickyHeaderTheme

/**
 * LazyColumn:
 * - A vertically scrolling list in Jetpack Compose, optimized for performance.
 * - Similar to RecyclerView but easier to use.
 * - Only renders items that are currently visible on the screen, improving efficiency.
 *
 * StickyHeader:
 * - A special header that stays "stuck" at the top while scrolling until another header replaces it.
 * - Useful for categorizing items (e.g., sections in a list).
 */

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class) // Enables experimental API for sticky headers
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Enables full-screen edge-to-edge display

        setContent {
            LazyColumnStickyHeaderTheme { // Applying the app theme
                val sections = listOf("A", "B", "C", "D", "E", "F", "G") // List of sections

                LazyColumn(
                    contentPadding = PaddingValues(all = 12.dp), // Adds padding around the entire list
                    verticalArrangement = Arrangement.spacedBy(12.dp) // Adds spacing between list items
                ) {
                    sections.forEach { section -> // Loop through each section to create headers and items

                        // Sticky header for each section
                        stickyHeader {
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth() // Make the header span full width
                                    .background(Color.LightGray) // Background color for visibility
                                    .padding(12.dp), // Padding inside the header
                                text = "Section $section" // Display section name
                            )
                        }

                        // Generate 10 items under each section
                        items(10) { itemIndex ->
                            Text(
                                text = "Item-$itemIndex from section-$section", // Display item with section name
                                modifier = Modifier.padding(8.dp) // Padding around items
                            )
                        }
                    }
                }
            }
        }
    }
}

