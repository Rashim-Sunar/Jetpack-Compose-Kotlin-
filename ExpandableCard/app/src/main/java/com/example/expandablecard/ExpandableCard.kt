package com.example.expandablecard

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*

@ExperimentalMaterial3Api
@Composable
fun ExpandableCard(){
    var expandableState by remember { mutableStateOf(false)}


    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = FastOutLinearInEasing
                )
            ),

        shape = RoundedCornerShape(8.dp),
        onClick = {
            expandableState = !expandableState
        }
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ){
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    modifier = Modifier.weight(7f),
                    text = "My Title",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis
                )
                IconButton(
                    modifier = Modifier
                        .weight(1f)
                        .rotate(if (expandableState) 180f else 0f), // Rotate arrow when expanded
                    onClick = {
                        expandableState = !expandableState
                    }
                ) {
                    Icon(
                        modifier = Modifier.size(32.dp),
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Drop Down Arrow")
                }
            }

            if (expandableState) {
                Spacer(modifier = Modifier.height(8.dp)) // Space between the title and description
                Text(
                    text = "This is the expandable content inside the card." +
                            "This is the expandable content inside the card." +
                            "This is the expandable content inside the card." +
                            "This is the expandable content inside the card." +
                            "This is the expandable content inside the card." +
                            "This is the expandable content inside the card.",
                    fontSize = 17.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Normal,
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis
                )
            }

        }
    }
}

@ExperimentalMaterial3Api
@Preview (showBackground = true)
@Composable
fun DefaultPreview(){
    ExpandableCard()
}