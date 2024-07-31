package com.curiozing.searchui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.curiozing.searchui.R
import com.curiozing.searchui.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}