package com.secondlab.localization.preference

import android.content.Context
import android.content.SharedPreferences

class SettingPreferences(context: Context) {
    companion object {
        const val PREFERENCE_NAME = "pref"
        const val PREFERENCE_LANGUAGE = "language"
        const val PREFERENCE_THEME = "theme"
    }

    private val preferences: SharedPreferences =
        context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)

    fun setLang(lang: String) {
        val editor = preferences.edit()
        editor.apply {
            putString(PREFERENCE_LANGUAGE, lang)
            apply()
        }
    }

    fun setTheme(theme: Boolean) {
        val editor = preferences.edit()
        editor.apply {
            putBoolean(PREFERENCE_THEME, theme)
            apply()
        }
    }

    fun loadLang(): String? {
        return preferences.getString(PREFERENCE_LANGUAGE, "en")
    }

    fun loadTheme(): Boolean {
        return preferences.getBoolean(PREFERENCE_THEME, false)
    }
}