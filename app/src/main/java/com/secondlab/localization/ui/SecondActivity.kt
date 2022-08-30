package com.secondlab.localization.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.secondlab.localization.R
import com.secondlab.localization.databinding.ActivitySecondBinding
import dagger.hilt.android.AndroidEntryPoint

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLaunch.setOnClickListener {
            startActivity(Intent(this, ThirdActivity::class.java))
        }
    }
}