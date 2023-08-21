package com.example.androidlearningproject.CompositionLocal

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf

data class User(val name: String, val age: Int)
val LocalActiveUser = compositionLocalOf<User> { error("No user found!") }

@Composable
fun CompositionLocalObj(){
    val user1 = User("User1", 11)
    CompositionLocalProvider(LocalActiveUser provides user1) {
        Level2Composable()
    }
}

@Composable
fun Level2Composable(){
    Level3Composable()
}
@Composable
fun Level3Composable(){
    Column {
        Text(text = LocalActiveUser.current.name)
        Text(text = LocalActiveUser.current.age.toString())
    }
}