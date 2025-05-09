package com.example.loadinganimation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.loadinganimation.ui.theme.LoadingAnimationTheme
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay


// Here, in this animation, we have three ball bouncing upward in different time(Loading animation)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoadingAnimationTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    LoadingAnimation()
                }
            }
        }
    }
}

@Composable
fun LoadingAnimation(
    modifier: Modifier = Modifier,             // Modifier to customize the layout externally
    circleSize: Dp = 25.dp,                    // Size of each circle
    circleColor: Color = Color.Blue,           // Color of the circles
    spaceBetween: Dp = 10.dp,                  // Space between the circles
    travelDistance: Dp = 20.dp                 // Vertical travel distance for the animation
) {
    // Create a list of three animatable objects to animate each circle individually
    val circles = listOf(
        remember { Animatable(initialValue = 0f) },
        remember { Animatable(initialValue = 0f) },
        remember { Animatable(initialValue = 0f) }
    )

    // Launch animation for each circle with a delay so they animate one after another
    circles.forEachIndexed { index, animatable ->
        LaunchedEffect(null) {
            delay(index * 100L) // Delay animation start for each circle to create a wave effect

            // Animate each circle's vertical movement repeatedly
            animatable.animateTo(
                targetValue = 1f,
                animationSpec = infiniteRepeatable(
                    animation = keyframes {
                        durationMillis = 1200 // Total duration of one cycle
                        0.0f at 0 with LinearOutSlowInEasing    // Start at position 0
                        1.0f at 300 with LinearOutSlowInEasing  // Peak at position 1 (upward)
                        0.0f at 600 with LinearOutSlowInEasing  // Return to position 0
                        0.0f at 1200 with LinearOutSlowInEasing // Stay at 0 till next repeat
                    },
                    repeatMode = RepeatMode.Restart // Repeat the animation from the beginning
                )
            )
        }
    }

    // Map each animatable's current value to a list for UI rendering
    val circleValues = circles.map { it.value }

    // Convert travel distance from Dp to pixels for translation
    val distance = with(LocalDensity.current) { travelDistance.toPx() }

    val lastCircle = circleValues.size - 1 // Index of the last circle (to avoid extra spacing)

    // Draw the row of animated circles
    Row(modifier = modifier) {
        circleValues.forEachIndexed { index, value ->
            Box(
                modifier = Modifier
                    .size(circleSize) // Set size of the circle
                    .graphicsLayer {
                        translationY = -value * distance // Move circle vertically based on animation
                    }
                    .background(
                        color = circleColor,
                        shape = CircleShape // Circle shape
                    )
            )

            // Add spacing between circles, except after the last one
            if (index != lastCircle) {
                Spacer(modifier = Modifier.width(spaceBetween))
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun LoadingAnimationPreview(){
    LoadingAnimation()
}