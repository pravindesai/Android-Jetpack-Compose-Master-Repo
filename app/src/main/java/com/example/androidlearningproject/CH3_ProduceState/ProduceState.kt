package com.example.androidlearningproject.CH3_ProduceState

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow

//  * produceState
//  Use it to convert non-Compose state into Compose state
//  val produceState = produceState(initialValue = Result.Loading , producer =FLOW returning api data Result )

val numberFlow = flow<Int> {
    (1..100).forEach {
        emit(it)
        delay(1000)
    }
}
@Composable
fun ProduceState(modifier: Modifier = Modifier) {
    val flowToState = produceState(initialValue = 0){
        numberFlow.collectLatest {
            value = it
        }
    }
    Column {
        TextC(state = flowToState.value.toString())
    }
}


@Composable
fun TextC(state:String){
    Text(text = state)
}