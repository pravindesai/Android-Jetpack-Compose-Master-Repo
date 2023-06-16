package com.example.androidlearningproject.ch2_state_and_remeber

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun StateAndRemember(modifier: Modifier = Modifier) {

    var counter by remember{ mutableStateOf(1) }
    Log.e("***","Recomopse")
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {

        Text(text = "$counter")
        Button(onClick = {
            counter = counter.plus(1)
        }) {
            Text(text = "click")
        }

        Button(onClick = {
        }) {
            Text(text = "click")
        }
    }

}