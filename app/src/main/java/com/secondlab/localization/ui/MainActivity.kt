package com.secondlab.localization.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.secondlab.localization.databinding.ActivityMainBinding
import com.secondlab.localization.preference.SettingPreferences
import com.secondlab.localization.utils.LocalizationUtils

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var pref: SettingPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        val pref = SettingPreferences(this)

        binding.apply {
            btnIndonesia.setOnClickListener { reloadActivity("in") }
            btnEnglish.setOnClickListener { reloadActivity("en") }
            btnThailand.setOnClickListener { reloadActivity("th") }
            btnLaunch.setOnClickListener {
                startActivity(Intent(this@MainActivity,I
                    SecondActivity::class.java))
            }
        }

        if (pref.loadTheme()) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            binding.switchTheme.isChecked = true
        }

        binding.switchTheme.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                pref.setTheme(isChecked)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                binding.switchTheme.isChecked = true
            } else {
                pref.setTheme(isChecked)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                binding.switchTheme.isChecked = false
            }
        }
    }

    private fun reloadActivity(lang: String) {
        pref.setLang(lang)
        recreate()
    }

    override fun attachBaseContext(newBase: Context) {
        pref = SettingPreferences(newBase)
        val lang = pref.loadLang()
        super.attachBaseContext(lang?.let { LocalizationUtils.wrap(newBase, it) })
    }

}