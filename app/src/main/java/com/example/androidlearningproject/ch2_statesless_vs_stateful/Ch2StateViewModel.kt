package com.example.androidlearningproject.ch2_statesless_vs_stateful

import android.view.View
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class Ch2StateViewModel @Inject constructor():ViewModel() {
    val stepperState = mutableStateOf(0)

    fun addSteps(stepSize:Int = 1){
        stepperState.value = stepperState.value.plus(stepSize)
    }

    fun reduceSteps(stepSize:Int = 1){
        stepperState.value = stepperState.value.minus(stepSize)
    }

}