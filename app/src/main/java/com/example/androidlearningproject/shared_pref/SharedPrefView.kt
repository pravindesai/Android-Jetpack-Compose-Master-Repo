package com.example.androidlearningproject.shared_pref

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@Composable
fun SharedPrefView(modifier: Modifier = Modifier,
                   viewModel: SharedPrefViewModel,
                   ) {
    val context = LocalContext.current

    LaunchedEffect(key1 = viewModel){
        (1..100).forEach{
            SessionManager.saveInt(it.toString(),it)
        }

        (1..100).forEach{
            PrefDataStoreManager.getDataStore(context)?.let { it1 ->
                PrefDataStoreManager.saveStringValue(
                    it1,it.toString(),it.toString())
            }
        }
    }


}
