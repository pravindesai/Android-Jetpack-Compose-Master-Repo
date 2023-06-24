package com.example.androidlearningproject.ch2_sideeffects

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun SideEffects(modifier: Modifier = Modifier){
    var counter by remember{ mutableStateOf(1) }

    Log.e("***","Recompose")

    SideEffect {
        Log.e("***","Side Effect")
    }

    LaunchedEffect(key1 = counter, block ={
        Log.e("***","Launched Effect")
    } )



    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {

        Text(text = "$counter")
        Button(onClick = {
            counter = counter.plus(1)
        }) {
            Text(text = "click")
        }
    }

    DisposableEffect(key1 = counter , effect = {
        onDispose {
            Log.e("***","Disposable Effect")
        }
    } )

}