package com.example.androidlearningproject.shared_pref

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.datastore.preferences.preferencesDataStoreFile
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull

object PrefDataStoreManager {

    private var dataStore: DataStore<Preferences>? = null

    fun getDataStore(context: Context) = dataStore ?:run{
//        dataStore = context.preferencesDataStore(name = "USER_PREFERENCES_NAME")
        dataStore
    }

    suspend fun saveStringValue(localDataStore: DataStore<Preferences>, key:String, value:String){
        val `stringDataStore-key` = stringPreferencesKey(key)
        localDataStore.edit { pref ->
            pref[`stringDataStore-key`] = value
        }
    }

    suspend fun readStringValue(localDataStore: DataStore<Preferences>, key:String):String?{
        val `stringDataStore-key` = stringPreferencesKey(key)
        val ds = localDataStore.data.firstOrNull()
        return ds?.get(`stringDataStore-key`)
    }

}