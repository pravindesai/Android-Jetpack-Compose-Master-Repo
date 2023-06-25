package com.example.androidlearningproject.CH3_DERIVED_STATE

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay
import org.w3c.dom.Text

@Composable
fun DerivedAndOtherStates(modifier: Modifier = Modifier) {
    //  * derivedState
    //  should be used when your state or key is changing more than you want to update your UI
    val userName = remember { mutableStateOf("ABCD") }
    val derivedState = remember { derivedStateOf { userName.value.length } }

    Column {
        TextWithoutDerivedState(text = userName.value)
        TextWithDerivedState(len = derivedState.value)
    }

    LaunchedEffect(key1 = Unit, block = {
        (1..5).forEach {
            delay(1000)
            userName.value = userName.value.replace(userName.value.last(),userName.value.last()+1)
        }
    })

    //  * rememberUpdatedState
    //  rememberUpdatedState is used when we want to keep an updated reference to a variable in a
    // long-running side-effect without having the side-effect to restart on recomposition


}

@Composable
fun TextWithoutDerivedState(text: String){
    Log.e("***RECOMPOSE WITHOUT DERIVED", "$text -> ${text.length}")
    Text(text = "LENGHT-> ${text.length.toString()}")
}

@Composable
fun TextWithDerivedState(len:Int){
    Log.e("**********RECOMPOSE WITH DERIVED", "$ -> ${len}")
    Text(text = "LENGHT DERRIVED-> ${len}")

}

