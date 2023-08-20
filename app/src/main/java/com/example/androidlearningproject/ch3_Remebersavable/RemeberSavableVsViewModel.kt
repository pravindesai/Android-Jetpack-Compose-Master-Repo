package com.example.androidlearningproject.ch3_Remebersavable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

class RememberSavableVsViewModelVM:ViewModel(){
    var vmSavable = mutableStateOf(0)
}

@Composable
fun RememberSavableVsViewModel(vm:RememberSavableVsViewModelVM = hiltViewModel()) {

    var remeberText by remember{ mutableStateOf(0) }
    var remeberSavableText by rememberSaveable{ mutableStateOf(0) }

    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {

        Text(text = "Remember-> "+remeberText.toString(), modifier = Modifier.fillMaxWidth())
        Text(text = "RememberSavable-> "+remeberSavableText.toString(), modifier = Modifier.fillMaxWidth())
        Text(text = "stateInVM-> "+vm.vmSavable.value.toString(), modifier = Modifier.fillMaxWidth())
        Button(onClick = {
            remeberText += 1
            remeberSavableText += 1
            vm.vmSavable.value = vm.vmSavable.value.plus(1)

        }) {
            Text(text = "INCREMENT")
        }
    }
}