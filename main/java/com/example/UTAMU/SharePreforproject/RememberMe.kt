package com.example.UTAMU.SharePreforproject

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences

class RememberMe(val context: Context) {
    private val PREFS_NAME = "credentials"
    private val sharedPref: SharedPreferences =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor = sharedPref.edit()

    @SuppressLint("CommitPrefEdits")
    fun remember(text: String, KEY_TOKEN: String) {

        editor.putString("KEY_NAME", text)
        editor.putString("KEY_TOKEN", KEY_TOKEN)
        editor.apply()
    }

    fun getValueString(KEY_NAME: String): String? = sharedPref.getString(KEY_NAME, null)

    fun clearSharedPreference() {
        editor.clear()
        editor.commit()
    }

    fun checkingRememberStatus(): Boolean {
        val status = sharedPref.getString("KEY_TOKEN", "null") != "null"
        return status
    }


//    fun save(KEY_NAME: String, value: Int) {
//        val editor: SharedPreferences.Editor = sharedPref.edit()
//
//        editor.putInt(KEY_NAME, value)
//
//        editor.commit()
//    }
//
//
//    fun getValueInt(KEY_NAME: String): Int = sharedPref.getInt(KEY_NAME, 0)
//
//    fun save(KEY_NAME: String, status: Boolean) {
//
//        val editor: SharedPreferences.Editor = sharedPref.edit()
//
//        editor.putBoolean(KEY_NAME, status!!)
//
//        editor.commit()
//    }
//
//    fun getValueBoolien(KEY_NAME: String, defaultValue: Boolean): Boolean = sharedPref.getBoolean(KEY_NAME, defaultValue)


//
//    fun removeValue(KEY_NAME: String) {
//
//        val editor: SharedPreferences.Editor = sharedPref.edit()
//
//        editor.remove(KEY_NAME)
//        editor.commit()
//    }
}

