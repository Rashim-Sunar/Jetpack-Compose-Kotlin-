package com.example.brushwithanimation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.brushwithanimation.ui.theme.BrushWithAnimationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BrushWithAnimationTheme {
                AnimatedGradientBox()
            }
        }
    }
}

@Composable
fun AnimatedGradientBox() {
    // Animation infinite transition
    val infiniteTransition = rememberInfiniteTransition(label = "")

    // Animate a float value for shifting gradient position
    val animatedOffset by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 2000f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 3000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    // Create a dynamic gradient brush
    val animatedBrush = Brush.linearGradient(
        colors = listOf(Color.Magenta, Color.Cyan, Color.Yellow),
        start = Offset(0f, animatedOffset),
        end = Offset(animatedOffset, 0f)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = animatedBrush),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Animated Gradient Background", color = Color.White)
    }
}

@Preview(showBackground = true)
@Composable
fun AnimatedGradientBoxPreview() {
    AnimatedGradientBox()
}