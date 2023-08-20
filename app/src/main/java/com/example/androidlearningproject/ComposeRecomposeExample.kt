package com.example.androidlearningproject

import android.os.CountDownTimer
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.w3c.dom.Text

@OptIn(ExperimentalMaterial3Api::class)
@Preview()
@Composable
fun ComposeRecomposeExample() {
        var colors = listOf(Color.Yellow,Color.Magenta,Color.Black,Color.Green)
        var totalBoxes by remember{ mutableStateOf(0) }
        var textState by remember{ mutableStateOf("") }

        LaunchedEffect(key1 = Unit, block = {


        })

        Column {
                TextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = textState, onValueChange = { text->
                        textState = text
                        totalBoxes = text.toIntOrNull()?:0
                } )

                LazyRow(){
                        (0 until totalBoxes).forEach {currentIndex->
                                item {
                                        if (currentIndex%2==0){
                                                Text(text = "$currentIndex")
                                        }else{
                                                Box(modifier = Modifier
                                                        .height(50.dp)
                                                        .width(50.dp)
                                                        .background(color = colors.random()))

                                        }

                                }
                        }
                }

                Text(text = "$totalBoxes", fontSize = 30.sp)
        }
}

@Preview(showSystemUi = true)
@Composable
fun ColumnSplit(){
        Column(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(color = Color.Green)) {
                Box(modifier = Modifier.fillMaxWidth().background(color = Color.Cyan).weight(1F))
                Spacer(modifier = Modifier.fillMaxWidth().background(color = Color.LightGray).weight(1F))
                Box(modifier = Modifier.fillMaxWidth().background(color = Color.Yellow).weight(1F))
        }
}

@Preview(showSystemUi = true)
@Composable
fun OrderOfModifier(){
        Column(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(20.dp)
                .background(color = Color.Green)
                .padding(20.dp)
                .background(color = Color.Green)
        ){

        }
}