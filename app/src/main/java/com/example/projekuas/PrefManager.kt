package com.example.projekuas

import android.content.Context
import android.content.SharedPreferences

class PrefManager(context: Context) {

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor = sharedPreferences.edit()

    companion object {
        private const val PREF_NAME = "AppPreferences"
        private const val IS_LOGGED_IN = "is_logged_in"
        private const val USER_TOKEN = "user_token"
        private const val USERNAME = "username"
    }

    // Set login status
    fun setLoginStatus(isLoggedIn: Boolean) {
        editor.putBoolean(IS_LOGGED_IN, isLoggedIn)
        editor.apply()
    }

    // Get login status
    fun isLoggedIn(): Boolean {
        return sharedPreferences.getBoolean(IS_LOGGED_IN, false)
    }

    // Save user token
    fun saveUserToken(token: String) {
        editor.putString(USER_TOKEN, token)
        editor.apply()
    }

    // Get user token
    fun getUserToken(): String? {
        return sharedPreferences.getString(USER_TOKEN, null)
    }

    // Save username
    fun saveUsername(username: String) {
        editor.putString(USERNAME, username)
        editor.apply()
    }

    // Get username
    fun getUsername(): String? {
        return sharedPreferences.getString(USERNAME, null)
    }

    // Clear all preferences
    fun clearPreferences() {
        editor.clear()
        editor.apply()
    }
}
