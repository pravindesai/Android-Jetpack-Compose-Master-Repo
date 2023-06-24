package com.example.androidlearningproject.ch3_Remebersavable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/***
 * The rememberSaveable API is a wrapper around remember that can store data in a Bundle
 * This API allows state to survive not only recomposition, but also activity recreation and system-initiated process death.
 */
@Composable
fun RememberSavableExample(modifier: Modifier = Modifier) {

    var counter by remember{ mutableStateOf(1) }
    var savableCounter by rememberSaveable{ mutableStateOf(1) }

    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        Text(text = "$counter")
        Button(onClick = {
            counter = counter.plus(1)
        }) {
            Text(text = "click")
        }

        Spacer(modifier = modifier.height(50.dp))

        Text(text = "Savable: $savableCounter")
        Button(onClick = {
            savableCounter = savableCounter.plus(1)
        }) {
            Text(text = "click")
        }
    }

}