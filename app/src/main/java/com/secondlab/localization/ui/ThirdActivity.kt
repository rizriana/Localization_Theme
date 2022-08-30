package com.secondlab.localization.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.secondlab.localization.R
import dagger.hilt.android.AndroidEntryPoint

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
    }
}