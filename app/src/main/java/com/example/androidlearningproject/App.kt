package com.example.androidlearningproject

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App:Application(){
    companion object{
        lateinit var context:Application
    }
    init {
        context = this
    }
}