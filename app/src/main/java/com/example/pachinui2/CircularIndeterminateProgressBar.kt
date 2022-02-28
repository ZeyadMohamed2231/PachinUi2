package com.example.pachinui2

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CircularIndeterminateProgressBar(isDisplayed: Boolean){
    if(isDisplayed){
        Column(modifier = Modifier
            .border(border = BorderStroke(1.dp, Color.Blue))
            .background(Color.Blue)
            .padding(20.dp)
        ) {
            Text(text = "Loading")

            CircularProgressIndicator()

            Text(text = "HII")




        }

    }


}







