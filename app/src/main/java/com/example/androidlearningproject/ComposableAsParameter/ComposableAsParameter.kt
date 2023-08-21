package com.example.androidlearningproject.ComposableAsParameter

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ComposableAsParameter(
    modifier: Modifier = Modifier,
    view1:@Composable() () ->Unit = {},
    view2:@Composable() () ->Unit = {},
) {
    Column (modifier){
       view1()
       view2()
    }
}