package com.example.androidlearningproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.example.androidlearningproject.CH3_DERIVED_STATE.DerivedAndOtherStates
import com.example.androidlearningproject.CH3_ProduceState.ProduceState
import com.example.androidlearningproject.ch3_Remebersavable.RememberSavableVsViewModel
import com.example.androidlearningproject.navigation.NavigationComposable
import com.example.androidlearningproject.ui.theme.AndroidLearningProjectTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidLearningProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                     NavigationComposable()
                       RememberSavableVsViewModel()
//                    ComposeRecomposeExample()
//                    StateLessVsStateFullCountersExample(viewModel = hiltViewModel())
//                    StateAndRemember()
//                    SideEffects()
//                    RememberSavableExample()
//                    DerivedAndOtherStates()
//                    ProduceState()
                }
            }
        }
    }
}
