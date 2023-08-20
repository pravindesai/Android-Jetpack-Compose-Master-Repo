package com.example.androidlearningproject.navigation

import android.os.Bundle
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androidlearningproject.navigation.NAV_PATH.HOME
import com.example.androidlearningproject.navigation.NAV_PATH.LOGIN
import com.example.androidlearningproject.navigation.NAV_PATH.LOGIN_DATA

object NAV_PATH{
    const val HOME = "HOME"
    const val LOGIN = "LOGIN"
    const val LOGIN_DATA = "LOGIN_DATA"
}
@Preview
@Composable
fun NavigationComposable() {

    val navController = rememberNavController()

    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.Gray)) {

        NavHost(navController = navController, startDestination = LOGIN){

            composable(LOGIN){ backstack ->
                    Column(modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.Yellow),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally) {

                        Button(onClick = {
                            navController.currentBackStackEntry?.savedStateHandle?.set(
                                LOGIN_DATA,
                                "LOGIN_DATA"
                            )
                            navController.navigate(HOME)
                        }) {

                            Text(text = "Click here to login")
                        }

                    }
            }

            composable(HOME){ backstack->
                val backstachData = navController.previousBackStackEntry
                    ?.savedStateHandle?.get<String>(LOGIN_DATA)
                Column(modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.Red),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {

                    val id = backstack.arguments
                    Log.e("***ID ->", "$id")

                    Button(onClick = {
                        navController.popBackStack()
                    }) {
                        Text(text = "Go back")
                    }

                    Text(text = "Previus Login data -> ${backstachData}")
                }
            }
        }

    }
}
@Preview
@Composable
fun demo(){

    var h  by remember { mutableStateOf(50.dp) }
    var w by remember { mutableStateOf(50.dp) }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.Red),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Box(modifier = Modifier
            .height(h)
            .width(w)
            .background(color = Color.Cyan))
        Button(onClick = {
            if (h==50.dp){
                h = 100.dp
                w = 100.dp
            }else{
                h = 50.dp
                w = 50.dp
            }
        }) {
            Text(text = "Click")
        }
    }
}
