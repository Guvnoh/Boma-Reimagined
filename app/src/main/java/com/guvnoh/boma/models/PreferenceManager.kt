package com.guvnoh.boma.models

import android.content.Context
import android.content.SharedPreferences

class PreferenceManager(context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("userId", Context.MODE_PRIVATE)

    fun saveId(key:String, value:String){
        sharedPreferences.edit().putString(key, value).apply()
    }
    fun getUserId(key:String, defaultValue: String = ""): String{
        return sharedPreferences.getString(key, defaultValue)?: defaultValue
    }

    fun clearKey(key:String){
        with(sharedPreferences.edit()){
            remove(key)
            apply()
        }
    }

    fun clearAll(){
        with(sharedPreferences.edit()){
            clear()
            apply()
        }
    }
}