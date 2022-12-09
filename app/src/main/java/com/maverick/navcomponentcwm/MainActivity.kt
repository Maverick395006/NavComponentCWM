package com.maverick.navcomponentcwm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.maverick.navcomponentcwm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}