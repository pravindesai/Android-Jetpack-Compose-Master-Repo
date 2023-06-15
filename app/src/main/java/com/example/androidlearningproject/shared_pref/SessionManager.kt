package com.example.androidlearningproject.shared_pref

import android.content.SharedPreferences
import android.util.Log
import com.example.androidlearningproject.App
import com.google.gson.Gson

object SessionManager {
    private val TAG: String = "**"+this::class.java.simpleName

    private val sharedPref: SharedPreferences
    private val editor: SharedPreferences.Editor

    init {
        sharedPref = App.context.getSharedPreferences("SHARED_PREF_FILE", 0)
        editor = sharedPref.edit()
    }

    fun saveBoolean(key:String, value:Boolean){
        editor.putBoolean(key, value)
        editor.commit()
    }

    fun getBoolean(key: String):Boolean = sharedPref.getBoolean(key, false)

    fun saveInt(key:String, value:Int){
        editor.putInt(key, value)
        editor.commit()
    }
    fun getInt(key: String): Int = sharedPref.getInt(key, "".toInt())


    fun saveFloat(key:String, value:Float){
        editor.putFloat(key, value)
        editor.commit()
    }
    fun getFloat(key: String): Float = sharedPref.getFloat(key, "".toFloat())


    fun saveLong(key:String, value:Long){
        editor.putLong(key, value)
        editor.commit()
    }
    fun getLong(key: String): Long = sharedPref.getLong(key, "".toLong())


    fun saveString(key:String, value:String){
        editor.putString(key, value)
        editor.commit()
    }
    fun getString(key: String): String? = sharedPref.getString(key, "")

    fun delete(key: String){
        editor.remove(key)
        editor.commit()
    }

    fun containsKey(key: String):Boolean{
        return sharedPref.contains(key)
    }

    fun <T>save(key:String,user: T){
        val serializedCustomer:String = Gson().toJson(user)
        editor.putString(key, serializedCustomer)
        editor.apply()
    }

    inline fun <reified T>get(key: String):T?{
        val serializedCustomer:String? = getString(key)
        val deserializedCustomer:T? = Gson().fromJson(serializedCustomer, T::class.java)
        return deserializedCustomer
    }

    fun clearSession():Boolean{
        try {
            editor.clear()
            editor.apply()
            return true
        }catch (e:Exception){
            Log.e(TAG, "clearSession: FAILED --> "+e.localizedMessage)
            editor.commit()
            return false
        }
    }
}