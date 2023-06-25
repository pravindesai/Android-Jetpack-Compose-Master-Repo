package com.example.androidlearningproject.CH3_ProduceState

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import kotlinx.coroutines.flow.asFlow

//  * produceState
//  Use it to convert non-Compose state into Compose state
//  val produceState = produceState(initialValue = Result.Loading , producer =FLOW returning api data Result )

fun numberFlow() = (1..100)
@Composable
fun ProduceState(modifier: Modifier = Modifier) {
//    val flowToState = produceState(initialValue = 0, producer = numberFlow(), key1 = Unit)
    Column {

    }
}


@Composable
fun TextC(state:String){
    Text(text = state)
}