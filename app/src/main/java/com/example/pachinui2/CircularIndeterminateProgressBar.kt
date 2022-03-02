package com.example.pachinui2


import android.icu.text.CaseMap



import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp


@Composable
fun CircularIndeterminateProgressBar(isDisplayed: Boolean){
    val context = LocalContext.current
    if(isDisplayed){
        Row(modifier = Modifier
            .background(Color.White)
            .padding(horizontal = 30.dp, vertical = 10.dp)
        ) {
            CircularProgressIndicator()
            Spacer(modifier = Modifier.padding(20.dp))
            Text(text = context.getString(R.string.loading), modifier = Modifier.padding(vertical = 10.dp))
        }
    }
}







