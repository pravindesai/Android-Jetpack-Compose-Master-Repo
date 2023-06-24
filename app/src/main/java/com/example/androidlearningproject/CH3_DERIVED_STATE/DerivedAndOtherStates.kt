package com.example.androidlearningproject.CH3_DERIVED_STATE

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun DerivedAndOtherStates(modifier: Modifier = Modifier) {
    //  * derivedState
    //  should be used when your state or key is changing more than you want to update your UI
    val userName = remember { mutableStateOf("") }
    val derivedState = remember { derivedStateOf { userName.value.length } }

    //  * produceState
    //  Use it to convert non-Compose state into Compose state
    //  val produceState = produceState(initialValue = Result.Loading , producer =FLOW returning api data Result )

    //  * rememberUpdatedState
    //  rememberUpdatedState is used when we want to keep an updated reference to a variable in a
    // long-running side-effect without having the side-effect to restart on recomposition


}

