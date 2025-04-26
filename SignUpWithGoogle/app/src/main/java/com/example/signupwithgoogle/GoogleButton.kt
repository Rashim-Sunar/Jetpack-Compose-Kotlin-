package com.example.signupwithgoogle

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun GoogleButton(
    text: String =  "Sign up with Google",
    loadingText: String = "Creating account...",
    icon: Painter = painterResource(id = R.drawable.ic_google_logo),
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
    shape: RoundedCornerShape = RoundedCornerShape(8.dp),
    borderColor : Color = Color.LightGray,
    progressIndicatorColor : Color = MaterialTheme.colorScheme.primary,
    onClicked : () -> Unit
) {
    var clicked by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier
            .clickable { clicked = !clicked },
        shape = shape,
        border = BorderStroke(width = 1.dp, color = borderColor),
        color = backgroundColor
    ) {
       Row(
           modifier = Modifier
               .padding(
                   start = 12.dp,
                   end = 16.dp,
                   top = 12.dp,
                   bottom = 12.dp
               )
               .animateContentSize(
                   animationSpec = tween(
                       durationMillis = 300,
                       delayMillis = 100,
                       easing = LinearOutSlowInEasing
                   )
               ),
           verticalAlignment = Alignment.CenterVertically,
           horizontalArrangement = Arrangement.Center
       ) {
           Icon(
               painter = icon,
               contentDescription = "Google Button",
               tint = Color.Unspecified
           )

           Spacer(modifier = Modifier.padding(8.dp))

           Text(
               text = if(clicked) loadingText else text
           )

           if(clicked){
               Spacer(modifier = Modifier.padding(12.dp))
               CircularProgressIndicator(
                   modifier = Modifier
                       .height(16.dp)
                       .width(16.dp),
                   strokeWidth = 2.dp,
                   color = progressIndicatorColor
               )

               onClicked()
           }
       }
    }
}

@Composable
@Preview
private fun GoogleButtonPreview() {
    GoogleButton(
        text = "Sign up with google",
        loadingText = "Creating your account....",
        onClicked = {

        }
    )
}
