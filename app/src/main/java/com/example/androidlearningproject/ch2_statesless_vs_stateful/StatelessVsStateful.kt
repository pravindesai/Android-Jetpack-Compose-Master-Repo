package com.example.androidlearningproject.ch2_statesless_vs_stateful

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun StateLessVsStateFullCountersExample(
    modifier: Modifier = Modifier,
    viewModel: Ch2StateViewModel
) {
    Column(modifier = Modifier
        .padding(20.dp)
        .fillMaxWidth()
        .fillMaxHeight(),
        verticalArrangement = Arrangement.Center) {

        Text(text = "StatelessStepper")
        //Stateless
        StateLessStepper(
            currentStep = viewModel.stepperState.value,
            onAddSteps = {
                viewModel.addSteps()
            },
            onReduceSteps = {
                viewModel.reduceSteps()
            }
        )

        Spacer(modifier = modifier.height(50.dp))

        Text(text = "StateFullStepper")
        //StateFullStepper
        StateFullStepper()
    }

}


@Preview
@Composable
fun StateLessStepper(modifier: Modifier = Modifier,
                     currentStep:Int = 0,
                     onAddSteps:() ->Unit = {},
                     onReduceSteps:() -> Unit = {}) {

    Row(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Button(modifier = Modifier.weight(1f),
            onClick = {
                onAddSteps()
            }) {
            Text( text = "+")
        }

        Text(
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(1f),text = "$currentStep")

        Button(modifier = Modifier.weight(1f),
            onClick = {
                onReduceSteps()
            }) {
            Text(text = "-")
        }
    }

}

@Preview
@Composable
fun StateFullStepper(modifier: Modifier = Modifier, onStepsChange:(step:Int)-> Unit = {}) {
    val steps = remember { mutableStateOf(0) }

    Row(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Button(modifier = Modifier.weight(1f),
            onClick = {
                steps.value = steps.value.plus(1)
                onStepsChange(steps.value)
        }) {
            Text( text = "+")
        }

        Text(
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(1f),
            text = "${steps.value}")

        Button(modifier = Modifier.weight(1f),
            onClick = {
                steps.value = steps.value.minus(1)
                onStepsChange(steps.value)
        }) {
            Text(text = "-")
        }
    }

}