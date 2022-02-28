package com.example.pachinui2


import androidx.compose.foundation.background
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
            .background(Color.White)
            .padding(horizontal = 30.dp, vertical = 10.dp)
        ) {
            Text(text = "Loading...")
            Spacer(modifier = Modifier.padding(5.dp))
            CircularProgressIndicator()
        }
    }
}







