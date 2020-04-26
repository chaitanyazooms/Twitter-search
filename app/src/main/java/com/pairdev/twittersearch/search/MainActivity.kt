package com.pairdev.twittersearch.search

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pairdev.twittersearch.databinding.ActivityMainBinding
import dagger.android.AndroidInjection

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AndroidInjection.inject(this)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
