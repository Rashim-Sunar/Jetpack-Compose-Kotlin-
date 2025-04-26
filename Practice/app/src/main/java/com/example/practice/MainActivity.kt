package com.example.practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.practice.ui.theme.PracticeTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.rotate

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticeTheme {
                Column (
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    VisibleAnimation()
                }
            }
        }
    }
}

enum class BoxStatus{
    Collapsed,
    Expanded
}

@Composable
fun VisibleAnimation(){
    var boxState by remember {
        mutableStateOf(BoxStatus.Collapsed)
    }

    val transition = updateTransition(targetState = boxState, label = "Box Transition")

    val boxColor by transition.animateColor(label = "") { state ->
        if(state == BoxStatus.Expanded) Color.Red else Color.Blue
    }

    val boxSize by transition.animateDp(label = "") {state ->
        if(state == BoxStatus.Expanded) 300.dp else 200.dp

    }

    Box(modifier = Modifier.size(boxSize).background(boxColor).clickable { boxState =  if(boxState == BoxStatus.Expanded) BoxStatus.Collapsed else BoxStatus.Expanded})

}

@Composable
@Preview(showBackground = true)
fun VisibleAnimationPreview(){
    VisibleAnimation()
}